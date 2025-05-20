package com.example.satya.ws;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import jakarta.xml.soap.SOAPConstants;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
		System.out.println("Inside ServletRegistrationBean iniialization");
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/services/*");
	}
	
	@Bean
    public SaajSoapMessageFactory messageFactory() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.setSoapVersion(SoapVersion.SOAP_11);
        return messageFactory;
    }
	
	
	
	@Bean(name = "personServiceWsdl")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema personSchema) {
		System.out.println("Inside DefaultWsdl11Definition iniialization");
		
		
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("PersonInformationServicePort");
		wsdl11Definition.setLocationUri("/services/personServiceWsdl");
		wsdl11Definition.setTargetNamespace("http://com.example.satya.vo");
		wsdl11Definition.setSchema(personSchema);		    
		//wsdl11Definition.setCreateSoap12Binding(true); 
		return wsdl11Definition;
	}
	 
	
	/*
	@Bean(name = "personServiceWsdl")
	public SimpleWsdl11Definition simpleWsdl11Definition() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource("PersonalInformatinService.wsdl"));
		return wsdl11Definition;
	}
	
	*/

	@Bean
	public XsdSchema personSchema() {
		System.out.println("Inside Person Schema initialization");
		return new SimpleXsdSchema(new ClassPathResource("persons.xsd"));
	}
	
}
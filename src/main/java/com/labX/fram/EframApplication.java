package com.labX.fram;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.labX.fram.component.ComponentFactory;
import com.labX.fram.service.ServiceFactory;

@SpringBootApplication
public class EframApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(EframApplication.class, args);
		SampleDataGen bean = applicationContext.getBean(SampleDataGen.class);
		bean.gen();
	}

	@Bean
	public ServiceLocatorFactoryBean commandFactory(){
		ServiceLocatorFactoryBean loaderFactoryBean = new ServiceLocatorFactoryBean();
		loaderFactoryBean.setServiceLocatorInterface(ComponentFactory.class);
		return loaderFactoryBean;
	}

	@Bean
	public ServiceLocatorFactoryBean dataServiceFactory(){
		ServiceLocatorFactoryBean loaderFactoryBean = new ServiceLocatorFactoryBean();
		loaderFactoryBean.setServiceLocatorInterface(ServiceFactory.class);
		return loaderFactoryBean;
	}

}

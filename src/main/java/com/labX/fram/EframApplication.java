package com.labX.fram;

import com.labX.fram.command.CommandFactory;
import com.labX.fram.service.DataServiceFactory;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class EframApplication {

	public static void main(String[] args) {
		SpringApplication.run(EframApplication.class, args);
	}

	@Bean
	public ServiceLocatorFactoryBean commandFactory(){
		ServiceLocatorFactoryBean loaderFactoryBean = new ServiceLocatorFactoryBean();
		loaderFactoryBean.setServiceLocatorInterface(CommandFactory.class);
		return loaderFactoryBean;
	}

	@Bean
	public ServiceLocatorFactoryBean dataServiceFactory(){
		ServiceLocatorFactoryBean loaderFactoryBean = new ServiceLocatorFactoryBean();
		loaderFactoryBean.setServiceLocatorInterface(DataServiceFactory.class);
		return loaderFactoryBean;
	}

}

package com.spring.boot.ng;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Application configuration class.
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan({ "com.spring.boot.ng" })
public class App extends WebMvcConfigurerAdapter{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
		return hemf.getSessionFactory();
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
	  registry.addMapping("/*")
	   	  .allowedOrigins("*")
		  .allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE")
		  .allowedHeaders("X-Auth-Token", "Content-Type")
		  .exposedHeaders("Accept, Content-Type")
		  .allowCredentials(false)
		  .maxAge(4800);
	}
}

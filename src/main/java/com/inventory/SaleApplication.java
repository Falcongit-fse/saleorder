package com.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class SaleApplication {
	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	public static void main(String[] args) {
		SpringApplication.run(SaleApplication.class, args);
	}
	@Bean	
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/ims/*"))
				.apis(RequestHandlerSelectors.basePackage("com.inventory"))
				.build();
	}
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		//RestTemplate restTemplate =new RestTemplate();
		RestTemplate restTemplate = restTemplateBuilder.basicAuthentication("susmitha", "susmitha").build();
		return restTemplate;
	}

}

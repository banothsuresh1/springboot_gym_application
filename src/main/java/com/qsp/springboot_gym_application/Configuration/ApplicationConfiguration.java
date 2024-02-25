package com.qsp.springboot_gym_application.Configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfiguration {
	
	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("Cult-Fit", "www.cult-fit.com", "cult-fit@email.com");
		List<VendorExtension> vendorExtension = new ArrayList<>();

		ApiInfo apiInfo = new ApiInfo("Gym", "gym application for offline workouts", "1.01", "www.cult_fit.com", (springfox.documentation.service.Contact) contact,
				"1 year free service", "www.cult_fit.com", vendorExtension);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.qsp.springboot_gym_application")).build()
				.apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
	


}

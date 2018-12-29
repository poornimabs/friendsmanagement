package org.socialnetwork.apis.friendsmanagement.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* Swagger API Configuration
*
* @author  Poornima.BS
* @version 1.0
* @since   1.0 
*/


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/**
	* @return Docket
	*/
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());                                           
    }
	
	/**
	* @return ApiInfo
	*/
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Friends Management", 
	      "API that does simple \"Friends Management\"", 
	      "API TOS", 
	      "Terms of service", 
	      new Contact("Poornima BS", "https://github.com/PoornimaBS" ,"poornimabs.gs31@gmail.com"), 
	      "License of API", "API license URL", Collections.emptyList());
	}

}

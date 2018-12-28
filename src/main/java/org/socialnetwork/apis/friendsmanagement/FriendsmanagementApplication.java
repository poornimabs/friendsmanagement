package org.socialnetwork.apis.friendsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
* Spring Boot Main Class
*
* @author  Poornima.BS
* @version 1.0
* @since   2018-12-28 
*/

@SpringBootApplication
@Import({
	SwaggerConfig.class
})
public class FriendsmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendsmanagementApplication.class, args);
	}

}


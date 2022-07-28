package com.getarrays.userservice;

import com.getarrays.userservice.domain.Role;
import com.getarrays.userservice.domain.User;
import com.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "nam", "nam14", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "khoi", "khoi14", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "viet", "viet14", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "minh", "minh14", "1234", new ArrayList<>()));

			userService.addRoleToUser("minh14", "ROLE_USER");
			userService.addRoleToUser("minh14", "ROLE_MANAGER");
			userService.addRoleToUser("minh14", "ROLE_ADMIN");
			userService.addRoleToUser("khoi14", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("khoi14", "ROLE_USER");
			userService.addRoleToUser("khoi14", "ROLE_MANAGER");
			userService.addRoleToUser("nam14", "ROLE_USER");
			userService.addRoleToUser("nam14", "ROLE_ADMIN");
			userService.addRoleToUser("viet14", "ROLE_USER");
			userService.addRoleToUser("viet14", "ROLE_SUPER_ADMIN");
		};
	}
}

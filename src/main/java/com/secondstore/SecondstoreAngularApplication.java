package com.secondstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.secondstore.config.SecurityUtility;
import com.secondstore.domain.User;
import com.secondstore.domain.security.Role;
import com.secondstore.domain.security.UserRole;
import com.secondstore.service.UserService;

@SpringBootApplication
public class SecondstoreAngularApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SecondstoreAngularApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User();
		user1.setFirstName("Soham");
		user1.setLastName("Chakraborty");
		user1.setUsername("SC");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("sohamc@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
		
		userRoles.clear();
		
		User user2 = new User();
		user2.setFirstName("Admin");
		user2.setLastName("Admin");
		user2.setUsername("admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user2.setEmail("admin@gmail.com");
		Role role2 = new Role();
		role2.setRoleId(0);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2, role2));
		
		userService.createUser(user2, userRoles);
		
	}

}

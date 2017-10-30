package com.myexample101.my_spring_data_jpa;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myexample101.my_spring_data_jpa.config.ApplicationConfig;
import com.myexample101.my_spring_data_jpa.entity.user.User;
import com.myexample101.my_spring_data_jpa.service.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes = {ApplicationConfig.class})
public class JunitTest {
    @Autowired
    private UserService userService;
	@Test
	public void test() {
		for(int i=1;i<10;i++){
			User user = new User();
			user.setId(100L+i);
			user.setLastname("hello world "+i);
			userService.save(user);	
		}
		List<User> list = userService.findAll();
		for(User user:list){
			System.out.println(user);
		}
//		userRepository.findByLastname("hello");
	}
	
}
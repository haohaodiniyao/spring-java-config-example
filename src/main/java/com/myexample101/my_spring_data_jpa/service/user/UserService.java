package com.myexample101.my_spring_data_jpa.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myexample101.my_spring_data_jpa.entity.user.User;
import com.myexample101.my_spring_data_jpa.repository.user.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Transactional
	public void save(User user){
		userRepository.save(user);
//		int a = 1/0;
	}
	public List<User> findAll(){
		return userRepository.findAll();
	}
}

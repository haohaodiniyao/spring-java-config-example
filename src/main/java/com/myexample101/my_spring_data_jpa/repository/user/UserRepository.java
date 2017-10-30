package com.myexample101.my_spring_data_jpa.repository.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myexample101.my_spring_data_jpa.entity.user.User;

public interface UserRepository extends JpaRepository<User,Long> {
	List<User> findByLastname(String lastname);
}
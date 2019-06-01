package com.ccgg.FinalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccgg.FinalProject.beans.User;

//@RestResource(path="users", rel="users")
public interface UserDao extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
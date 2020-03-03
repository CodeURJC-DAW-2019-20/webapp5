package com.lcdd.backend.dbrepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcdd.backend.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByName(String name);
}

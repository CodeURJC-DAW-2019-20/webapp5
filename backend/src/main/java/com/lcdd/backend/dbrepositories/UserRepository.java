package com.lcdd.backend.dbrepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcdd.backend.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}

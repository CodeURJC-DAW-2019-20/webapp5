package com.lcdd.backend.dbrepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcdd.backend.pojo.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}

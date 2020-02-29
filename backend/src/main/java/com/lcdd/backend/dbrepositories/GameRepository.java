package com.lcdd.backend.dbrepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcdd.backend.pojo.Game;
import com.lcdd.backend.pojo.User;

public interface GameRepository extends JpaRepository<Game, Long> {
	//Game findByAcronym(String acronym);
}

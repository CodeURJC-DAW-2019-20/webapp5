package com.lcdd.backend.dbrepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcdd.backend.pojo.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	//Game findByAcronym(String acronym);
	
	Game findById(long id);
}

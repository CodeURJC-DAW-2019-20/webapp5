package com.lcdd.backend.dbrepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcdd.backend.pojo.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

}

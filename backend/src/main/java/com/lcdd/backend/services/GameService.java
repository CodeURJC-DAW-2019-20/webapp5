package com.lcdd.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lcdd.backend.dbrepositories.GameRepository;
import com.lcdd.backend.pojo.Game;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	public Game findById(long id) {
		return repository.findById(id);
	}

	public List<Game> findAll() {
		return repository.findAll();
	}
	public void save(Game game) {
		repository.save(game);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public Page<Game> findAllPages(int page, int size) {
		return repository.findAll(PageRequest.of(page,size));
	}
	
	public long count() {
		return repository.count();
	}
}

package com.lcdd.backend.dbrepositories;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lcdd.backend.pojo.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	@Query("SELECT g.acronym, COUNT(e) FROM Event e JOIN e.game g GROUP BY e.game")
	List<Object[]> countGamesEvent();
	
	Page<Event> findAll(Pageable page);
	Event findByName(String name);
	Event findById(long id);
	
}

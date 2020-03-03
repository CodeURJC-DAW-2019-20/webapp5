package com.lcdd.backend.dbrepositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lcdd.backend.pojo.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
	
	@Query("SELECT COUNT(p) FROM Purchase p WHERE month(p.date) = month(?1) AND year(p.date) = year(?1) GROUP BY month(p.date)")
	Integer lastYearPurchasesByMonth(Date date);
}

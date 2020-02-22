package com.lcdd.backend.dbrepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcdd.backend.pojo.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}

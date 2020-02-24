package com.lcdd.backend.dbrepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcdd.backend.pojo.MerchType;

public interface MerchTypeRepository extends JpaRepository<MerchType, Long> {

}

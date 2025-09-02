package com.account.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.account.service.entities.CampanyEntity;


public interface CampanyRepository extends JpaRepository<CampanyEntity, Long>{

	@Query("FROM campanies WHERE campany_name = :campany_name")	
	CampanyEntity findByCampany_name(String campany_name);	
}

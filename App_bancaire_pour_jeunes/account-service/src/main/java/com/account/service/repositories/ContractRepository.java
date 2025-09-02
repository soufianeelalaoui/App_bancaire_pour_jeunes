package com.account.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.service.entities.ContractEntity;

public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

}

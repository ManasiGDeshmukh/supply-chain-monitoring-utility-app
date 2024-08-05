package com.walmart.supplyChain.Repository;

import com.walmart.supplyChain.Entity.Stores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface StoresRepository extends JpaRepository<Stores, Long> {}
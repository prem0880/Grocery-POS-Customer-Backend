package com.pos.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.customer.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}

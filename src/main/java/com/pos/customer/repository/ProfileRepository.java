package com.pos.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pos.customer.entity.Profile;

@Repository
@Transactional
public interface ProfileRepository extends JpaRepository<Profile,Long>{

}
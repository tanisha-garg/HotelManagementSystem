package com.cg.apps.hotelbooking.guestms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.hotelbooking.guestms.entities.*;

public interface IGuestRepository extends JpaRepository<Guest, Long>{

}

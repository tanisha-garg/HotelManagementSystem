package com.cg.apps.hotelbooking.roomms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.hotelbooking.roomms.entities.Room;

public interface IRoomRepository extends JpaRepository<Room, Long>{

}

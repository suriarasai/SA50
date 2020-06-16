package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ParkingSpace;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Integer>{

}

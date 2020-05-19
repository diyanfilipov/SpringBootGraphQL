package com.spring.graphql.dao.repository

import com.spring.graphql.dao.entity.Vehicle
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}

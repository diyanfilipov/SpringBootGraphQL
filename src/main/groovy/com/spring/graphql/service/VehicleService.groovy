package com.spring.graphql.service

import com.spring.graphql.dao.entity.Vehicle
import com.spring.graphql.dao.repository.VehicleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import java.time.LocalDate
import java.util.stream.Collectors

@Service
class VehicleService {

  @Autowired
  VehicleRepository vehicleRepository

  @Transactional
  Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
    Vehicle vehicle = new Vehicle(
      type: type,
      modelCode: modelCode,
      brandName: brandName,
      launchDate: LocalDate.parse(launchDate)
    )

    vehicleRepository.save(vehicle)
  }

  @Transactional(readOnly = true)
  List<Vehicle> getAllVehicles(final int count) {
    vehicleRepository.findAll().stream().limit(count).collect { it }
  }

  @Transactional(readOnly = true)
  Optional<Vehicle> getVehicle(final int id) {
    vehicleRepository.findById(id)
  }

}

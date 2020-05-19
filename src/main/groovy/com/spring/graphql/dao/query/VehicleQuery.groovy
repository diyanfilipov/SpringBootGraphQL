package com.spring.graphql.dao.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.spring.graphql.dao.entity.Vehicle
import com.spring.graphql.service.VehicleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class VehicleQuery implements GraphQLQueryResolver {

  @Autowired
  VehicleService vehicleService

  List<Vehicle> getVehicles(final int count) {
    vehicleService.getAllVehicles(count)
  }

  Optional<Vehicle> getVehicle(final int id) {
    vehicleService.getVehicle(id)
  }
}

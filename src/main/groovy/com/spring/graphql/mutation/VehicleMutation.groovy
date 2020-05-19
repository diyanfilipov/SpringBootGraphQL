package com.spring.graphql.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.spring.graphql.dao.entity.Vehicle
import com.spring.graphql.service.VehicleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class VehicleMutation implements GraphQLMutationResolver {

  @Autowired
  VehicleService vehicleService

  Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
    vehicleService.createVehicle(type, modelCode, brandName, launchDate)
  }
}

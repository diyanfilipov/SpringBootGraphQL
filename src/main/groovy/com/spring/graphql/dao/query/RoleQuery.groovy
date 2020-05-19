package com.spring.graphql.dao.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.spring.graphql.dao.entity.Role
import com.spring.graphql.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RoleQuery implements GraphQLQueryResolver {

  @Autowired
  RoleService roleService

  List<Role> getRoles(int count) {
    roleService.getRoles(count)
  }

  Optional<Role> getRole(int id) {
    roleService.getRole(id)
  }
}

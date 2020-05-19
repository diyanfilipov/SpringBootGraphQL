package com.spring.graphql.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.spring.graphql.dao.entity.Role
import com.spring.graphql.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RoleMutation implements GraphQLMutationResolver {

  @Autowired
  RoleService roleService

  Role createRole(String name) {
    roleService.createRole(name)
  }
}

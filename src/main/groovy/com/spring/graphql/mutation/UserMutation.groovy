package com.spring.graphql.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.spring.graphql.dao.entity.User
import com.spring.graphql.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserMutation implements GraphQLMutationResolver {

  @Autowired
  UserService userService

  User createUser(String login) {
    userService.createUser(login)
  }

  Optional<User> updateUserRoles(int id, List<String> roles) {
    userService.updateUserRoles(id, roles)
  }
}

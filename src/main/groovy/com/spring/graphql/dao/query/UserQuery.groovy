package com.spring.graphql.dao.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.spring.graphql.dao.entity.User
import com.spring.graphql.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserQuery implements GraphQLQueryResolver {

  @Autowired
  UserService userService

  List<User> getUsers(int count) {
    userService.getUsers(count)
  }

  Optional<User> getUser(int id) {
    userService.getUser(id)
  }
}

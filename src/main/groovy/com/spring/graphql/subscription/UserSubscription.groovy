package com.spring.graphql.subscription

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver
import com.spring.graphql.UserUpdatePublisher
import com.spring.graphql.dao.entity.User
import com.spring.graphql.service.UserService
import groovy.util.logging.Slf4j
import org.reactivestreams.Publisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Slf4j
@Component
class UserSubscription implements GraphQLSubscriptionResolver {

  @Autowired
  UserService userService

  @Autowired
  UserUpdatePublisher userUpdatePublisher

  Publisher<User> subscribeToUserChanges(String login) {
    userUpdatePublisher.getPublisher(login)
  }

  @PostConstruct
  void subscribe() {
    userUpdatePublisher.subscribe()
  }
}

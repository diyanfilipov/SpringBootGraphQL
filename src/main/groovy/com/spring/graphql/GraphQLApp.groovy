package com.spring.graphql

import com.spring.graphql.dao.entity.User
import io.reactivex.subjects.PublishSubject
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class GraphQLApp  {

  static void main(String[] args) {
    SpringApplication.run(GraphQLApp, args)
  }

  @Bean
  PublishSubject<User> userPublisher() {
    PublishSubject.<User>create()
  }

}

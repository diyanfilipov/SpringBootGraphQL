package com.spring.graphql.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ApplicationEventMulticaster
import org.springframework.context.event.SimpleApplicationEventMulticaster
import org.springframework.core.task.SimpleAsyncTaskExecutor

@Configuration
class AsynchronousSpringEventsConfig {

  @Bean(name = "applicationEventMulticaster")
  ApplicationEventMulticaster simpleApplicationEventMulticaster() {
    SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster()

    eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor())
    eventMulticaster
  }
}

package com.spring.graphql

import com.spring.graphql.dao.entity.User
import groovy.util.logging.Slf4j
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Slf4j
@Component
class UserUpdatePublisher {

  @Autowired
  UserUpdateSubscriber userUpdateSubscriber

  @Autowired
  PublishSubject<User> userPublisher

  Flowable<User> getPublisher(String login) {

    userPublisher
      .doOnSubscribe({ c -> println("doOnSubscribe: " + Thread.currentThread()) })
      .doOnNext({ o -> println("doOnNext: " + Thread.currentThread()) })
      .subscribeOn(Schedulers.io())
      .filter({ user -> user.login == login })
      .share()
      .toFlowable(BackpressureStrategy.BUFFER)
  }

  void subscribe() {
    userPublisher.subscribe(userUpdateSubscriber)
  }

  void publish(User user) {
    userPublisher.onNext(user)
  }

}

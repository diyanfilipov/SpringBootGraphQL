package com.spring.graphql

import com.spring.graphql.dao.entity.User
import groovy.util.logging.Slf4j
import io.reactivex.Observer
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import org.springframework.stereotype.Component

import java.util.concurrent.atomic.AtomicReference

@Slf4j
@Component
class UserUpdateSubscriber implements Observer<User> {

  AtomicReference<Disposable> subscriptionRef = new AtomicReference<>()


  @Override
  void onSubscribe(@NonNull Disposable d) {
    println("UserUpdateSubscriber "  + d)
    subscriptionRef.set(d)
  }

  @Override
  void onNext(User user) {
    println("Received User update for [${user.login}]. Roles: ${user.roles*.name}")

  }

  @Override
  void onError(Throwable t) {

  }

  @Override
  void onComplete() {
    log.info('onComplete')
  }
}

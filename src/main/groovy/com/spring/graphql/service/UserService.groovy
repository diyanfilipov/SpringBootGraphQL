package com.spring.graphql.service

import com.spring.graphql.UserUpdatePublisher
import com.spring.graphql.dao.entity.Role
import com.spring.graphql.dao.entity.User
import com.spring.graphql.dao.entity.UserRoles
import com.spring.graphql.dao.repository.RoleRepository
import com.spring.graphql.dao.repository.UserRepository
import com.spring.graphql.dao.repository.UserRolesRepository
import io.reactivex.subjects.PublishSubject
import org.hibernate.ObjectNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService {

  @Autowired
  UserRepository userRepository

  @Autowired
  RoleRepository roleRepository

  @Autowired
  UserRolesRepository userRolesRepository

  @Autowired
  UserUpdatePublisher userUpdatePublisher

  @Transactional
  User createUser(String login) {
    User user = new User(login: login)

    userRepository.save(user)
  }

  @Transactional
  Optional<User> updateUserRoles(int id, List<String> roles) {
    Optional<User> user = getUser(id)

    if (!user.isPresent()) {
      throw new ObjectNotFoundException(id, 'user')
    }

    User currentUser = user.get()
    currentUser.userRoles.each {
      userRolesRepository.delete(it)
    }

    List<UserRoles> userRoles = []
    roles.each {
      Role role = roleRepository.findByName(it)

      if (role) {
        UserRoles newUserRole = new UserRoles(
          user: currentUser,
          role: role
        )
        userRoles << newUserRole

        userRolesRepository.save(newUserRole)
      }
    }

    if (userRoles) {
      currentUser.userRoles = userRoles
      currentUser = userRepository.save(currentUser)

      userUpdatePublisher.publish(currentUser)
    }

    Optional.of(currentUser)
  }

  @Transactional(readOnly = true)
  List<User> getUsers(final int count) {

    if (count < 1) {
      return []
    }

    userRepository.findAll(new PageRequest(0, count)).content
  }

  @Transactional(readOnly = true)
  List<User> getUsers() {
    userRepository.findAll()
  }

  @Transactional(readOnly = true)
  Optional<User> getUser(final int id) {
    userRepository.findById(id)
  }

}

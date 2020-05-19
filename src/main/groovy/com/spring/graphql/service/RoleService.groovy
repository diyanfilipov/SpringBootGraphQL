package com.spring.graphql.service

import com.spring.graphql.dao.entity.Role
import com.spring.graphql.dao.repository.RoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RoleService {

  @Autowired
  RoleRepository roleRepository

  @Transactional
  Role createRole(String name) {
    Role role = new Role(name: name)

    roleRepository.save(role)
  }

  @Transactional(readOnly = true)
  List<Role> getRoles(final int count) {
    roleRepository.findAll().stream().limit(count).collect { it }
  }

  @Transactional(readOnly = true)
  Optional<Role> getRole(final int id) {
    roleRepository.findById(id)
  }

}

package com.spring.graphql.dao.entity

import groovy.transform.EqualsAndHashCode

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Transient

@EqualsAndHashCode
@Entity
class User implements Serializable {

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id

  @Column(name = "login", nullable = false, unique = true)
  String login

  @Column(name = "street", nullable = true)
  String street

  @Column(name = "zipCode", nullable = true)
  String zipCode

  @Column(name = "city", nullable = true)
  String city

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
  List<UserRoles> userRoles

  @Transient
  List<Role> getRoles() {
    userRoles.inject([]) { list, entry ->
      list.add(entry.role)
      list
    } as List<Role>
  }

}

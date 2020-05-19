package com.spring.graphql.dao.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Role implements Serializable {

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id

  @Column(name = "name", nullable = false, unique = true)
  String name

  @OneToMany(fetch = FetchType.EAGER, mappedBy = 'role')
  Set<UserRoles> userRoles
}

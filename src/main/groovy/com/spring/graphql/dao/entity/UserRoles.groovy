package com.spring.graphql.dao.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class UserRoles implements Serializable {

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id

  @ManyToOne
  @JoinColumn(name = 'user_id', nullable = false)
  User user

  @ManyToOne
  @JoinColumn(name = 'role_id', nullable = false)
  Role role
}

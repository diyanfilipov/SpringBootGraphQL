package com.spring.graphql.dao.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Transient
import java.time.LocalDate

@Entity
class Vehicle implements Serializable {

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id

  @Column(name = "type", nullable = false)
  String type

  @Column(name = "model_code", nullable = false)
  String modelCode

  @Column(name = "brand_name")
  String brandName

  @Column(name = "launch_date")
  LocalDate launchDate

  @Transient
  transient String formattedDate

  String getFormattedDate() {

    if (formattedDate) {
      return formattedDate
    }

    formattedDate = launchDate.toString()
    formattedDate
  }
}

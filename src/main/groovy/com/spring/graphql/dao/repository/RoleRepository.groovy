package com.spring.graphql.dao.repository

import com.spring.graphql.dao.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository extends JpaRepository<Role, Integer> {

  Role findByName(String name)
}

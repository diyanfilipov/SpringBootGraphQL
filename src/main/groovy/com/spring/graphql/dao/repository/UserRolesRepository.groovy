package com.spring.graphql.dao.repository


import com.spring.graphql.dao.entity.UserRoles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {
}

package com.project.hyuga.domain.user.domain.repository

import com.project.hyuga.domain.user.domain.User
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<User, UUID>{

    fun findByEmail(email: String): User?
}
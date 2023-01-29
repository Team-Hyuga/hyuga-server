package com.project.hyuga.domain.user.domain.repository

import com.project.hyuga.domain.user.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>{
}
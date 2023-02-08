package com.project.hyuga.global.security.auth

import com.project.hyuga.domain.user.domain.repository.UserRepository
import com.project.hyuga.domain.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByEmail(username) ?: throw UserNotFoundException
        return AuthDetails(user)
    }

}
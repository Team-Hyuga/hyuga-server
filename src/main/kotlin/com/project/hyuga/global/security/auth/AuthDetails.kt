package com.project.hyuga.global.security.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        TODO("Not yet implemented")

    override fun getPassword(): String? = null

    override fun getUsername(): String = TODO("Not yet implemented")

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true

}
package com.project.hyuga.global.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.project.hyuga.global.filter.ExceptionHandlerFilter
import com.project.hyuga.global.filter.JwtAuthenticationFilter
import com.project.hyuga.global.security.jwt.JwtProvider
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtProvider: JwtProvider,
    private val objectMapper: ObjectMapper
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        val jwtFilter = JwtAuthenticationFilter(jwtProvider)
        val exceptionFilter = ExceptionHandlerFilter(objectMapper)
        builder.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(exceptionFilter, JwtAuthenticationFilter::class.java)
    }

}
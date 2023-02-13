package com.project.hyuga.global.filter

import com.project.hyuga.global.security.jwt.JwtProperties
import com.project.hyuga.global.security.jwt.JwtTokenProvider
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationFilter(
    private val jwtTokenProvider: JwtTokenProvider
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = resolveToken(request)

        token?.let {
            val authentication = jwtTokenProvider.authentication(it)
            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }

    private fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(JwtProperties.HEADER)

        if (bearerToken != null && bearerToken.startsWith(JwtProperties.PREFIX)) {
            return bearerToken.substring(JwtProperties.PREFIX.length)
        }
        return null
    }

}
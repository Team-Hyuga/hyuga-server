package com.project.hyuga.global.security.jwt

import com.project.hyuga.domain.user.domain.type.Authority
import com.project.hyuga.global.security.auth.AuthDetailsService
import com.project.hyuga.global.security.exception.ExpiredTokenException
import com.project.hyuga.global.security.exception.InvalidTokenException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtProvider(
    private val authDetailsService: AuthDetailsService,
    private val jwtProperties: JwtProperties
) {

    fun generateToken(id: String, authority: Authority) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setSubject(id)
            .claim(JwtProperties.AUTHORITY_KEY, authority)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000))
            .compact()

    fun authentication(token: String): Authentication {
        val subject = getTokenBody(token).subject
        val userDetails = authDetailsService.loadUserByUsername(subject)

        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getTokenBody(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token)
                .body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw ExpiredTokenException
                else -> throw InvalidTokenException
            }
        }
    }

}
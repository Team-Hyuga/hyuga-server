package com.project.hyuga.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    val secretKey: String,
    val accessExp: Int
) {
    companion object {
        const val HEADER = "Authorization"
        const val PREFIX = "Bearer "
        const val AUTHORITY_KEY = "auth"
    }
}
package com.project.hyuga.global.security.exception

import com.project.hyuga.global.error.exception.BusinessException

object ExpiredTokenException : BusinessException(401, SecurityMessage.EXPIRED_TOKEN)
object InvalidTokenException : BusinessException(401, SecurityMessage.INVALID_TOKEN)


private object SecurityMessage {
    const val EXPIRED_TOKEN = "만료된 JWT입니다."
    const val INVALID_TOKEN = "잘못된 JWT 토큰입니다."
}

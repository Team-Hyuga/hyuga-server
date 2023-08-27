package com.project.hyuga.domain.auth

import com.project.hyuga.global.error.exception.BusinessException

object PasswordMismatchException : BusinessException(401, AuthCodeMessage.UNAUTHORIZATION)

object AuthCodeNotFound : BusinessException(404, AuthCodeMessage.NOT_FOUND)


private object AuthCodeMessage {
    const val UNAUTHORIZATION = "잘못된 비밀번호입니다."
    const val NOT_FOUND = "인증 코드를 찾지 못했습니다."
}

package com.project.hyuga.domain.user.exception

import com.project.hyuga.global.error.exception.BusinessException

object UserNotFoundException : BusinessException(404, UserMessage.NOT_FOUND)

object UserAlreadyExistsException : BusinessException(409, UserMessage.CONFLICT)

private object UserMessage {
    const val NOT_FOUND = "유저를 찾지 못했습니다."
    const val CONFLICT = "유저가 이미 존재합니다."
}

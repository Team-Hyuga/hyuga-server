package com.project.hyuga.domain.user.exception

import com.project.hyuga.global.error.exception.BusinessException
import com.project.hyuga.global.error.exception.ErrorCode

object UserNotFoundException : BusinessException(
    ErrorCode.USER_NOT_FOUND
)
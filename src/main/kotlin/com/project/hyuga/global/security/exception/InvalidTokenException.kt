package com.project.hyuga.global.security.exception

import com.project.hyuga.global.error.exception.BusinessException
import com.project.hyuga.global.error.exception.ErrorCode

object InvalidTokenException : BusinessException(
    ErrorCode.INVALID_TOKEN
)
package com.project.hyuga.global.error.exception

abstract class BusinessException(val errorCode: ErrorCode) : RuntimeException()
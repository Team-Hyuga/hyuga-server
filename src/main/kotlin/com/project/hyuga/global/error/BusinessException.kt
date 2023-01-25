package com.project.hyuga.global.error

abstract class BusinessException(
    val errorProperty: ErrorProperty
): RuntimeException()
package com.project.hyuga.global.error.exception

abstract class BusinessException(
    val status: Int,
    override val message: String
) : RuntimeException() {

    override fun fillInStackTrace() = this
}
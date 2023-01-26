package com.project.hyuga.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {

    BAD_REQUEST(400, "잘못된 입력값"),

    INTERNAL_SERVER_ERROR(500, "서버 에러")

}
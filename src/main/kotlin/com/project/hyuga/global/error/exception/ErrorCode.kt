package com.project.hyuga.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {

    BAD_REQUEST(400, "잘못된 입력값"),

    INVALID_TOKEN(401, "토큰이 올바르지 않음"),
    EXPIRED_TOKEN(401, "토큰이 만료됨"),

    USER_NOT_FOUND(404, "유저를 찾지 못함"),

    INTERNAL_SERVER_ERROR(500, "서버 에러")

}
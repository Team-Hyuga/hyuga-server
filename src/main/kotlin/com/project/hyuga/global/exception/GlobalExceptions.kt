package com.project.hyuga.global.exception

import com.project.hyuga.global.error.exception.BusinessException

object BadRequestException : BusinessException(400, GlobalMessage.BAD_REQUEST)

object MethodNotAllowedException : BusinessException(405, GlobalMessage.METHOD_NOT_ALLOWED)

object InternalServerErrorException : BusinessException(500, GlobalMessage.INTERNAL_SERVER_ERROR)


private object GlobalMessage {
    const val BAD_REQUEST = "잘못된 요청입니다."
    const val METHOD_NOT_ALLOWED = "지원하지 않는 Http 메서드입니다."
    const val INTERNAL_SERVER_ERROR = "서버 에러가 발생했습니다."
}

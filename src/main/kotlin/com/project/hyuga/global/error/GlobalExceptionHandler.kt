package com.project.hyuga.global.error

import com.project.hyuga.global.error.exception.BusinessException
import com.project.hyuga.global.error.response.ErrorResponse
import com.project.hyuga.global.error.exception.ErrorCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    protected fun handleMethodArgumentNotValidException(
        e: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.BAD_REQUEST
        return ResponseEntity
            .status(errorCode.status)
            .body(ErrorResponse.of(errorCode, e.bindingResult))
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    protected fun handleMethodArgumentTypeMismatchException(
        e: MethodArgumentTypeMismatchException
    ): ResponseEntity<ErrorResponse> {
        val errorCode = ErrorCode.BAD_REQUEST
        return ResponseEntity
            .status(errorCode.status)
            .body(ErrorResponse.of(errorCode))
    }

    @ExceptionHandler(BusinessException::class)
    protected fun handleBusinessException(
        e: BusinessException
    ): ResponseEntity<ErrorResponse> {
        val errorCode = e.errorCode
        return ResponseEntity
            .status(errorCode.status)
            .body(ErrorResponse.of(errorCode))
    }

}
package com.project.hyuga.global.error

import com.project.hyuga.global.error.exception.BusinessException
import com.project.hyuga.global.error.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException::class)
    protected fun handleBindException(
        e: BindException
    ) = ErrorResponse.of(e.bindingResult)

    /**
     * HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우
     * request body의 데이터가 유효하지 않을 경우
     * @Valid
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    protected fun handleMethodArgumentNotValidException(
        e: MethodArgumentNotValidException
    ) = ErrorResponse.of(e.bindingResult)

    /**
     * query string 유효성 검사, 엔티티의 필드에 붙은 @NotNull
     * @Validated
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException::class)
    protected fun handleConstraintViolationException(
        e: ConstraintViolationException
    ) = ErrorResponse.of(e)

    /**
     * enum type 일치하지 않아 binding 못할 경우 발생
     * 주로 @RequestParam enum으로 binding 못했을 경우 발생
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    protected fun handleMethodArgumentTypeMismatchException(
        e: MethodArgumentTypeMismatchException
    ) = ErrorResponse.of(e)

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    protected fun handleHttpRequestMethodNotSupportedException(
        e: HttpRequestMethodNotSupportedException
    ) = ErrorResponse.of(e)

    @ExceptionHandler(BusinessException::class)
    protected fun handleBusinessException(
        e: BusinessException
    ) = ErrorResponse.of(e)
}
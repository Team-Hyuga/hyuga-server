package com.project.hyuga.global.error.response

import com.project.hyuga.global.error.exception.ErrorCode
import org.springframework.validation.BindingResult

data class ErrorResponse(
    val status: Int,
    val message: String,
    val validationErrors: List<ValidationError>
) {

    companion object {
        fun of(errorCode: ErrorCode) = ErrorResponse(
                status = errorCode.status,
                message = errorCode.message,
                validationErrors = emptyList()
            )

        fun of(errorCode: ErrorCode, bindingResult: BindingResult) = ErrorResponse(
                status = errorCode.status,
                message = errorCode.message,
                validationErrors = ValidationError.of(bindingResult)
            )
    }

}

package com.project.hyuga.global.error.response

import com.project.hyuga.global.error.exception.BusinessException
import com.project.hyuga.global.error.response.FieldError.Companion.of
import com.project.hyuga.global.exception.BadRequestException
import com.project.hyuga.global.exception.MethodNotAllowedException
import org.springframework.validation.BindingResult
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.validation.ConstraintViolationException

data class ErrorResponse(
    val status: Int,
    val message: String,
    val fieldErrors: List<FieldError>
) {

    companion object {

        fun of(bindingResult: BindingResult) = of(
            e = BadRequestException,
            fieldErrors = FieldError.of(bindingResult)
        )

        fun of(e: MethodArgumentTypeMismatchException): ErrorResponse {
            val value = e.value
            val fieldErrors = of(
                field = e.parameter.parameterName ?: "",
                value = value.toString(),
                reason = "${e.requiredType!!.name} 잘못된 타입입니다."
            )

            return of(
                e = BadRequestException,
                fieldErrors = fieldErrors
            )
        }

        fun of(e: ConstraintViolationException): ErrorResponse {
            val fieldErrors: MutableList<FieldError> = mutableListOf()
            val iterator = e.constraintViolations.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                fieldErrors.add(
                    FieldError(
                        field = next.propertyPath.toString(),
                        value = next.invalidValue.toString() ?: "",
                        reason = next.message
                    )
                )
            }
            return of(
                e = BadRequestException,
                fieldErrors = fieldErrors
            )
        }

        fun of(e: HttpRequestMethodNotSupportedException) = of(
            e = MethodNotAllowedException,
            fieldErrors = emptyList()
        )

        fun of(e: BusinessException) = ErrorResponse(
            status = e.status,
            message = e.message,
            fieldErrors = emptyList()
        )

        private fun of(e: BusinessException, fieldErrors: List<FieldError>) = ErrorResponse(
            status = e.status,
            message = e.message,
            fieldErrors = fieldErrors
        )
    }
}

data class FieldError(
    val field: String,
    val value: String,
    val reason: String
) {

    companion object {

        fun of(bindingResult: BindingResult): List<FieldError> {
            val filedErrors = bindingResult.fieldErrors
            return filedErrors.map {
                FieldError(
                    field = it.field,
                    value = it.rejectedValue.toString(),
                    reason = it.defaultMessage!!
                )
            }
        }

        fun of(field: String, value: String, reason: String): List<FieldError> {
            val fieldErrors: MutableList<FieldError> = mutableListOf()
            fieldErrors.add(FieldError(field, value, reason))
            return fieldErrors
        }
    }
}
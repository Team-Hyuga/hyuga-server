package com.project.hyuga.global.error.response

import org.springframework.validation.BindingResult

data class ValidationError(
    val field: String,
    val value: String,
    val reason: String
) {

    companion object {
        fun of(bindingResult: BindingResult): List<ValidationError> {
            val fieldErrors = bindingResult.fieldErrors
            return fieldErrors
                .map { error ->
                    ValidationError(
                        field = error.field,
                        value = error.rejectedValue.toString() ?: "",
                        reason = error.defaultMessage!!
                    )
                }
        }
    }

}
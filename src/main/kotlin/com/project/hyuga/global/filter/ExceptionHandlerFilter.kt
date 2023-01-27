package com.project.hyuga.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.project.hyuga.global.error.exception.BusinessException
import com.project.hyuga.global.error.exception.ErrorCode
import com.project.hyuga.global.error.response.ErrorResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionHandlerFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: BusinessException) {
            setErrorResponse(e.errorCode, response)
        } catch (e: Exception) {
            println(e.printStackTrace())
            setErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, response)
        }
    }

    private fun setErrorResponse(errorCode: ErrorCode, response: HttpServletResponse) {
        val errorResponse = ErrorResponse.of(errorCode)

        response.status = errorCode.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }

}
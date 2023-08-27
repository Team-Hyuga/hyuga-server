package com.project.hyuga.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.project.hyuga.global.error.exception.BusinessException
import com.project.hyuga.global.error.response.ErrorResponse
import com.project.hyuga.global.exception.InternalServerErrorException
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
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
        } catch (e: Exception) {
            when (e) {
                is BusinessException -> setErrorResponse(response, e)
                else -> {
                    e.printStackTrace()
                    setErrorResponse(response, InternalServerErrorException)
                }
            }
        }
    }

    private fun setErrorResponse(
        response: HttpServletResponse,
        e: BusinessException
    ) {
        response.apply {
            characterEncoding = StandardCharsets.UTF_8.name()
            status = e.status
            contentType = MediaType.APPLICATION_JSON_VALUE
            writer.write(
                objectMapper.writeValueAsString(ErrorResponse.of(e))
            )
        }
    }
}
package com.rest.restfullapi.controller

import com.rest.restfullapi.error.NotFoundException
import com.rest.restfullapi.error.UnauthorizedException
import com.rest.restfullapi.model.WebResponse
import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(consVE: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = consVE.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFound: NotFoundException): WebResponse<String> {
        return WebResponse(
                code = 400,
                status = "NOT FOUND",
                data = "NOT FOUND :("
        )
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorized(unAuth: UnauthorizedException): WebResponse<String> {
        return WebResponse(
                code = 401,
                status = "UNAUTHORIZED",
                data = "Please put your x-api-key >///<"
        )
    }

}
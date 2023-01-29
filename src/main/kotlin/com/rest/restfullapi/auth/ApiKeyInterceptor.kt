package com.rest.restfullapi.auth

import com.rest.restfullapi.error.UnauthorizedException
import com.rest.restfullapi.repository.KeyRepository
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import java.lang.Exception

@Component
class ApiKeyInterceptor(val apiRepo: KeyRepository): WebRequestInterceptor {
    override fun preHandle(request: WebRequest) {
        val apiKey = request.getHeader("X-Api-Key")

        if(apiKey == null) {
            return throw UnauthorizedException()
        }

        if(!apiRepo.existsById(apiKey)) {
            return throw UnauthorizedException()
        }

        // valid
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {

    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {

    }
}
package com.rest.restfullapi.validation

import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validator
import org.springframework.stereotype.Component

@Component
class ValidationUtil(val valid: Validator) {

    fun validate(any: Any) {
        val result = valid.validate(any)

        when{
            result.size != 0 -> throw ConstraintViolationException(result)
        }
    }
}
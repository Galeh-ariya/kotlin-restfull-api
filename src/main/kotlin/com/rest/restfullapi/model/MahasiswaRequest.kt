package com.rest.restfullapi.model

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

data class MahasiswaRequest(

        @field:NotNull
        @field:Min(value = 1)
        val nim: Long?,

        @field:NotBlank
        val name: String?,

        @field:NotBlank
        val email: String?,

        @field:NotBlank
        val prodi: String?

)
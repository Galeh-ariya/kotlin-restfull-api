package com.rest.restfullapi.model

import jakarta.validation.constraints.NotBlank

data class MahasiswaUpdate(
        @field:NotBlank
        val name: String?,

        @field:NotBlank
        val email: String?,

        @field:NotBlank
        val prodi: String?
)
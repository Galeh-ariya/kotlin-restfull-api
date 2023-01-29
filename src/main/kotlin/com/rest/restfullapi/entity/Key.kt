package com.rest.restfullapi.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "keygen")
data class Key(

        @Id
        val key: String
)
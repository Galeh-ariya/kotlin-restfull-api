package com.rest.restfullapi.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "mahasiswa")
data class Mahasiswa(

        @Id
        val nim: Long,

        @Column(name = "name")
        var name: String,

        @Column(name = "email")
        var email: String,

        @Column(name = "prodi")
        var prodi: String

)
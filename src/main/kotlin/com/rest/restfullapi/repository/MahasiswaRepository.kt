package com.rest.restfullapi.repository

import com.rest.restfullapi.entity.Mahasiswa
import org.springframework.data.jpa.repository.JpaRepository

interface MahasiswaRepository: JpaRepository<Mahasiswa, Long> {

}
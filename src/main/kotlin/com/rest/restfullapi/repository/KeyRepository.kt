package com.rest.restfullapi.repository

import com.rest.restfullapi.entity.Key
import org.springframework.data.jpa.repository.JpaRepository

interface KeyRepository: JpaRepository<Key, String> {
}
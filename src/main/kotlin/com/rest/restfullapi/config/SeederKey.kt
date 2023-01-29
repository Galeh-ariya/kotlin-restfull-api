package com.rest.restfullapi.config

import com.rest.restfullapi.entity.Key
import com.rest.restfullapi.repository.KeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class SeederKey(val key: KeyRepository): ApplicationRunner {

    val keySecret = "XXX"

    override fun run(args: ApplicationArguments?) {
        if(!key.existsById(keySecret)) {
            val entity = Key(key = keySecret)
            key.save(entity)
        }
    }
}
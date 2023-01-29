package com.rest.restfullapi.service

import com.rest.restfullapi.model.ListMahasiswa
import com.rest.restfullapi.model.MahasiswaRequest
import com.rest.restfullapi.model.MahasiswaResponse
import com.rest.restfullapi.model.MahasiswaUpdate

interface MahasiswaService {

    fun insert(req: MahasiswaRequest): MahasiswaResponse

    fun get(nim:Long): MahasiswaResponse

    fun update(nim:Long, req: MahasiswaUpdate): MahasiswaResponse

    fun list(list: ListMahasiswa): List<MahasiswaResponse>

    fun delete(nim: Long)

}
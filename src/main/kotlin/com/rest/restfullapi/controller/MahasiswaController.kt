package com.rest.restfullapi.controller

import com.rest.restfullapi.model.*
import com.rest.restfullapi.service.MahasiswaService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MahasiswaController(val service: MahasiswaService) {

    @PostMapping(
            value = ["/api/mhs"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun insertMhs(@RequestBody body: MahasiswaRequest): WebResponse<MahasiswaResponse> {
        val mhsResponse = service.insert(body)

        return WebResponse(
                code = 200,
                status = "OK",
                data = mhsResponse
        )
    }

    @GetMapping(
            value = ["/api/mhs/{nimMhs}"],
            produces = ["application/json"]
    )
    fun getMhs(@PathVariable("nimMhs") nim:Long): WebResponse<MahasiswaResponse> {
        val mhs = service.get(nim)

        return WebResponse(
                code = 200,
                status = "OK",
                data = mhs
        )
    }

    @PutMapping(
            value = ["/api/mhs/{nimMhs}"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun updateMhs(@PathVariable("nimMhs") nim: Long, @RequestBody body: MahasiswaUpdate): WebResponse<MahasiswaResponse> {
        val mhs = service.update(nim, body)

        return WebResponse(
                code = 200,
                status = "OK",
                data = mhs
        )
    }


    @GetMapping(
            value = ["/api/mhs"],
            produces = ["application/json"]
    )
    fun listMhs(@RequestParam(value = "size", defaultValue = "10") size:Int,
                @RequestParam(value = "page", defaultValue = "0") page:Int): WebResponse<List<MahasiswaResponse>> {

        val request = ListMahasiswa(size = size, page = page)
        val response = service.list(request)

        return WebResponse(
                code = 200,
                status = "OK",
                data = response
        )
    }

    @DeleteMapping(
            value = ["/api/mhs/{nimMhs}"],
            produces = ["application/json"]
    )
    fun deleteMhs(@PathVariable("nimMhs") nim: Long): WebResponse<Long> {
        service.delete(nim)

        return WebResponse(
                code = 200,
                status = "OK",
                data = nim
        )
    }

}
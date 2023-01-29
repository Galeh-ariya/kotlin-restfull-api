package com.rest.restfullapi.service.impl

import com.rest.restfullapi.entity.Mahasiswa
import com.rest.restfullapi.error.NotFoundException
import com.rest.restfullapi.model.ListMahasiswa
import com.rest.restfullapi.model.MahasiswaRequest
import com.rest.restfullapi.model.MahasiswaResponse
import com.rest.restfullapi.model.MahasiswaUpdate
import com.rest.restfullapi.repository.MahasiswaRepository
import com.rest.restfullapi.service.MahasiswaService
import com.rest.restfullapi.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class MahasiswaServiceImpl(
        val repo: MahasiswaRepository,
        val valid: ValidationUtil
): MahasiswaService {

    override fun insert(req: MahasiswaRequest): MahasiswaResponse {
        valid.validate(req)

        val mhs = Mahasiswa(
                nim = req.nim!!,
                name = req.name!!,
                email = req.email!!,
                prodi = req.prodi!!
        )

        repo.save(mhs)

        return responseMhs(mhs)

    }

    override fun get(nim: Long): MahasiswaResponse {
        val mhs = repo.findByIdOrNull(nim)

        return when {
            mhs == null -> throw NotFoundException()
            else -> {
                responseMhs(mhs)
            }
        }
    }

    override fun update(nim: Long, req: MahasiswaUpdate): MahasiswaResponse {
        val mhs = repo.findByIdOrNull(nim)

        when {
            mhs ==  null -> return throw NotFoundException()
            else -> {

                valid.validate(req)

                mhs.apply {
                    name = req.name!!
                    email = req.email!!
                    prodi = req.prodi!!
                }

                repo.save(mhs)

                return responseMhs(mhs)

            }
        }

    }

    override fun list(list: ListMahasiswa): List<MahasiswaResponse> {
        val page = repo.findAll(PageRequest.of(list.page, list.size))
        val mhs = page.get().collect(Collectors.toList())
        return mhs.map { responseMhs(it) }
    }

    override fun delete(nim: Long) {
        val mhs = repo.findByIdOrNull(nim)

        when {
            mhs == null -> throw NotFoundException()
            else -> {
                repo.delete(mhs)
            }
        }
    }

    private fun responseMhs(mhs:Mahasiswa): MahasiswaResponse{
        return MahasiswaResponse(
                nim = mhs.nim,
                name = mhs.name,
                email = mhs.email,
                prodi = mhs.prodi
        )
    }

}
package com.sdd.restapiswagger.services.impl;

import com.sdd.restapiswagger.dtos.mMahasiswaRequest;
import com.sdd.restapiswagger.dtos.mMahasiswaResponse;
import com.sdd.restapiswagger.dtos.mMahasiswaResponseBody;
import com.sdd.restapiswagger.models.mMahasiswa;
import com.sdd.restapiswagger.repositories.mMahasiswaRepository;
import com.sdd.restapiswagger.services.mMahasiswaService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class mMahasiswaServiceImpl implements mMahasiswaService {

    private mMahasiswaRepository mahasiswaRepository;

    @Override
    public mMahasiswaResponse addMahasiswa(mMahasiswaRequest request) {
        return null;
    }

    @Override
    public mMahasiswaResponse updateMahasiswa(String id, mMahasiswaRequest request) {
        return null;
    }

    @SneakyThrows
    @Override
    public List<mMahasiswaResponse> listMahasiswa() {
        List<mMahasiswa> findAllExistingMahasiswa = mahasiswaRepository.findAll();
        List<mMahasiswaResponse> returnResponseFromMahasiswa = new ArrayList<>();

        findAllExistingMahasiswa.forEach(search -> {
            mMahasiswaResponse searchResponse = mMahasiswaResponse.builder()
                    .responseType("String")
                    .responseMessage("String")
                    .errorCode(0)
                    .errorMessage("String")
                    .errorLink("String")
                    .responseBody(mMahasiswaResponseBody.builder()
                            .id(search.getId())
                            .npm(search.getNpm())
                            .namaMahasiswa(search.getNamaMahasiswa())
                            .email(search.getEmail())
                            .alamat(search.getAlamat())
                            .jenisKelamin(search.getJenisKelamin())
                            .isActive(search.getIsActive())
                            .createdDate(search.getCreatedDate())
                            .build())
                    .build();
            returnResponseFromMahasiswa.add(searchResponse);
        });
        return returnResponseFromMahasiswa;
    }

    @SneakyThrows
    @Transactional
    @Override
    public void deleteMahasiswa(String id) {
        Optional<mMahasiswa> deleteExistingMahasiswa = mahasiswaRepository.findById(id);
        log.info("Find Id  Mahasiswa");
        if (deleteExistingMahasiswa.isEmpty()){
            throw new Exception("ID Mahasiswa Not Found");
        }
        log.info("Id Found, Delete Successfully");
        mahasiswaRepository.deleteById(id);

    }
}

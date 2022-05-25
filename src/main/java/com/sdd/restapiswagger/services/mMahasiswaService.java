package com.sdd.restapiswagger.services;

import com.sdd.restapiswagger.dtos.mMahasiswaRequest;
import com.sdd.restapiswagger.dtos.mMahasiswaResponse;

import java.util.List;

public interface mMahasiswaService {
    mMahasiswaResponse addMahasiswa (mMahasiswaRequest request);

    mMahasiswaResponse updateMahasiswa (String id, mMahasiswaRequest request);

    List<mMahasiswaResponse> listMahasiswa();

    void deleteMahasiswa(String id);
}

package com.sdd.restapiswagger.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class mMahasiswaResponseBody {
    private String id;
    private String npm;
    private String namaMahasiswa;
    private String email;
    private String alamat;
    private String jenisKelamin;
    private Boolean isActive;
    private String createdDate;
}

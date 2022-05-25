package com.sdd.restapiswagger.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class mMahasiswaRequest {
    private String operationType;
    private String operationDesc;
    private mMahasiswaResponseBody request;
}

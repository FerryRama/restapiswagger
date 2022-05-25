package com.sdd.restapiswagger.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class mMahasiswaResponse {
    private String responseType;
    private String responseMessage;
    private Integer errorCode;
    private String errorMessage;
    private String errorLink;
    public mMahasiswaResponseBody responseBody;

}

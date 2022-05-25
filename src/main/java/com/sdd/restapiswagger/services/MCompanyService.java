package com.sdd.restapiswagger.services;

import com.sdd.restapiswagger.dtos.MCompanyRequest;
import com.sdd.restapiswagger.dtos.MCompanyResponse;

import java.util.List;

public interface MCompanyService {

    MCompanyResponse addCompany(MCompanyRequest request);

    MCompanyResponse updateCompany(String id, MCompanyRequest request);

    List<MCompanyResponse> listCompany();

    void deleteCompany(String id);
}

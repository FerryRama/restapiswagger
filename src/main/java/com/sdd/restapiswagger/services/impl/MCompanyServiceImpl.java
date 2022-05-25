package com.sdd.restapiswagger.services.impl;

import com.sdd.restapiswagger.dtos.MCompanyRequest;
import com.sdd.restapiswagger.dtos.MCompanyResponse;
import com.sdd.restapiswagger.models.MCompany;
import com.sdd.restapiswagger.repositories.MCompanyRepository;
import com.sdd.restapiswagger.services.MCompanyService;
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

public class MCompanyServiceImpl implements MCompanyService {

    private MCompanyRepository companyRepository;

    @SneakyThrows
    @Transactional
    @Override
    public MCompanyResponse addCompany(MCompanyRequest request) {
        MCompany requestDataFromTableToRequest = MCompany.builder()
                .companyName(request.getCompanyName())
                .companyAddress(request.getCompanyAddress())
                .companyEmail(request.getCompanyEmail())
                .build();
        MCompany savedToDatabase = companyRepository.save(requestDataFromTableToRequest);

        return MCompanyResponse.builder()
                .id(savedToDatabase.getId())
                .companyName(savedToDatabase.getCompanyName())
                .companyAddress(savedToDatabase.getCompanyAddress())
                .companyEmail(savedToDatabase.getCompanyEmail())
                .build();
    }

    @SneakyThrows
    @Transactional
    @Override
    public MCompanyResponse updateCompany(String id, MCompanyRequest request) {
        Optional<MCompany> findIdExistingCompany = companyRepository.findById(id);
        if(findIdExistingCompany.isEmpty()){
            throw  new Exception("ID Company not founds ");
        }
        log.info("id founds, get all data ");
        findIdExistingCompany.get().setCompanyName(request.getCompanyName());
        findIdExistingCompany.get().setCompanyAddress(request.getCompanyAddress());
        findIdExistingCompany.get().setCompanyEmail(request.getCompanyEmail());

        MCompany saveExistingCompanyId = companyRepository.save(findIdExistingCompany.get());

        return  MCompanyResponse.builder()
                .id(saveExistingCompanyId.getId())
                .companyName(saveExistingCompanyId.getCompanyName())
                .companyAddress(saveExistingCompanyId.getCompanyAddress())
                .companyEmail(saveExistingCompanyId.getCompanyEmail())
                .build();
    }

    @SneakyThrows
    @Override
    public List<MCompanyResponse> listCompany() {

        List<MCompany> findAllExistingCompany = companyRepository.findAll();

        List<MCompanyResponse> returnResponseFromComp = new ArrayList<>();

        findAllExistingCompany.forEach(search -> {
            MCompanyResponse searchResponse = MCompanyResponse.builder()
                    .id(search.getId())
                    .companyEmail(search.getCompanyEmail())
                    .companyAddress(search.getCompanyAddress())
                    .companyName(search.getCompanyName())
                    .build();

            returnResponseFromComp.add(searchResponse);
        });

        return returnResponseFromComp;
    }


    @SneakyThrows
    @Transactional
    @Override
    public void deleteCompany(String id) {
        Optional<MCompany> deleteExistingCompany = companyRepository.findById(id);
        log.info("finds id company");
        if(deleteExistingCompany.isEmpty()){
            throw new Exception("ID Company Not Founds");
        }
        log.info(" id founds, delete existing id company");
        companyRepository.deleteById(id);
    }
}


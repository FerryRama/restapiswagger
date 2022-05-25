package com.sdd.restapiswagger.controllers;

import com.sdd.restapiswagger.dtos.MCompanyRequest;
import com.sdd.restapiswagger.dtos.MCompanyResponse;
import com.sdd.restapiswagger.services.MCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
@AllArgsConstructor
public class MCompannyController {

    private MCompanyService companyService;

    @PostMapping
    public MCompanyResponse addCompany(@RequestBody @Validated MCompanyRequest request){
        return companyService.addCompany(request);
    }

    @PutMapping("/{id}")
    public MCompanyResponse updateExistingCompany(@PathVariable("id") String id, @RequestBody @Validated MCompanyRequest request){
        return companyService.updateCompany(id, request);
    }

    @GetMapping
    public List<MCompanyResponse> companyListData(){
        return companyService.listCompany();
    }

    @DeleteMapping("/{id}")
    public  String deleteExistingCompany(@PathVariable("id") String id){
        companyService.deleteCompany(id);
        return  "Delete Successfully with ID = " + id;
    }

}

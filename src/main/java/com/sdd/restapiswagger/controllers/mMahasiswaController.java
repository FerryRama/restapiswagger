package com.sdd.restapiswagger.controllers;

import com.sdd.restapiswagger.dtos.MEmployeeResponse;
import com.sdd.restapiswagger.dtos.mMahasiswaRequest;
import com.sdd.restapiswagger.dtos.mMahasiswaResponse;
import com.sdd.restapiswagger.services.mMahasiswaService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mahasiswa")
@AllArgsConstructor
public class mMahasiswaController {

    private mMahasiswaService mahasiswaService;

    @PostMapping
    public mMahasiswaResponse addNewMahasiswa(@RequestBody @Validated mMahasiswaRequest request){
        return mahasiswaService.addMahasiswa(request);
    }

    @GetMapping
    public List<mMahasiswaResponse> listMahasiswaData(){
        return mahasiswaService.listMahasiswa();
    }

    @DeleteMapping("{id}")
    public String deleteExistingMahasiswa(@PathVariable("id") String id){
        mahasiswaService.deleteMahasiswa(id);
        return "Delete Successfully With ID = "+ id;
    }
}

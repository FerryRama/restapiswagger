package com.sdd.restapiswagger.controllers;

import com.sdd.restapiswagger.dtos.MCompanyRequest;
import com.sdd.restapiswagger.dtos.MEmployeeRequest;
import com.sdd.restapiswagger.dtos.MEmployeeResponse;
import com.sdd.restapiswagger.services.MEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@AllArgsConstructor
public class MEmployeeController {
    private MEmployeeService employeeService;

    @PostMapping
    public MEmployeeResponse addNewEmployee(@RequestBody @Validated MEmployeeRequest request){
        return employeeService.addEmployee(request);
    }

    @PutMapping("{id}")
    public  MEmployeeResponse updateExistingEmployee(@PathVariable("id") String id, @RequestBody @Validated MEmployeeRequest request){
        return  employeeService.updateEmployee(id, request);
    }

    @GetMapping
    public List<MEmployeeResponse> listEmployeeData(){
        return employeeService.listEmployee();
    }

    @DeleteMapping("{id}")
    public String deleteExistingEmployee(@PathVariable("id") String id){
        employeeService.deleteEmployee(id);
        return "Delete Successfully With ID = "+ id;
    }
}

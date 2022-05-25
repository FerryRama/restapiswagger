package com.sdd.restapiswagger.services;

import com.sdd.restapiswagger.dtos.MEmployeeRequest;
import com.sdd.restapiswagger.dtos.MEmployeeResponse;

import java.util.List;

public interface MEmployeeService {

    MEmployeeResponse addEmployee(MEmployeeRequest request);

    MEmployeeResponse updateEmployee(String id, MEmployeeRequest request);

    List<MEmployeeResponse> listEmployee();

    void deleteEmployee(String id);
}

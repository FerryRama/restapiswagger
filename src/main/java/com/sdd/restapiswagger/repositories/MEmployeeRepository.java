package com.sdd.restapiswagger.repositories;

import com.sdd.restapiswagger.models.MEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MEmployeeRepository extends JpaRepository<MEmployee, String> {
}

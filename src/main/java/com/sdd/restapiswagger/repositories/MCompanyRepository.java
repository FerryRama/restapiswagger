package com.sdd.restapiswagger.repositories;

import com.sdd.restapiswagger.models.MCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MCompanyRepository extends JpaRepository<MCompany, String> {
}

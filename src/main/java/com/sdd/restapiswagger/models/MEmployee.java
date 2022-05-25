package com.sdd.restapiswagger.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "m_employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MEmployee {
    @Id
    @GeneratedValue(generator = "GeneratorEmployeSystem")
    @GenericGenerator(name = "GeneratorEmployeSystem", strategy = "uuid2")
    @Column(name = "id", nullable = false, length = 64)
    private String id;

    @ManyToOne
    @JoinColumn(name = "company_name", nullable = false)
    private MCompany company;

    @Column(name = "employee_name", nullable = false, length = 64)
    private String employeeName;

    @Column(name = "employee_address", nullable = false, length = 200)
    private String employeeAddress;

    @Column(name = "employee_telephone", nullable = false, length = 20)
    private String employeeTelephone;
}

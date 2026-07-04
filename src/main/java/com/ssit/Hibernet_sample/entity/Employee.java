package com.ssit.Hibernet_sample.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    @Id
    private int empid;

    private String empname;

    private String designation;

    private int salary;
}
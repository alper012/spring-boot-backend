package com.sample.springgraphql.mysql.repository;

import com.sample.springgraphql.mysql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

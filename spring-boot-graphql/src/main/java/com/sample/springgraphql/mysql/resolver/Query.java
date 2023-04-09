package com.sample.springgraphql.mysql.resolver;

import com.sample.springgraphql.mysql.model.Employee;
import com.sample.springgraphql.mysql.repository.EmployeeRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    private final EmployeeRepository employeeRepository;

    public Query(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

}

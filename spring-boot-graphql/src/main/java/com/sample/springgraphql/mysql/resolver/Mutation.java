package com.sample.springgraphql.mysql.resolver;

import com.sample.springgraphql.mysql.model.Employee;
import com.sample.springgraphql.mysql.repository.EmployeeRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final EmployeeRepository employeeRepository;

    public Mutation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(String firstName, String lastName, String email) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setEmail(email);
        employee.setLastName(lastName);

        return employeeRepository.save(employee);
    }


    public boolean deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }

    public Employee updateEmployee(Long id, String firstName, String lastName, String email) throws NotFoundException {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent()) {
            throw new NotFoundException("Not found Tutorial to update!");
        }

        Employee employee = employeeOptional.get();

        if (firstName != null) {
            employee.setFirstName(firstName);
        }

        if (lastName != null) {
            employee.setLastName(lastName);
        }

        if (email != null) {
            employee.setEmail(email);
        }
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }


}

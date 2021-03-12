package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.validator.AddRequetValidator;
import com.paypal.bfs.test.employeeserv.validator.BaseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BaseValidator baseValidator;

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {

        int empId = Integer.valueOf(id);
        Employee employee = null;
        employee = employeeService.getEmployeeByID(empId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> employeeAdd(Employee employee) {
        baseValidator = new AddRequetValidator();
        baseValidator.validate(employee);
        employee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}

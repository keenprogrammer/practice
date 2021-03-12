package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.Repository.AddresRepository;
import com.paypal.bfs.test.employeeserv.Repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.data.AddressEntity;
import com.paypal.bfs.test.employeeserv.data.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exception.RecordExistException;
import com.paypal.bfs.test.employeeserv.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddresRepository addresRepository;
    /**
     *
     * @param empId
     * @return
     */
    public Employee getEmployeeByID(int empId) {
       Optional<EmployeeEntity> employeeEntity =  employeeRepository.findById(empId);
       Employee employee = null;
        if (employeeEntity.isPresent()) {
            employee = convertDBToJson(employeeEntity.get());
            System.out.println("Output Data " + employee.toString());
            return employee;
        } else {
            throw new RecordNotFoundException("RecordNotFound");
        }

    }

    /**
     *
     * @param employeeEntity
     * @return
     */
    private Employee convertDBToJson(EmployeeEntity employeeEntity) {
        Employee employee = new Employee();
        employee.setId(employeeEntity.getId());
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        Address address = new Address();
        address.setLine1(employeeEntity.getAddressEntity().getLine1());
        address.setLine2(employeeEntity.getAddressEntity().getLine2());
        address.setCity(employeeEntity.getAddressEntity().getCity());
        address.setState(employeeEntity.getAddressEntity().getState());
        address.setCountry(employeeEntity.getAddressEntity().getCountry());
        address.setZipCode(employeeEntity.getAddressEntity().getZip_code());
        employee.setAddress(address);
        return employee;
    }

    /**
     *
     * @param employee
     * @return
     */
    public Employee addEmployee(Employee employee) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employee.getId());
        if (employeeEntity.isPresent()) {
            throw new RecordExistException("Record Already exists");
        }
        EmployeeEntity employeeEntityObject = convertEmployeeToEntity(employee);
        addresRepository.save(employeeEntityObject.getAddressEntity());
        employeeRepository.save(employeeEntityObject);
        return employee;
    }

    /**
     *
     * @param employee
     * @return
     */
    private EmployeeEntity convertEmployeeToEntity(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employee.getId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setLine1(employee.getAddress().getLine1());
        addressEntity.setLine2(employee.getAddress().getLine2());
        addressEntity.setCity(employee.getAddress().getCity());
        addressEntity.setState(employee.getAddress().getState());
        addressEntity.setCountry(employee.getAddress().getCountry());
        addressEntity.setZip_code(employee.getAddress().getZipCode());
        employeeEntity.setAddressEntity(addressEntity);
        return employeeEntity;
    }
}

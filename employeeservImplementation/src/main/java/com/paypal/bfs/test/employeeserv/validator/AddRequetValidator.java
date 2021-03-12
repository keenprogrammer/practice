package com.paypal.bfs.test.employeeserv.validator;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exception.InvalidRequestParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class AddRequetValidator implements BaseValidator{
    @Override
    public void validate (Object request ){
        Employee employee = (Employee)request;

        if(employee.getId() < 0) {
            throw new InvalidRequestParam("Invalid Employee Id");
        }
        if (StringUtils.isBlank(employee.getFirstName()) || StringUtils.isBlank(employee.getLastName()) ||
        StringUtils.isBlank(employee.getDateOfBirth()) || StringUtils.isBlank(employee.getAddress().getCity()) ||
        StringUtils.isBlank(employee.getAddress().getCountry()) || StringUtils.isBlank(employee.getAddress().getCity())||
        StringUtils.isBlank(employee.getAddress().getZipCode()) || StringUtils.isBlank(employee.getAddress().getLine1())) {
            throw new InvalidRequestParam("Missed mandatory params");
        }
    }
}

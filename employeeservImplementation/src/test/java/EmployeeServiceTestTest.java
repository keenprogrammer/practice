import com.paypal.bfs.test.employeeserv.Repository.AddresRepository;
import com.paypal.bfs.test.employeeserv.Repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exception.InvalidRequestParam;
import com.paypal.bfs.test.employeeserv.impl.EmployeeResourceImpl;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.validator.AddRequetValidator;
import com.paypal.bfs.test.employeeserv.validator.BaseValidator;
import junit.framework.TestCase;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class EmployeeServiceTestTest extends TestCase {

    @Mock
    EmployeeService employeeService;
    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    AddresRepository addresRepository;

    @InjectMocks
    EmployeeResourceImpl employeeResource;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
    }


    public void tearDown() throws Exception {
    }

    private Employee prepareEmployeeRequest() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Premvir");
        employee.setDateOfBirth("18/04/1990");
        Address address = new Address();
        address.setLine1("Orchid 1116");
        address.setLine2("SKA GreenArch");
        address.setCity("Noida");
        address.setState("UP");
        address.setCountry("India");
        address.setZipCode("121344");
        employee.setAddress(address);
        return employee;
    }
    public void testGetEmployeeByID() {

    }

    public void testAddEmployee() {
        BaseValidator validator= new AddRequetValidator();
        Employee employee = prepareEmployeeRequest();
        employee.setLastName("Singh");
        validator.validate(employee);
    }

    public void testAddEmployeeFailure() {
        BaseValidator validator= new AddRequetValidator();
        Employee employee = prepareEmployeeRequest();
        try {
            validator.validate(employee);
        } catch (InvalidRequestParam ex) {
            System.out.println("Passed ..");
        }
    }

    public void testAddEmp() {
        Employee employee = prepareEmployeeRequest();
        employee.setLastName("Singh");
        employeeResource.employeeAdd(employee);
    }
}
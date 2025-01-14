package br.com.Lucas.resource;

import br.com.Lucas.entity.Employee;
import br.com.Lucas.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/employeers")
    public List<Employee> list() {
        return service.listAll();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id) {
        try {
            Employee employee = service.get(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/employee/save")
    public void save(@RequestBody Employee employee) {
        service.save(employee);
    }

    @DeleteMapping("/employee/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/employee/update/{id}")
    public ResponseEntity<?> update(@RequestBody Employee up, @PathVariable Long id) {
        try {
            Employee employee = service.get(id);
            employee.setEmailId(up.getEmailId());
            employee.setLastName(up.getLastName());
            employee.setFirstName(up.getFirstName());
            service.save(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
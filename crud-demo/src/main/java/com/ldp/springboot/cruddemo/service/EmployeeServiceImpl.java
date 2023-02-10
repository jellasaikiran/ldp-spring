package com.ldp.springboot.cruddemo.service;

import com.ldp.springboot.cruddemo.dao.EmployeeRepository;
import com.ldp.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRespository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRespository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRespository.findById(theId);
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return employee;
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeRespository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeRespository.deleteById(theId);
    }
}

package com.cg.empmswithdb.service;

import com.cg.empmswithdb.dao.IEmployeeRepository;
import com.cg.empmswithdb.entities.Employee;

import static org.junit.jupiter.api.Assertions.*;

import com.cg.empmswithdb.exceptions.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
//import static org.junit.jupiter.A

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplUnitTest {

    @Mock
    IEmployeeRepository dao;

    @Spy
    @InjectMocks
    EmployeeServiceImpl service;

    @Test
    public void testAdd_1() {
        String name = "krishna";
        double salary = 50000;
        Employee employee = mock(Employee.class);
        Employee saved = mock(Employee.class);
        doReturn(employee).when(service).newEmployee(name, salary);
        when(dao.save(employee)).thenReturn(saved);
        Employee result = service.add(name, salary);
        assertSame(saved, result);
        verify(dao).save(employee);
    }

    @Test
    public void testFindAll_1() {
        List<Employee> list = mock(List.class);
        when(dao.findAll()).thenReturn(list);
        List<Employee> result = service.findAll();
        verify(dao).findAll();
    }

    /**
     * scenario: employee found for id
     */
    @Test
    public void testFindById_1() {
        int id = 10;
        Employee employee = mock(Employee.class);
        Optional<Employee> optional = Optional.of(employee);
        when(dao.findById(id)).thenReturn(optional);
        Employee result = service.findById(id);
        assertSame(employee, result);
        verify(dao).findById(id);
    }

    /**
     * scenario : employee not found for id
     */
    @Test
    public void testFindById_2() {
        int id = 10;
        Optional<Employee> optional = Optional.empty();
        when(dao.findById(id)).thenReturn(optional);
        // Employee result=service.findById(id);
        /*
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                service.findById(id);
            }
        };
        */
        Executable executable=()->service.findById(id);
        assertThrows(EmployeeNotFoundException.class,executable);
    }


}

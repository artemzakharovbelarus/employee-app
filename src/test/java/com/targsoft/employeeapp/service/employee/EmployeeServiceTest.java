package com.targsoft.employeeapp.service.employee;

import com.targsoft.employeeapp.domain.Employee;
import com.targsoft.employeeapp.domain.vo.EmployeeId;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeServiceTest {

    EmployeeService employeeService = Mockito.mock(EmployeeService.class);

    @Test
    public void findAll() {
        //given
        final List<Employee> expected = (List<Employee>) Mockito.mock(List.class);
        //then
        Mockito.doReturn(expected).when(employeeService).findAll();
        final List<Employee> actual = employeeService.findAll();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findById() {
        //given
        final Employee expected = Mockito.mock(Employee.class);
        final EmployeeId id = Mockito.mock(EmployeeId.class);
        //when
        Mockito.doReturn(expected).when(employeeService).find(id);
        final Employee actual = employeeService.find(id);
        //then
        assertEquals(expected, actual);
    }

    @Test(expected = EmployeeServiceException.class)
    public void findByIdAndThrowEmployeeServiceException() {
        //given
        final EmployeeId id = Mockito.mock(EmployeeId.class);
        Mockito.doThrow(EmployeeServiceException.class).when(employeeService).find(id);
        employeeService.find(id);
        //expected EmployeeServiceException
    }

    @Test
    public void save() {
        //given
        final Employee expected = Mockito.mock(Employee.class);
        final Employee employeeToSave = Mockito.mock(Employee.class);
        //when
        Mockito.doReturn(expected).when(employeeService).save(employeeToSave);
        final Employee actual = employeeService.save(employeeToSave);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        //given
        final Employee expected = Mockito.mock(Employee.class);
        final Employee employeeToUpdate = Mockito.mock(Employee.class);
        //when
        Mockito.doReturn(expected).when(employeeService).update(employeeToUpdate);
        final Employee actual = employeeService.update(employeeToUpdate);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        //given
        final EmployeeId id = Mockito.mock(EmployeeId.class);
        //when
        Mockito.doNothing().when(employeeService).delete(id);
        employeeService.delete(id);
        //then nothing
    }
}
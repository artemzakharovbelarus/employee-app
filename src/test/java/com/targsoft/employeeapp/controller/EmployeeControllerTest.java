package com.targsoft.employeeapp.controller;

import com.targsoft.employeeapp.controller.dto.EmployeeDto;
import com.targsoft.employeeapp.controller.view.EmployeeView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeControllerTest {

    EmployeeController employeeController = Mockito.mock(EmployeeController.class);

    @Test
    public void delete() {
        //given
        final Long id = 12L;
        //when
        Mockito.doNothing().when(employeeController).delete(id);
        employeeController.delete(id);
        //then nothing
    }

    @Test
    public void save() {
        //given
        final EmployeeView expected = Mockito.mock(EmployeeView.class);
        final EmployeeDto employeeToSave = Mockito.mock(EmployeeDto.class);
        //when
        Mockito.doReturn(expected).when(employeeController).save(employeeToSave);
        final EmployeeView actual = employeeController.save(employeeToSave);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        //given
        final EmployeeView expected = Mockito.mock(EmployeeView.class);
        final EmployeeDto employeeToUpdate = Mockito.mock(EmployeeDto.class);
        //when
        Mockito.doReturn(expected).when(employeeController).update(employeeToUpdate);
        final EmployeeView actual = employeeController.update(employeeToUpdate);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getAllEmployeeCategories() {
        //given
        final List<EmployeeView> expected = (List<EmployeeView>) Mockito.mock(List.class);
        //when
        Mockito.doReturn(expected).when(employeeController).getAllEmployees();
        final List<EmployeeView> actual = employeeController.getAllEmployees();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeCategory() {
        //given
        final EmployeeView expected = Mockito.mock(EmployeeView.class);
        final Long id = 12L;
        //when
        Mockito.doReturn(expected).when(employeeController).getEmployee(id);
        final EmployeeView actual = employeeController.getEmployee(id);
        //then
        assertEquals(expected, actual);
    }
}
package com.targsoft.employeeapp.controller;

import com.targsoft.employeeapp.controller.dto.EmployeeCategoryDto;
import com.targsoft.employeeapp.controller.view.EmployeeCategoryView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeCategoryControllerTest {

    EmployeeCategoryController employeeCategoryController = Mockito.mock(EmployeeCategoryController.class);

    @Test
    public void delete() {
        //given
        final Long id = 12L;
        //when
        Mockito.doNothing().when(employeeCategoryController).delete(id);
        employeeCategoryController.delete(id);
        //then nothing
    }

    @Test
    public void save() {
        //given
        final EmployeeCategoryView expected = Mockito.mock(EmployeeCategoryView.class);
        final EmployeeCategoryDto employeeCategoryToSave = Mockito.mock(EmployeeCategoryDto.class);
        //when
        Mockito.doReturn(expected).when(employeeCategoryController).save(employeeCategoryToSave);
        final EmployeeCategoryView actual = employeeCategoryController.save(employeeCategoryToSave);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        //given
        final EmployeeCategoryView expected = Mockito.mock(EmployeeCategoryView.class);
        final EmployeeCategoryDto employeeCategoryToUpdate = Mockito.mock(EmployeeCategoryDto.class);
        //when
        Mockito.doReturn(expected).when(employeeCategoryController).update(employeeCategoryToUpdate);
        final EmployeeCategoryView actual = employeeCategoryController.update(employeeCategoryToUpdate);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getAllEmployeeCategories() {
        //given
        final List<EmployeeCategoryView> expected = (List<EmployeeCategoryView>) Mockito.mock(List.class);
        //when
        Mockito.doReturn(expected).when(employeeCategoryController).getAllEmployeeCategories();
        final List<EmployeeCategoryView> actual = employeeCategoryController.getAllEmployeeCategories();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeCategory() {
        //given
        final EmployeeCategoryView expected = Mockito.mock(EmployeeCategoryView.class);
        final Long id = 12L;
        //when
        Mockito.doReturn(expected).when(employeeCategoryController).getEmployeeCategory(id);
        final EmployeeCategoryView actual = employeeCategoryController.getEmployeeCategory(id);
        //then
        assertEquals(expected, actual);
    }
}
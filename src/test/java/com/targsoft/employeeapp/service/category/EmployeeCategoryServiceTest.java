package com.targsoft.employeeapp.service.category;

import com.targsoft.employeeapp.domain.EmployeeCategory;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeCategoryServiceTest {

    EmployeeCategoryService employeeCategoryService = Mockito.mock(EmployeeCategoryService.class);

    @Test
    public void findAll() {
        //given
        final List<EmployeeCategory> expected = (List<EmployeeCategory>) Mockito.mock(List.class);
        //then
        Mockito.doReturn(expected).when(employeeCategoryService).findAll();
        final List<EmployeeCategory> actual = employeeCategoryService.findAll();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findById() {
        //given
        final EmployeeCategory expected = Mockito.mock(EmployeeCategory.class);
        final EmployeeCategoryId id = Mockito.mock(EmployeeCategoryId.class);
        //when
        Mockito.doReturn(expected).when(employeeCategoryService).find(id);
        final EmployeeCategory actual = employeeCategoryService.find(id);
        //then
        assertEquals(expected, actual);
    }

    @Test(expected = EmployeeCategoryServiceException.class)
    public void findByIdAndThrowEmployeeCategoryServiceException() {
        //given
        final EmployeeCategoryId id = Mockito.mock(EmployeeCategoryId.class);
        Mockito.doThrow(EmployeeCategoryServiceException.class).when(employeeCategoryService).find(id);
        employeeCategoryService.find(id);
        //expected EmployeeCategoryServiceException
    }

    @Test
    public void save() {
        //given
        final EmployeeCategory expected = Mockito.mock(EmployeeCategory.class);
        final EmployeeCategory categoryToSave = Mockito.mock(EmployeeCategory.class);
        //when
        Mockito.doReturn(expected).when(employeeCategoryService).save(categoryToSave);
        final EmployeeCategory actual = employeeCategoryService.save(categoryToSave);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        //given
        final EmployeeCategory expected = Mockito.mock(EmployeeCategory.class);
        final EmployeeCategory categoryToUpdate = Mockito.mock(EmployeeCategory.class);
        //when
        Mockito.doReturn(expected).when(employeeCategoryService).update(categoryToUpdate);
        final EmployeeCategory actual = employeeCategoryService.update(categoryToUpdate);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        //given
        final EmployeeCategoryId id = Mockito.mock(EmployeeCategoryId.class);
        //when
        Mockito.doNothing().when(employeeCategoryService).delete(id);
        employeeCategoryService.delete(id);
        //then nothing
    }
}
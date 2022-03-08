package com.targsoft.employeeapp.application;

import com.targsoft.employeeapp.controller.dto.EmployeeCategoryDto;
import com.targsoft.employeeapp.controller.view.EmployeeCategoryView;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeCategoryApplicationTest {

    EmployeeCategoryApplication employeeCategoryApplication = Mockito.mock(EmployeeCategoryApplication.class);

    @Test
    public void find() {
        //given
        final EmployeeCategoryView expected = Mockito.mock(EmployeeCategoryView.class);
        final EmployeeCategoryId id = Mockito.mock(EmployeeCategoryId.class);
        //when
        Mockito.doReturn(expected).when(employeeCategoryApplication).find(id);
        final EmployeeCategoryView actual = employeeCategoryApplication.find(id);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        //given
        final List<EmployeeCategoryView> expected = (List<EmployeeCategoryView>) Mockito.mock(List.class);
        //when
        Mockito.doReturn(expected).when(employeeCategoryApplication).findAll();
        final List<EmployeeCategoryView> actual = employeeCategoryApplication.findAll();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void save() {
        //given
        final EmployeeCategoryView expected = Mockito.mock(EmployeeCategoryView.class);
        final EmployeeCategoryDto employeeToSave = Mockito.mock(EmployeeCategoryDto.class);
        //when
        Mockito.doReturn(expected).when(employeeCategoryApplication).save(employeeToSave);
        final EmployeeCategoryView actual = employeeCategoryApplication.save(employeeToSave);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        //given
        final EmployeeCategoryView expected = Mockito.mock(EmployeeCategoryView.class);
        final EmployeeCategoryDto employeeToSave = Mockito.mock(EmployeeCategoryDto.class);
        //when
        Mockito.doReturn(expected).when(employeeCategoryApplication).update(employeeToSave);
        final EmployeeCategoryView actual = employeeCategoryApplication.update(employeeToSave);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        //given
        final EmployeeCategoryId id = Mockito.mock(EmployeeCategoryId.class);
        Mockito.doNothing().when(employeeCategoryApplication).delete(id);
        employeeCategoryApplication.delete(id);
        //then nothing
    }
}
package com.targsoft.employeeapp.repository;

import com.targsoft.employeeapp.repository.entity.EmployeeCategoryEntity;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class EmployeeCategoryRepositoryTest {

    EmployeeCategoryRepository employeeCategoryRepository = Mockito.mock(EmployeeCategoryRepository.class);

    @Test
    public void findAllEmployeeCategories() {
        //given
        final List<EmployeeCategoryEntity> expected = (List<EmployeeCategoryEntity>) Mockito.mock(List.class);
        //when
        Mockito.doReturn(expected).when(employeeCategoryRepository).findAll();
        final List<EmployeeCategoryEntity> actual = employeeCategoryRepository.findAll();
        //then
        assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void saveEmployeeCategoryAndThrowRuntimeException() {
        //given
        final EmployeeCategoryEntity invalidCategory = Mockito.mock(EmployeeCategoryEntity.class);
        //when
        Mockito.doThrow().when(employeeCategoryRepository).save(invalidCategory);
        employeeCategoryRepository.save(invalidCategory);
        //expected RuntimeException
    }

    @Test
    public void saveValidEmployeeCategory() {
        //given
        final EmployeeCategoryEntity categoryToSave = Mockito.mock(EmployeeCategoryEntity.class);
        final EmployeeCategoryEntity expected = Mockito.mock(EmployeeCategoryEntity.class);
        //when
        Mockito.doReturn(expected).when(employeeCategoryRepository).save(categoryToSave);
        final EmployeeCategoryEntity actual = employeeCategoryRepository.save(categoryToSave);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findByValidIdEmployeeCategory() {
        //given
        final Optional<EmployeeCategoryEntity> expected = Optional.of(Mockito.mock(EmployeeCategoryEntity.class));
        final Long id = 1L;
        //when
        Mockito.doReturn(expected).when(employeeCategoryRepository).findById(id);
        final Optional<EmployeeCategoryEntity> actual = employeeCategoryRepository.findById(id);
        //then
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByIdEmployeeCategoryAndThrowIllegalArgumentException() {
        //when
        Mockito.doThrow(IllegalArgumentException.class).when(employeeCategoryRepository).findById(Mockito.isNull());
        employeeCategoryRepository.findById(Mockito.isNull());
        //expected IllegalArgumentException
    }

    @Test
    public void deleteEmployeeCategory() {
        //when
        Mockito.doNothing().when(employeeCategoryRepository).deleteById(Mockito.anyLong());
        employeeCategoryRepository.deleteById(Mockito.anyLong());
        //then nothing
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteEmployeeCategoryAndThrowIllegalArgumentException() {
        //when
        Mockito.doThrow(IllegalArgumentException.class).when(employeeCategoryRepository).deleteById(Mockito.isNull());
        employeeCategoryRepository.deleteById(Mockito.isNull());
        //expected IllegalArgumentException
    }
}
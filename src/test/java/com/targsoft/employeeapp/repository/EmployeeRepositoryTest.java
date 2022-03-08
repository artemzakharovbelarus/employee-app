package com.targsoft.employeeapp.repository;

import com.targsoft.employeeapp.repository.entity.EmployeeEntity;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class EmployeeRepositoryTest {

    EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);

    @Test
    public void findAllEmployees() {
        //given
        final List<EmployeeEntity> expected = (List<EmployeeEntity>) Mockito.mock(List.class);
        //when
        Mockito.doReturn(expected).when(employeeRepository).findAll();
        final List<EmployeeEntity> actual = employeeRepository.findAll();
        //then
        assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void saveEmployeeAndThrowRuntimeException() {
        //given
        final EmployeeEntity invalidEmployee = Mockito.mock(EmployeeEntity.class);
        //when
        Mockito.doThrow().when(employeeRepository).save(invalidEmployee);
        employeeRepository.save(invalidEmployee);
        //expected RuntimeException
    }

    @Test
    public void saveEmployee() {
        //given
        final EmployeeEntity employeeToSave = Mockito.mock(EmployeeEntity.class);
        final EmployeeEntity expected = Mockito.mock(EmployeeEntity.class);
        //when
        Mockito.doReturn(expected).when(employeeRepository).save(employeeToSave);
        final EmployeeEntity actual = employeeRepository.save(employeeToSave);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findByIdEmployee() {
        //given
        final Optional<EmployeeEntity> expected = Optional.of(Mockito.mock(EmployeeEntity.class));
        final Long id = 1L;
        //when
        Mockito.doReturn(expected).when(employeeRepository).findById(id);
        final Optional<EmployeeEntity> actual = employeeRepository.findById(id);
        //then
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByIdEmployeeAndThrowIllegalArgumentException() {
        //when
        Mockito.doThrow(IllegalArgumentException.class).when(employeeRepository).findById(Mockito.isNull());
        employeeRepository.findById(Mockito.isNull());
        //expected IllegalArgumentException
    }

    @Test
    public void deleteEmployee() {
        //when
        Mockito.doNothing().when(employeeRepository).deleteById(Mockito.anyLong());
        employeeRepository.deleteById(Mockito.anyLong());
        //then nothing
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteEmployeeAndThrowIllegalArgumentException() {
        //when
        Mockito.doThrow(IllegalArgumentException.class).when(employeeRepository).deleteById(Mockito.isNull());
        employeeRepository.deleteById(Mockito.isNull());
        //expected IllegalArgumentException
    }
}
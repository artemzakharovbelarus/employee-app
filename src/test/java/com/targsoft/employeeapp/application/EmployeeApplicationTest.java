package com.targsoft.employeeapp.application;

import com.targsoft.employeeapp.controller.dto.EmployeeDto;
import com.targsoft.employeeapp.controller.view.EmployeeView;
import com.targsoft.employeeapp.domain.vo.EmployeeId;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class EmployeeApplicationTest {

    EmployeeApplication employeeApplication = Mockito.mock(EmployeeApplication.class);

    @Test
    public void find() {
        //given
        final EmployeeView expected = Mockito.mock(EmployeeView.class);
        final EmployeeId id = Mockito.mock(EmployeeId.class);
        //when
        Mockito.doReturn(expected).when(employeeApplication).find(id);
        final EmployeeView actual = employeeApplication.find(id);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findAllFromServer() {
        //given
        final List<EmployeeView> expected = (List<EmployeeView>) Mockito.mock(List.class);
        //when
        Mockito.doReturn(expected).when(employeeApplication).findAll();
        final List<EmployeeView> actual = employeeApplication.findAll();
        //then
        assertEquals(expected, actual);
    }

//    @Test
//    public void findAllFromCache() {
//        //given
//        final List<EmployeeView> employeeViews = (List<EmployeeView>) Mockito.mock(List.class);
//        //when
//        Mockito.doReturn(employeeViews).when(employeeApplication).findAll();
//        List<EmployeeView> actual = employeeApplication.findAll();
//        actual = employeeApplication.findAll();
//        //then
//        Mockito.verify(employeeApplication, Mockito.times(1)).findAll();
//    }

    @Test
    public void save() {
        //given
        final EmployeeView expected = Mockito.mock(EmployeeView.class);
        final EmployeeDto employeeToSave = Mockito.mock(EmployeeDto.class);
        //when
        Mockito.doReturn(expected).when(employeeApplication).save(employeeToSave);
        final EmployeeView actual = employeeApplication.save(employeeToSave);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void update() {
        //given
        final EmployeeView expected = Mockito.mock(EmployeeView.class);
        final EmployeeDto employeeToSave = Mockito.mock(EmployeeDto.class);
        //when
        Mockito.doReturn(expected).when(employeeApplication).update(employeeToSave);
        final EmployeeView actual = employeeApplication.update(employeeToSave);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        //given
        final EmployeeId id = Mockito.mock(EmployeeId.class);
        Mockito.doNothing().when(employeeApplication).delete(id);
        employeeApplication.delete(id);
        //then nothing
    }
}
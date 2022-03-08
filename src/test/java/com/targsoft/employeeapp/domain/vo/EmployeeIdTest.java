package com.targsoft.employeeapp.domain.vo;

import com.targsoft.employeeapp.exception.TypedIdException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeIdTest {

    @Test
    public void constructEmployeeId() {
        //given
        new EmployeeId(12L);
        //then nothing
    }

    @Test(expected = TypedIdException.class)
    public void constructInvalidEmployeeIdAndThrowTypedIdException() {
        //given
        new EmployeeId(null);
        //expected TypedIdException
    }

    @Test
    public void getValueReturnsSameValueThatWasPassedToConstructor() {
        //given
        final Long expected = 12L;
        final EmployeeId id = new EmployeeId(expected);
        //when
        final Long actual = id.getValue();
        //then
        assertEquals(expected, actual);
    }
}
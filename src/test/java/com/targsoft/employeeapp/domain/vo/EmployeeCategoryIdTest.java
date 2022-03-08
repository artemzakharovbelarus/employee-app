package com.targsoft.employeeapp.domain.vo;

import com.targsoft.employeeapp.exception.TypedIdException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeCategoryIdTest {

    @Test
    public void constructEmployeeCategoryId() {
        //given
        new EmployeeCategoryId(12L);
        //then nothing
    }

    @Test(expected = TypedIdException.class)
    public void constructInvalidEmployeeCategoryIdAndThrowTypedIdException() {
        //given
        new EmployeeCategoryId(null);
        //expected TypedIdException
    }

    @Test
    public void getValueReturnsSameValueThatWasPassedToConstructor() {
        //given
        final Long expected = 12L;
        final EmployeeCategoryId id = new EmployeeCategoryId(expected);
        //when
        final Long actual = id.getValue();
        //then
        assertEquals(expected, actual);
    }
}
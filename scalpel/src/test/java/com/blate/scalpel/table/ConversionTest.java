package com.blate.scalpel.table;

import org.junit.Test;

public class ConversionTest {

    @Test
    public void charToIntTest() {
        assert 0 == Character.getNumericValue('0');
        assert 1 == Character.getNumericValue('1');
        assert 2 == Character.getNumericValue('2');
        assert 3 == Character.getNumericValue('3');
        assert 4 == Character.getNumericValue('4');
        assert 5 == Character.getNumericValue('5');
        assert 6 == Character.getNumericValue('6');
        assert 7 == Character.getNumericValue('7');
        assert 8 == Character.getNumericValue('8');
        assert 9 == Character.getNumericValue('9');
    }

}

package com.blate.scalpel;

import com.blate.scalpel.throwable.EncodeException;

import org.junit.Test;

import java.util.Objects;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void regexTest() {
        System.out.println("0123456789".matches("[0-9]+"));
        System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_".matches("[0-9A-Z!\"#$%&'()*+,\\-./:;<=>?@\\[\\\\\\]^_]+"));
        System.out.println("01234567899abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~".matches("[0-9a-zA-Z!\"#$%&'()*+,\\-./:;<=>?@\\[\\\\\\]^_`{|}~]+"));
    }

}
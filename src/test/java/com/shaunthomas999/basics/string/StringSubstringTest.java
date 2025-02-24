package com.shaunthomas999.basics.string;

import org.junit.Before;
import org.junit.Test;

public class StringSubstringTest {

    private StringSubstring stringSubstring = null;

    @Before
    public void init() {
        stringSubstring = new StringSubstring();
    }

    @Test
    public void extractTest() {
        System.out.println(stringSubstring.extract("status 403 reading MoneyTransferClient#getAllowedTransferAccounts(String); content:\n {\"code\":\"1457\",\"message\":\"Product not valid\"}"));
    }
}

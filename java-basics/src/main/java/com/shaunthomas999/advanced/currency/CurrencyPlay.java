package com.shaunthomas999.advanced.currency;

import java.util.Currency;

public class CurrencyPlay {

    public static void main(String[] args) {
        System.out.println(Currency.getInstance("EUR").toString());
        System.out.println(Currency.getInstance("EURO").toString());
        System.out.println(Currency.getInstance("EUROO").toString());
    }
}

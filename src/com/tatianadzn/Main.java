package com.tatianadzn;

import com.tatianadzn.CurrencyConverter.Currency;
import com.tatianadzn.CurrencyConverter.CurrencyConverter;


public class Main {

    public static void main(String[] args) throws Exception{
        CurrencyConverter converter;
        final String configFilePath = "config.properties";
        Currency currency = Currency.valueOf(args[1].toUpperCase());

        double input = Double.parseDouble(args[0]);
        converter = new CurrencyConverter(configFilePath, currency);
        converter.convert(input);
        System.out.println(converter);
    }
}

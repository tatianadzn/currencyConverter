package com.tatianadzn;

import com.tatianadzn.CurrencyConverter.CurrencyConverter;


public class Main {

    public static void main(String[] args) throws Exception{
        CurrencyConverter converter;
        final String configFilePath = "config.properties";

        for (String arg : args){
            double input = Double.parseDouble(arg);
            converter = new CurrencyConverter(configFilePath);
            converter.convert(input);
            System.out.println(converter);
        }
    }
}

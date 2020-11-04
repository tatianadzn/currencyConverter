package com.tatianadzn;

import com.tatianadzn.CurrencyConverter.CurrencyConverter;

public class Main {

    public static void main(String[] args) {
        CurrencyConverter converter;
        String configFilePath = System.getProperty("user.dir") + "\\src\\com\\tatianadzn\\config.properties";
        for (String arg : args){
            try{
                double input = Double.parseDouble(arg);
                converter = new CurrencyConverter(configFilePath);
                converter.convert(input);
                System.out.println(converter);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

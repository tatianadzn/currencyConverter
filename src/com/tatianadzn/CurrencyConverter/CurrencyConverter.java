package com.tatianadzn.CurrencyConverter;

public class CurrencyConverter {
    private double inputValue;
    private double dollarValueInRUB;
    private double[] currenciesRates;
    private double euroValueInRUB;

    public CurrencyConverter(){
        currenciesRates = CurrenciesRateParser.getCurrenciesRates();

    }

    public void convert(){
        getInputValueFromUser();
        convertInputCurrToOutputCurr();
    }

    private void convertInputCurrToOutputCurr(){
        dollarValueInRUB = inputValue * currenciesRates[0];
        euroValueInRUB = inputValue * currenciesRates[1];
    }

    private void getInputValueFromUser(){
        inputValue = InputHandler.getInputValue();
    }

    @Override
    public String toString(){
        return inputValue + " USD" + " = "
                + String.format("%.2f", dollarValueInRUB) + " RUB\n"
                + inputValue + " EUR" + " = "
                + String.format("%.2f", euroValueInRUB) + " RUB";
    }







}

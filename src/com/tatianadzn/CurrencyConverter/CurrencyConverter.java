package com.tatianadzn.CurrencyConverter;

public class CurrencyConverter {
    private double inputValue;
    private double dollarValueInRUB;
    private double[] currenciesRates;
    private double euroValueInRUB;

    public CurrencyConverter(String configFilePath) throws Exception{
        currenciesRates = CurrenciesRateParser.getCurrenciesRates(configFilePath);
    }



    public void convert(Double inputValue) throws Exception{
        if (inputValue <=0)
            throw new Exception("Invalid input: negative number");

        this.inputValue = inputValue;
        convertInputCurrToOutputCurr();
    }

    private void convertInputCurrToOutputCurr(){
        dollarValueInRUB = inputValue * currenciesRates[0];
        euroValueInRUB = inputValue * currenciesRates[1];
    }

    @Override
    public String toString(){
        return inputValue + " USD" + " = "
                + String.format("%.2f", dollarValueInRUB) + " RUB\n"
                + inputValue + " EUR" + " = "
                + String.format("%.2f", euroValueInRUB) + " RUB";
    }







}

package com.tatianadzn.CurrencyConverter;

public class CurrencyConverter {
    private double inputValue;
    private double outputValue;
    private double currencyRate;
    private Currency inputCurrency;
    private Currency outputCurrency = Currency.RUB;

    public CurrencyConverter(String configFilePath, Currency outputCurrency) throws Exception{
        currencyRate = CurrencyRateParser.getCurrencyRate(configFilePath, outputCurrency);
        this.inputCurrency = outputCurrency;
    }


    public void convert(Double inputValue) throws Exception{
        if (inputValue <=0)
            throw new Exception("Invalid inputCurrency: negative number");

        this.inputValue = inputValue;
        convertInputCurrToOutputCurr();
    }

    private void convertInputCurrToOutputCurr(){
        outputValue = inputValue * currencyRate;
    }

    @Override
    public String toString(){
        return inputValue + " " + inputCurrency.name() + " = "
                + String.format("%.2f", outputValue) + " " + outputCurrency.name();
    }







}

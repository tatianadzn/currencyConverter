package com.tatianadzn.CurrencyConverter;

public class CurrencyConverter {
    private double inputValue;
    private double outputValue;
    private double dollarRate;

    public enum Currencies {USD, RUB}
    private Currencies inputCurrency;
    private Currencies outputCurrency;

    public CurrencyConverter(Currencies inputCurrency, Currencies outputCurrency){
        this.inputCurrency = inputCurrency;
        this.outputCurrency = outputCurrency;
        dollarRate = DollarRateParser.getDollarRate();
    }

    public double convert(){
        getInputValueFromUser();
        convertInputCurrToOutputCurr();
        return outputValue;
    }

    private void convertInputCurrToOutputCurr(){
        // a stub here
        // different input-output currencies coming soon
        if (this.inputCurrency == Currencies.USD && this.outputCurrency == Currencies.RUB)
            outputValue = inputValue * dollarRate;
        else
            outputValue = -1;
    }

    private void getInputValueFromUser(){
        inputValue = InputHandler.getInputValue();
    }

    @Override
    public String toString(){
        return inputValue + " " + inputCurrency.toString() + " = "
                + outputValue + " " + outputCurrency.toString();
    }







}

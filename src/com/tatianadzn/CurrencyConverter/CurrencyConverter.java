package com.tatianadzn.CurrencyConverter;

public class CurrencyConverter {
    private double inputValue;
    private double dollarValueInRUB;
    private double[] currenciesRates;
    private double euroValueInRUB;

    public CurrencyConverter(){
        currenciesRates = CurrenciesRateParser.getCurrenciesRates();
    }

    public void convert(Double inputValue){
        try{
            if (inputValue <=0)
                throw new Exception("Invalid input: negative number");
            this.inputValue = inputValue;


        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
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

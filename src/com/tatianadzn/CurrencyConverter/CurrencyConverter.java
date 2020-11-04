package com.tatianadzn.CurrencyConverter;

public class CurrencyConverter {
    private double inputValue;
    private double dollarValueInRUB;
    private double[] currenciesRates;
    private double euroValueInRUB;

    public CurrencyConverter(String configFilePath) throws Exception{
        try{
            currenciesRates = CurrenciesRateParser.getCurrenciesRates(configFilePath);
        }catch (Exception e){
            throw e;
        }
    }



    public void convert(Double inputValue) throws Exception{
        try{
            if (inputValue <=0)
                throw new Exception("Invalid input: negative number");
            this.inputValue = inputValue;


        }catch (Exception e){
            throw e;
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

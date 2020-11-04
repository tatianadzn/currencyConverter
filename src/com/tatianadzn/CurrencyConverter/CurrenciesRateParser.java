package com.tatianadzn.CurrencyConverter;

import org.w3c.dom.Document;

public abstract class CurrenciesRateParser {
    /*array for currencies rates:
    currenciesRates[0] contains dollar rate
    currenciesRates[1] contains euro rate
     */
    private static double[] currenciesRates = new double[2];

    public static double[] getCurrenciesRates(String fileConfigPath) throws Exception{
        try{
            parseResponse(CurrencyAPIHandler.getResponse(fileConfigPath));
        }catch (Exception e){
            throw e;
        }
        return currenciesRates;
    }

    private static void parseResponse(Document responseXML){
        Double dollarRate = Double.parseDouble(responseXML.getElementsByTagName("RUB")
                .item(0)
                .getTextContent());
        currenciesRates[0] = dollarRate;
        currenciesRates[1] = dollarRate / Double.parseDouble(responseXML.getElementsByTagName("EUR")
                .item(0)
                .getTextContent());
    }

}

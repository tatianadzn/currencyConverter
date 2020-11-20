package com.tatianadzn.CurrencyConverter;

import org.w3c.dom.Document;

public abstract class CurrencyRateParser {
    private static double currencyRate;

    public static double getCurrencyRate(String fileConfigPath, Currency outputCurrency) throws Exception {
        Document responseXML = CurrencyAPIHandler.getResponse(fileConfigPath);

        switch (outputCurrency){
            case USD:
                parseUSD(responseXML);
                break;
            case EUR:
                parseEUR(responseXML);
                break;
            default:
                throw new Exception("Currency is not accepted yet");
        }

        return currencyRate;
    }

    private static void parseUSD(Document responseXML){
        currencyRate = Double.parseDouble(responseXML.getElementsByTagName(Currency.RUB.name())
                .item(0)
                .getTextContent());
    }

    private static void parseEUR(Document responseXML){
        parseUSD(responseXML);
        currencyRate = currencyRate / Double.parseDouble(responseXML.getElementsByTagName(Currency.EUR.name())
                .item(0)
                .getTextContent());
    }

}

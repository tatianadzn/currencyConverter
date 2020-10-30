package com.tatianadzn.CurrencyConverter;

import org.w3c.dom.Document;

public abstract class JSONParsing {
    private static double dollarRate;

    public static double getDollarRate(){
        parseResponse(CurrencyAPIHandler.getResponse());
        return dollarRate;
    }

    private static void parseResponse(Document responseXML){
        dollarRate = Double.parseDouble(responseXML.getElementsByTagName("RUB")
                .item(0)
                .getTextContent());
    }

}

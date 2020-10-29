package com.tatianadzn.CurrencyConverter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.io.StringReader;

public abstract class JSONParsing {
    private static double dollarRate;

    public static double getDollarRate(){
        parseResponse(CurrencyAPIHandler.getResponse());
        return dollarRate;
    }

    private static void parseResponse(String response){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder;
        try
        {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(response)));

            dollarRate = Double.parseDouble(doc.getElementsByTagName("RUB")
                                                .item(0)
                                                .getTextContent());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}

package com.tatianadzn.CurrencyConverter;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public abstract class CurrencyAPIHandler {

    //from the config file later
    private static String myURL = "https://api.currencyfreaks.com/latest" +
                                    "?apikey=fbd79c17f4c549e9b72b07eaf064c128" +
                                    "&format=xml";


    public static Document getResponse(){
        try{
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI(myURL))
                    .GET()
                    .build();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();

            return builder.parse(new InputSource(new StringReader(HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString()).body())));


        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("something went wrong, try again later");
            System.exit(1);
        }
        return null;
    }
}

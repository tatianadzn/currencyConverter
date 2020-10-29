package com.tatianadzn.CurrencyConverter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class CurrencyAPIHandler {
    private static String result;

    //from the config file later
    private static String myURL = "https://api.currencyfreaks.com/latest" +
                                    "?apikey=fbd79c17f4c549e9b72b07eaf064c128" +
                                    "&format=xml";


    public static String getResponse(){
        try{
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI(myURL))
                    .GET()
                    .build();

            result = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString())
                    .body();

        }catch (URISyntaxException|IOException|InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println(result);
        return result;
    }
}

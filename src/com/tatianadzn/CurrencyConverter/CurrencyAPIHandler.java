package com.tatianadzn.CurrencyConverter;

import com.tatianadzn.ConfigLoader;
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

    public static Document getResponse(String configFilePath) throws Exception{
        Document response;
        try{
            String myURL = ConfigLoader.loadPropsFromConfig(configFilePath);
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(new URI(myURL))
                    .GET()
                    .build();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();

            response = builder.parse(new InputSource(new StringReader(HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString()).body())));

        }catch (Exception e){
            throw e;
        }
        return response;
    }
}

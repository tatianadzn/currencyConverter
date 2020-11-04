package com.tatianadzn;

import java.io.FileInputStream;
import java.util.Properties;

public abstract class ConfigLoader {

    public static String loadPropsFromConfig(String filePath) throws Exception{
        Properties props = new Properties();
        String APIUrl;

        try{
            props.load(new FileInputStream(filePath));
            APIUrl = props.getProperty("APIUrl");

        }catch (Exception e){
            throw e;
        }

        return APIUrl;
    }
}

package com.tatianadzn;

import java.io.FileInputStream;
import java.util.Properties;

public abstract class ConfigLoader {

    public static String loadPropsFromConfig(String filePath) throws Exception{
        Properties props = new Properties();
        String APIUrl;

        props.load(new FileInputStream(filePath));
        APIUrl = props.getProperty("APIUrl");

        return APIUrl;
    }
}

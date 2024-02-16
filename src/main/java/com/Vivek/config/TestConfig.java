package com.Vivek.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {
    private static final String CONFIG_FILE = "src/test/resources/resources.properties";

    private static Properties properties;
    public TestConfig(){
        loadConfig();
    }

    public Properties getAccess(){
        return properties;
    }

    private static void loadConfig(){
        try(FileInputStream input = new FileInputStream(CONFIG_FILE)){
            properties = new Properties();
            properties.load(input);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

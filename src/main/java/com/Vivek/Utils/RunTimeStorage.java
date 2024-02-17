package com.Vivek.Utils;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunTimeStorage {
    private static final Logger logger = Logger.getLogger(Class.class.getName());

    private static HashMap<String, String> storage = new HashMap<>();

    public static void storeValue(String key, String value){
        try{
            logger.log(Level.INFO, key + " -> " + value + " added.");
            storage.put(key, value);
        }catch (Exception e){
            logger.log(Level.WARNING, "Value cannot be stored: " + key + " -> " + value + "\n" + e.getStackTrace());
        }
    }

    public static String getValue(String key){
        String value = null;
        try{
            logger.log(Level.INFO, key + " -> " + storage.get(key) + " getting value.");
            value = storage.get(key);
        } catch (Exception e){
            logger.log(Level.WARNING, "Value did not found using key: " + key + " \n" + e.getStackTrace());
        }
        return value;
    }

    public static void clearStorage(){
        try {
            logger.log(Level.INFO, "Clearing RunTimeStorage.");
            storage.clear();
        } catch (Exception e){
            logger.log(Level.WARNING, "Storage cannot be cleared: " + e.getStackTrace());
        }
    }
}

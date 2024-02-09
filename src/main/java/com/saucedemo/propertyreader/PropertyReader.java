package com.saucedemo.propertyreader;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * I am creating propertyReader class to read the properties from config.properties file.
 * Variable Declaration: The class has a private static volatile variable named propInstance,
 * which is likely used to hold a single instance of the PropertyReader class.
 * Private Constructor: The class has a private constructor, which prevents the instantiation of the class from outside.
 * getInstance() Method: This method is a classic implementation of the Singleton design pattern.
 * It returns the single instance of the PropertyReader class.
 * If the instance doesn't exist yet, it creates one; otherwise, it returns the existing instance.
 * The method is synchronized to ensure thread safety, preventing multiple threads from creating separate instances concurrently.
 * getProperty() Method: This method reads a property value from the config.properties file located in the project's resources
 * directory. It takes a property name as input and returns its corresponding value from the properties file.
 * If the property is not found, it returns null.
 */
public class PropertyReader {
    /**
     * Created by Mahak
    Rules for implementing singleton design pattern
    1. Make the constructor private
    2. Create a static method to get the instance
    3. Create a static member variable
    */

    //Declare the PropertyReader variable
    private static volatile PropertyReader propInstance;

    //Create Private constructor Because of prevent the Instantiation of class
    private PropertyReader() {

    }

    /**
     * This method will return instance of PropertyReader class
     *
     * @return
     */
    public static synchronized PropertyReader getInstance() {
        if (propInstance == null) {
            propInstance = new PropertyReader();
        }
        return propInstance;
    }

    /**
     * This method will read property from property file
     *
     * @param propertyName
     * @return
     */
    public String getProperty(String propertyName) {

        Properties prop = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/propertiesfile/config.properties");
            prop.load(inputStream);
            if (prop.getProperty(propertyName) != null) {
                return prop.getProperty(propertyName);
            }
        } catch (Exception e) {
            System.out.println("Property not found");
        }
        return null;
    }
}

package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReadHelper {

    public static String getPropertyCustom(String property_value) {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            Properties property = new Properties();
            property.load(fis);

            return property.getProperty(property_value);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPropertyKey(String property_value) {

        String fromEnv = System.getenv(property_value);
        if (fromEnv != null && !fromEnv.isBlank()) {
            return fromEnv;
        }

        try {
            FileInputStream fis = new FileInputStream("src/main/resources/keys.properties");
            Properties property = new Properties();
            property.load(fis);

            return property.getProperty(property_value);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

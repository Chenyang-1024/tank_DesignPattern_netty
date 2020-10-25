package com.blackMamba.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Black Mamba on 2020/9/1 19:52
 *
 * @version 1.0
 * @description
 */
public class PropertiesMgr {

    public static Properties prop = new Properties();

    static {
        try {
            prop.load(PropertiesMgr.class.getClassLoader().getResourceAsStream("properties/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.singleton;

import config.ConfigTemp;
import config.ConfigYaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import config.LocalDateYamlConstructor;
import config.modelo.Alumno;
import org.yaml.snakeyaml.Yaml;


/**
 * esta clase se encarga de
 *
 *
 *
 * @author
 */
public class ConfigSingleton {

    private static ConfigSingleton instance = null;

    private ConfigSingleton() {
    }

    public static ConfigSingleton getInstance() {
        if (instance == null) {
            try {
                instance = new ConfigSingleton();
                Yaml yaml = new Yaml(new LocalDateYamlConstructor());

//                Properties p = new Properties();
//                ConfigYaml y = new ConfigYaml();
//                p.load(new FileInputStream("config/config.properties"));
//                y.setClave((String)p.get("clave"));
//                y.setManzanas(Integer.parseInt((String)
//                    p.get("manzanas")));
//                instance.config = yaml.loadAs(
//                    new FileInputStream("config/config.yml"),
//                         ConfigYaml.class);

                instance.c = yaml.loadAs(
                    new FileInputStream("config/config.yml"),
                    ConfigTemp.class);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ConfigSingleton.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConfigSingleton.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return instance;
    }


    private ConfigYaml config;

    private ConfigTemp c;

    public ConfigYaml getConfig() {
        return config;
    }

    public ConfigTemp getC() {
        return c;
    }

    public String getClave() {
        return config.getClave();
    }


}

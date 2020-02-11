/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config.singleton;

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
 *
 * @author oscar
 */
public class ConfigSingleton {

    private static ConfigSingleton instance = null;

    private ConfigSingleton() {
    }

    public static ConfigSingleton getInstance() {
        if (instance == null) {
            try {
                Yaml yaml = new Yaml(new LocalDateYamlConstructor());
                instance = yaml.loadAs(new FileInputStream("config/config.yml"),
                         ConfigSingleton.class);
                instance.appProps = new Properties();
                instance.appProps.load(new FileInputStream("config/config.properties"));

                instance.config = yaml.loadAs(new FileInputStream("config/config.yml"),
                         ConfigYaml.class);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ConfigSingleton.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConfigSingleton.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return instance;
    }

    private Properties appProps;

    public Properties getAppProps() {
        return appProps;
    }

    private ConfigYaml config;

    public ConfigYaml getConfig() {
        return config;
    }

    private String clave;
    private int manzanas;
    private List<String> frutas;
    private List<Alumno> alumnos;

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<String> getFrutas() {
        return frutas;
    }

    public void setFrutas(List<String> frutas) {
        this.frutas = frutas;
    }

    public int getManzanas() {
        return manzanas;
    }

    public void setManzanas(int manzanas) {
        this.manzanas = manzanas;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dam2
 */
public class YamlConfig {

    private static YamlConfig config;

    private YamlConfig() {

    }

    public static YamlConfig getInstance() {

        if (config == null) {
            try {
                Yaml yaml = new Yaml();
                config = yaml.loadAs(new FileInputStream("config/configuracionUsuario.yml"),
                        YamlConfig.class);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(YamlConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return config;
    }

    private String user;
    private String pass;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

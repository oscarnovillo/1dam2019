/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;



import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class Config {

//
//  rutaFicheros: ./ficheros/
//  ficheroArmarios: armarios.json
//  ficheroCasas: ropas.json
//  ficheroCasasArmarios: cajoneras.json

  private String rutaFicheros;
  private String ficheroArmarios;
  private String ficheroCasas;
  private String ficheroCasasArmarios;

  private static Config instance = null;

  private Config() {
  }

  public static Config getInstance() {
    if (instance == null) {
      try {
        instance = new Yaml().loadAs(
            new FileInputStream("config/config.yaml"),
            Config.class);
      } catch (FileNotFoundException ex) {
        Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
        Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
    return instance;
  }


  public void setRutaFicheros(String rutaFicheros) {
    this.rutaFicheros = rutaFicheros;
  }

  public void setFicheroArmarios(String ficheroArmarios) {
    this.ficheroArmarios = ficheroArmarios;
  }

  public void setFicheroCasas(String ficheroCasas) {
    this.ficheroCasas = ficheroCasas;
  }

  public void setFicheroCasasArmarios(String ficheroCasasArmarios) {
    this.ficheroCasasArmarios = ficheroCasasArmarios;
  }

  public static void setInstance(Config instance) {
    Config.instance = instance;
  }

  public String getRutaFicheros() {
    return rutaFicheros;
  }

  public String getFicheroArmarios() {
    return ficheroArmarios;
  }

  public String getFicheroCasas() {
    return ficheroCasas;
  }

  public String getFicheroCasasArmarios() {
    return ficheroCasasArmarios;
  }
}

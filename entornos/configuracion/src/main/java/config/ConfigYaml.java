/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;


import config.modelo.Alumno;

import java.util.List;

/**
 *
 * @author oscar
 */
public class ConfigYaml {
  
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

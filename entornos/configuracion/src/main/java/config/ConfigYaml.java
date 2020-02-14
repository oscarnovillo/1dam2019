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
  private int pp;
  private List<String> frutas;
  private List<Alumno> alumnos;

  public int getPp() {
    return pp;
  }

  public void setPp(int pp) {
    this.pp = pp;
  }

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

  @Override
  public String toString() {
    return "ConfigYaml{" +
        "clave='" + clave + '\'' +
        ", manzanas=" + manzanas +
        ", frutas=" + frutas +
        ", alumnos=" + alumnos +
        '}';
  }
}

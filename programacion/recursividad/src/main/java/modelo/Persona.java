package modelo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Persona {

  private String nombre;
  private boolean contagiada;
  private boolean inmune;
  private int diasContagio;
  private int probabilidadContagio;
  private int probabilidadContagiar;

  private Map<LocalDate, List<Persona>> contactos;

  public Persona(String nombre,int diasContagio,boolean contagiada, int probabilidadContagio, int probabilidadContagiar) {
    this.nombre = nombre;
    this.contagiada = contagiada;
    this.probabilidadContagio = probabilidadContagio;
    this.probabilidadContagiar = probabilidadContagiar;
    this.contactos = new HashMap<>();
  }

  public boolean isContagiada() {
    return contagiada;
  }

  public void setContagiada(boolean contagiada) {
    this.contagiada = contagiada;
  }

  public Map<LocalDate, List<Persona>> getContactos() {
    return contactos;
  }

  public void contagiar(LocalDate dia) {
    List<Persona> contacto = this.contactos.get(dia);
    if (contacto != null) {
      contacto.forEach(persona -> {
        if (!persona.isContagiada()) {
          persona.setContagiada(true);
          persona.contagiar(dia);
        }

      });
    }
  }

}

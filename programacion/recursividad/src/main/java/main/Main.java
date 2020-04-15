package main;

import modelo.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    List<Persona> personas = new ArrayList<>();
    Random r = new Random();
    for (int i =0;i<100000; i++)
    {
      Persona p =  new Persona("juan "+i,15,false,90,90);
      personas.add(p);
    }

    LocalDate hoy = LocalDate.now();
    for (int i=0; i<60;i++)

    {
      LocalDate e= hoy.plusDays(i);
      for (int j=0;j<20000; j++)
      {
        List<Persona> contacto = new ArrayList<>();
        for (int k=0;k<1000;k++)
        {
          contacto.add(personas.get(r.nextInt(personas.size())));
        }
        personas.get(r.nextInt(personas.size())).getContactos().put(e,contacto);
      }
      //hoy = hoy.plusDays(1);
    }



    //paciente 0.
    Persona paciente = personas.get(r.nextInt(personas.size()));
    paciente.setContagiada(true);
    //paciente.contagiar(hoy2);

    for (int i =0 ;i<60;i++) {
      LocalDate e = hoy.plusDays(i);
      personas.stream()
          .filter(persona -> persona.isContagiada())
          .forEach(persona -> persona.contagiar(e));
      long contagios = personas.stream()
          .filter(persona -> persona.isContagiada()).count();

      System.out.println(contagios + " ");
      //hoy2= hoy2.plusDays(1);

    }


  }


}

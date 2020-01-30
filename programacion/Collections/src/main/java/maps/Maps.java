/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 *
 * @author oscar
 */
public class Maps {

  public static void main(String[] args) {
    Map<String, Integer> alumnoSuspensos
            = new HashMap<>();

    alumnoSuspensos.put("Alejandro Novillo", 0);
    alumnoSuspensos.put("Pepe palotes", 70);
    System.out.println(
            alumnoSuspensos.put("Juana banana", 2));

    System.out.println(
            alumnoSuspensos.get("Juana banana"));

    alumnoSuspensos.remove("Juana banana", null);
    System.out.println(
            alumnoSuspensos.put("Juana banana", 20));

    System.out.println(
            alumnoSuspensos.get("Juana banana"));

    // recorrer el map
    Iterator<Integer> it
            = alumnoSuspensos.values().iterator();

    while (it.hasNext()) {
      System.out.println(it.next());
    }

    for (Integer i : alumnoSuspensos.values()) {
      System.out.println(i);
    }

    for (String nombre : alumnoSuspensos.keySet()) {
      System.out.println(nombre + " " + alumnoSuspensos.get(nombre));
    }

    for (Entry<String, Integer> alumno : alumnoSuspensos.entrySet()) {
      System.out.println(alumno.getKey() + " " + alumno.getValue());
    }

    alumnoSuspensos.keySet().stream().filter((nombre) -> (alumnoSuspensos.get(nombre) == 0))
            .forEachOrdered((nombre) -> {
      System.out.println(nombre + " " + alumnoSuspensos.get(nombre));
    });

    alumnoSuspensos.keySet()
            .stream()
            .filter((t) -> {
              return alumnoSuspensos.get(t) == 0; //To change body of generated lambdas, choose Tools | Templates.
            }).collect(Collectors.toList());
            

    alumnoSuspensos.keySet()
            .stream()
            .forEach(
                    (t) -> {
                      if (alumnoSuspensos.get(t) == 0)
                        System.out.println(t);
                    });

    


  }
  
  


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.ArrayList;
import java.util.List;
import quevedo.collections.main.Raro;

/**
 *
 * @author oscar
 */
public class Listas {
  
  public static void main(String[] args) {
    
    List<String> nombres =  new ArrayList<>();
    nombres.add("nombre");
    nombres.add(0,"kk");
    
    String nombre = nombres.get(0);
           
    for (int i = 0; i < nombres.size(); i++) {
      System.out.println(i + " "+nombres.get(i));
    }
    
    for(String elemento : nombres )
    {
      System.out.println(elemento);
    }
    
    nombres.forEach(System.out::println);
    
    for(String elemento : nombres )
    {
      
      //System.out.println(elemento.toUpperCase());
      //nombres.remove(elemento);
      elemento = elemento.toUpperCase();
      //nombres.set(0, elemento);
      //nombres.add(elemento);
    }
    
    nombres.remove("nombre");
            
      System.out.println("");      
    nombres.forEach(System.out::println);
    
     
     
     
     List<Raro> raros = new ArrayList<>();
     raros.add(new Raro("kk"));
     raros.add(new Raro("nombre"));
    for(Raro elemento : raros )
    {
      //System.out.println(elemento.toUpperCase());
      elemento.setNombre
        (elemento.getNombre().toUpperCase());
    }
    
    raros.remove(new Raro("NOMBRE"));
            
      System.out.println("");      
    raros.forEach(System.out::println);
    
    Raro raro = raros.get(raros.indexOf(new Raro("KK")));
    
  }
  
}

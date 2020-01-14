/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.github.javafaker.Faker;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 *
 * @author oscar
 */
public class DaoFaker {
  
  private String[] nombres;

  public DaoFaker(int size) {
    Faker faker = new Faker(new Locale("ES"));
    
    Set<String> nombresPrincesBride = 
            new HashSet<>();
    int cont=0;
    do{
      nombresPrincesBride.add(faker.color().name());
    }while(nombresPrincesBride.size()<size);
    
    String[] nombres = 
            nombresPrincesBride.toArray(new String[0]);
    
  }

  public String[] getNombres() {
    return nombres;
  }
  
  
  
}

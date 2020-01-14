/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.github.javafaker.Faker;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 *
 * @author oscar
 */
public class MainFaker {
  
  public static void main(String[] args) {
    
    Faker faker = new Faker(new Locale("ES"));
    
    Set<String> nombresPrincesBride = 
            new HashSet<>();
    int cont=0;
    do{
      nombresPrincesBride.add(faker.color().name());
    }while(nombresPrincesBride.size()<10);
    
    String[] nombres = 
            nombresPrincesBride.toArray(new String[0]);
    
    for (int i = 0; 
            i < nombres.length; 
            i++) {
      System.out.println(nombres[i]);
    }
    
  }
  
}

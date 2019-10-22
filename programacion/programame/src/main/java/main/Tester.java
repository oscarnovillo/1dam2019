/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author oscar
 */
public class Tester {

  public static void main(String[] args) throws IOException {
     String entrada = "3 2\n" +
"1 2 2 5 2 4\n" +
"2 1 3 3\n" +
"1 1\n" +
"1000000 40\n" +
"1000000 40";
    
   final ByteArrayInputStream input 
		= new ByteArrayInputStream(entrada.getBytes());
		System.setIn(input);
    
    Houston511.main(args);
  }

}

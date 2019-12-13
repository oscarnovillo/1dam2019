/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author oscar
 */
public class TresRaya {
  
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
//    System.out.println("dime nombre");
//    String nombre = sc.nextLine();
//    
//    System.out.println("dime caracter");
//    char caracter = sc.nextLine().charAt(0);
//    
    
    char caracter[][] = new char[3][3];
    
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        caracter[i][j]= '-';
      }
    }

    char miletrita = 'a';
    
    caracter[0][0] = 'a';
    
    
    miletrita = 90;
    
    miletrita -= 25;
    
    char letra = 'O';
    char letra2 = 'X';    
    
    
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(" "+caracter[i][j]+" ");
      }
      System.out.println("");
    }
    
    int veces = 0;
   for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (veces %2 ==0)
          caracter[i][j]= letra;
        else
          caracter[i][j]= letra2;
        
        veces ++;
      }
    }
    
     
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(" "+caracter[i][j]+" ");
      }
      System.out.println("");
    }
    
    System.out.println(miletrita);
   
    
    
    
    
    
    
    
  }
  
  
}

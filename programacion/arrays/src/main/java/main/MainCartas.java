/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import modelo.Carta;

/**
 *
 * @author oscar
 */
public class MainCartas {

  public static void main(String[] args) {
    Carta baraja[] = new Carta[40];
    for (int i = 0; i < 40; i++) {
      baraja[i] = new Carta();
    }

    for (int i = 0; i < 10; i++) {
      baraja[i].setValor(i + 1);
      baraja[i + 10].setValor(i + 1);
      baraja[i + 20].setValor(i + 1);
      baraja[i + 30].setValor(i + 1);
      baraja[i].setPalo(1);
      baraja[i + 10].setPalo(2);
      baraja[i + 20].setPalo(3);
      baraja[i + 30].setPalo(4);
    }

    Random r =  new Random();
    for (int i=0; i<10000; i++)
    {
      int pos1 = r.nextInt(40);
      int pos2 = r.nextInt(40);
      Carta swap = baraja[pos1];
      baraja[pos1] = baraja[pos2];
      baraja[pos2] = swap;
    }
    
    
    System.out.println(Arrays.toString(baraja));
    
    for (int i = 0; i < 40; i++) {
      System.out.println(i + "{ " + baraja[i].getValor()
              + "," + baraja[i].getPalo() + "}");
    }

  }

}

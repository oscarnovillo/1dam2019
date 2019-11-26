/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;
import modelo.Carta;

/**
 *
 * @author oscar
 */
public class Examen22CartasReloj {

  public static void main(String[] args) {
    Carta baraja[] = new Carta[40];
    Carta baraja2[] = new Carta[40];
    creaBaraja(baraja);
    creaBaraja(baraja2);

    int indiceJuego = 0;
    boolean salir = false;
            int numCollejas =0;

    for (int i = 0; i < baraja.length 
            && !salir ; i++) {
      indiceJuego++;
      System.out.println("1 " + baraja[i].getValor());
      if (baraja[i].getValor() == indiceJuego) {
        System.out.println("pierdes");
        for (int j=i+1; j<baraja.length; j++)
          numCollejas += baraja[i].getValor();
        salir = true;
      }

      indiceJuego++;
      if (baraja2[i].getValor() == indiceJuego) {
        System.out.println("pierdes");
        for (int j=i+1; j<baraja.length; j++)
          numCollejas += baraja2[i].getValor();
        salir = true;
      }
      System.out.println("2 " + baraja2[i].getValor());

      indiceJuego %= 10;
    }
    
    if (!salir)
    {
      System.out.println("no le pegamos a nadie");
    }

  }

  public static void creaBaraja(Carta baraja[]) {
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

    Random r = new Random();
    for (int i = 0; i < 10000; i++) {
      int pos1 = r.nextInt(40);
      int pos2 = r.nextInt(40);
      Carta swap = baraja[pos1];
      baraja[pos1] = baraja[pos2];
      baraja[pos2] = swap;
    }
  }
}

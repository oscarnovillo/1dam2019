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
public class Examen22Cartas {

  public static void main(String[] args) {
    Carta baraja[] = new Carta[40];
    Carta baraja2[] = new Carta[40];
    creaBaraja(baraja);
    creaBaraja(baraja2);

    int posiciones[] = new int[10];
    int posiciones2[] = new int[10];

    for (int i = 0; i < baraja.length; i++) {
      posiciones[baraja[i].getValor() - 1] += i + 1;
      posiciones2[baraja2[i].getValor() - 1] += i + 1;
    }

    int puntos1 = 0;
    int puntos2 = 0;

    for (int i = 0; i < posiciones.length; i++) {
      if (posiciones[i] > posiciones2[i]) {
        puntos1++;
      } else if (posiciones[i] < posiciones2[i]) {
        puntos2++;
      }
    }

    if (puntos1 > puntos2) {
      System.out.println("ha ganado el 1 con " + puntos1);
    } else if (puntos1 < puntos2) {
      System.out.println("ha ganado el 2 con " + puntos1);
    } else {
      System.out.println("empate");
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

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
public class ExamenCartaCorridaDarthMaul {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Random r = new Random();
    int nJugadores = sc.nextInt();
    int jugadores[] = new int[nJugadores];
    int perdidasJugadores[] = new int[nJugadores];
    int probabilidadesCambio[] = new int[nJugadores];

    int indiceBarajea = 0;
    int indiceTurno = 0;
    int indiceRepartirCartas = 0;
    int indiceSiguienteTurno = 0;
    boolean pierdeBarajea = false;

    Carta baraja[] = crearBaraja();

    System.out.println("indice DM");
    int indiceDM = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < nJugadores; i++) {
      if (i != indiceDM) {
        System.out.println("cuanto cambio");
        probabilidadesCambio[i] = sc.nextInt();
        sc.nextLine();
      }
    }

    for (int i = 0; i < nJugadores; i++) {
      barajar(baraja);
      pierdeBarajea = false;

      indiceTurno = (indiceBarajea + 1) % nJugadores;
      indiceSiguienteTurno = (indiceTurno + 1) % nJugadores;

      indiceRepartirCartas = indiceTurno;
      for (int j = 0; j < nJugadores; j++) {
        jugadores[indiceRepartirCartas] = baraja[j].getValor();
        indiceRepartirCartas = (indiceRepartirCartas + 1) % nJugadores;
      }

      System.out.println(baraja[0].getValor() + " " + Arrays.toString(jugadores));

      for (int j = 0; j < nJugadores; j++) {
        System.out.println(indiceBarajea + " " + indiceTurno + " " + indiceSiguienteTurno);
        System.out.println("Jugador " + indiceTurno + " Tu carta es un " + jugadores[indiceTurno] + " quieres cambiar carta??? 1 Si 0 No");
        int cambiaCarta = sc.nextInt();
        sc.nextLine();
        if (indiceTurno != indiceDM) {
          if (r.nextInt(100) <= probabilidadesCambio[indiceTurno]) {
            cambiaCarta = (cambiaCarta + 1) % 2;
          }
        }

        if (indiceTurno != indiceBarajea) {
          if (cambiaCarta == 1) {
            if (jugadores[indiceSiguienteTurno] != 10) {
              int swap = jugadores[indiceTurno];
              jugadores[indiceTurno] = jugadores[indiceSiguienteTurno];
              jugadores[indiceSiguienteTurno] = swap;
            } else {
              System.out.println("tiene un 10 el siguiente no se puede cambiar");
            }
          }
        } else // el que barajea saca carta aleatoria
        {
          if (cambiaCarta == 1) {
            if (indiceTurno != indiceDM) {
              int indiceCorte = r.nextInt(40 - nJugadores) + nJugadores;
              jugadores[indiceTurno] = baraja[indiceCorte].getValor();
              if (jugadores[indiceTurno] == 10) {
                perdidasJugadores[indiceTurno]++;
                pierdeBarajea = true;
              }
            } else {
              jugadores[indiceTurno] = 9;
            }
          }
        }

        indiceTurno = (indiceTurno + 1) % nJugadores;
        indiceSiguienteTurno = (indiceSiguienteTurno + 1) % nJugadores;
      }
      if (!pierdeBarajea) {
        System.out.println("Mirar quien pierde" + Arrays.toString(jugadores));
        int cartaPierde = 10;
        for (int j = 0; j < nJugadores; j++) {
          if (jugadores[j] < cartaPierde) {
            cartaPierde = jugadores[j];
          }
        }

        for (int j = 0; j < nJugadores; j++) {
          if (jugadores[j] == cartaPierde) {
            perdidasJugadores[j]++;
          }
        }
      }
      System.out.println("Mirar quien pierde" + Arrays.toString(perdidasJugadores));

      indiceBarajea = (indiceBarajea + 1) % nJugadores;
    }

    int pierdeMenosVeces = nJugadores;
    for (int j = 0; j < nJugadores; j++) {
      if (perdidasJugadores[j] < pierdeMenosVeces) {
        pierdeMenosVeces = jugadores[j];
      }
    }
    
    for (int j = 0; j < nJugadores; j++) {
      if (perdidasJugadores[j] == pierdeMenosVeces) {
        System.out.println(" Jugador " + j + " va a ser manteado");
      }
    }

    
  }

  public static Carta[] crearBaraja() {
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
    return baraja;
  }

  public static void barajar(Carta[] baraja) {
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

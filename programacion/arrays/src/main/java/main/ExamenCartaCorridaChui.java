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
public class ExamenCartaCorridaChui {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Random r = new Random();
    int nJugadores = sc.nextInt();
    int jugadores[] = new int[nJugadores];
    int perdidasJugadores[] = new int[nJugadores];
    boolean muertos[] = new boolean[nJugadores];
    int ultimaApuesta = 0;
    int apuestas = 0;
    int apuestaJugador = 0;

    int indiceBarajea = 0;
    int indiceTurno = 0;
    int nMuertos = 0;
    int indiceRepartirCartas = 0;
    int indiceSiguienteTurno = 0;
    boolean pierdeBarajea = false;

    Carta baraja[] = crearBaraja();
    System.out.println("indice chui");
    int indiceChui = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < nJugadores; i++) {
      do {
        System.out.println("cuanto apuestas?");
        apuestaJugador = sc.nextInt();
        sc.nextLine();
      } while (apuestaJugador < ultimaApuesta);
      apuestas += apuestaJugador;
      ultimaApuesta = apuestaJugador;
    }

    for (int i = 0; i < nJugadores; i++) {
      barajar(baraja);
      pierdeBarajea = false;

      indiceTurno = siguienteVivo(muertos, indiceTurno, nJugadores);
      indiceSiguienteTurno = siguienteVivo(muertos, indiceTurno, nJugadores);

      indiceRepartirCartas = indiceTurno;
      for (int j = 0; j < nJugadores; j++) {
        if (!muertos[j]) {
          jugadores[indiceRepartirCartas] = baraja[j].getValor();
          indiceRepartirCartas = siguienteVivo(muertos, indiceRepartirCartas, nJugadores);
        }
      }

      System.out.println(baraja[0].getValor() + " " + Arrays.toString(jugadores));

      for (int j = 0; j < nJugadores; j++) {
        System.out.println(indiceBarajea + " " + indiceTurno + " " + indiceSiguienteTurno);
        System.out.println("Jugador " + indiceTurno + " Tu carta es un " + jugadores[indiceTurno] + " quieres cambiar carta??? 1 Si 0 No");
        int cambiaCarta = sc.nextInt();
        sc.nextLine();

        if (indiceTurno != indiceBarajea) {
          if (cambiaCarta == 1) {

            if (jugadores[indiceSiguienteTurno] != 10) {

              if (indiceSiguienteTurno == indiceChui
                      && jugadores[indiceTurno] < jugadores[indiceSiguienteTurno]) {
                // desmiembro a jugador
                muertos[indiceTurno] = true;

              } else {

                int swap = jugadores[indiceTurno];
                jugadores[indiceTurno] = jugadores[indiceSiguienteTurno];
                jugadores[indiceSiguienteTurno] = swap;
              }

            } else {
              System.out.println("tiene un 10 el siguiente no se puede cambiar");
            }

          }
        } else // el que barajea saca carta aleatoria
        {
          if (cambiaCarta == 1) {
            int indiceCorte = r.nextInt(40 - nJugadores) + nJugadores;
            jugadores[indiceTurno] = baraja[indiceCorte].getValor();
            if (jugadores[indiceTurno] == 10) {
              perdidasJugadores[indiceTurno]++;
              pierdeBarajea = true;
            }
          }
        }
        indiceTurno = siguienteVivo(muertos, indiceTurno, nJugadores);
        indiceSiguienteTurno = siguienteVivo(muertos, indiceTurno, nJugadores);
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

      indiceBarajea = siguienteVivo(muertos, indiceBarajea, nJugadores);

      for (int j = 0; j < nJugadores; j++) {
        if (muertos[j]) {
          nMuertos++;
        }
      }

      if (nMuertos == nJugadores - 1) {
        i = nJugadores;
      }
    }

    if (nMuertos == nJugadores - 1) {
      int pierdeMenosVeces = nJugadores;
      for (int j = 0; j < nJugadores; j++) {
        if (perdidasJugadores[j] < pierdeMenosVeces) {
          pierdeMenosVeces = jugadores[j];
        }
      }
      int nJugadoresGanadores = 0;
      for (int j = 0; j < nJugadores; j++) {
        if (perdidasJugadores[j] == pierdeMenosVeces) {
          System.out.println(" Jugador " + j + " ha ganado");
          nJugadoresGanadores++;
        }
      }

      System.out.println(" Se llevan " + (apuestas * 1.0 / nJugadoresGanadores));
    } else {
      System.out.println("gana chui por incomaprecencia");
    }
  }

  public static int siguienteVivo(boolean muertos[], int indice, int nJugadores) {
    int indiceSiguienteVivo = 0;
    do {
      indiceSiguienteVivo = (indice + 1) % nJugadores;
    } while (muertos[indiceSiguienteVivo]);
    return indiceSiguienteVivo;
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

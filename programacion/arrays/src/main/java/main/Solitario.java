/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
import java.util.Random;
import modelo.Carta;

/**
 *
 * @author oscar
 */
public class Solitario {

    public static void main(String[] args) {
        Carta bNoVista[] = new Carta[40];
        setUpBarajaImpares(bNoVista);
        Carta bVista[] = new Carta[40];
        int mesa[] = new int[4];

        int indVista = 0;
        int indNoVista = bNoVista.length;
        boolean cartaColocada = false;
        boolean cartaColocadaVista = false;

        do {
            cartaColocada = false;
            imprimirBaraja(bNoVista, indNoVista);
            System.out.println("");
            // scar mazo no vista
            for (int i = indNoVista - 1;
                    i >= 0; i -= 2) {
                bVista[indVista]
                        = bNoVista[i];
                indVista++;

                if (i>0){
                    bVista[indVista]
                            = bNoVista[i - 1];
                    indVista++;
                }
              System.out.println("cartas nuevas");
                //jugar carta vista
                do {
                    cartaColocadaVista = false;
                    Carta cartaVista = bVista[indVista - 1];
                    if (mesa[cartaVista.getPalo()]
                            == cartaVista.getValor() - 1) {
                        indVista--;
                        mesa[cartaVista.getPalo()]++;
                        cartaColocadaVista = true;
                        cartaColocada = true;
                    }
                    System.out.println(cartaVista + " " + Arrays.toString(mesa));
                } while (cartaColocadaVista && indVista > 0);

            }

            indNoVista = volverBarajaVista(bNoVista, bVista, indVista);
            indVista = 0;

        } while (cartaColocada);

        if (indNoVista > 0) {
            System.out.println(" No has acabado");
        } else {
            System.out.println(" EXITO ");
        }

    }

    public static void imprimirBaraja(Carta[] baraja, int max) {
        for (int i = 0; i < max; i++) {
            System.out.print(baraja[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println("");
            }
        }
    }
    
    

    public static int volverBarajaVista(Carta[] bNoVista, Carta[] bVista, int indVista) {
        int indNoVista = 0;
        // volver las cartas al mazo novista
        for (int i = indVista - 1;
                i >= 0; i--) {
            bNoVista[indNoVista] = bVista[i];
            indNoVista++;
        }
        return indNoVista;

    }

    public static void setUpBaraja(Carta[] baraja) {
        for (int i = 0; i < 40; i++) {
            baraja[i] = new Carta();
        }

        for (int i = 9; i >= 0; i--) {
            baraja[i].setValor(i + 1);
            baraja[i + 10].setValor(i + 1);
            baraja[i + 20].setValor(i + 1);
            baraja[i + 30].setValor(i + 1);
            baraja[i].setPalo(0);
            baraja[i + 10].setPalo(1);
            baraja[i + 20].setPalo(2);
            baraja[i + 30].setPalo(3);
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
    
    
    public static void setUpBarajaResuelta(Carta[] baraja) {
        for (int i = 0; i < 40; i++) {
            baraja[i] = new Carta();
        }

        for (int i = 9; i >= 0; i--) {
            baraja[i].setValor(i + 1);
            baraja[i + 10].setValor(i + 1);
            baraja[i + 20].setValor(i + 1);
            baraja[i + 30].setValor(i + 1);
            baraja[i].setPalo(0);
            baraja[i + 10].setPalo(1);
            baraja[i + 20].setPalo(2);
            baraja[i + 30].setPalo(3);
        }

        
    }
    
    
     public static void setUpBarajaImpares(Carta[] baraja) {
        for (int i = 0; i < 40; i++) {
            baraja[i] = new Carta();
        }

        for (int i = 9; i >= 0; i--) {
            baraja[i].setValor(i + 1);
            baraja[i + 10].setValor(i + 1);
            baraja[i + 20].setValor(i + 1);
            baraja[i + 30].setValor(i + 1);
            baraja[i].setPalo(0);
            baraja[i + 10].setPalo(1);
            baraja[i + 20].setPalo(2);
            baraja[i + 30].setPalo(3);
        }

        
        int pos1 = 0;
        int pos2 = 1;
            Carta swap = baraja[pos1];
            baraja[pos1] = baraja[pos2];
            baraja[pos2] = swap;
        pos1 = 39;
        pos2 = 0;
            swap = baraja[pos1];
            baraja[pos1] = baraja[pos2];
            baraja[pos2] = swap;      
        pos1 = 0;
        pos2 = 1;
            swap = baraja[pos1];
            baraja[pos1] = baraja[pos2];
            baraja[pos2] = swap;      

            
        pos1 = 10;
        pos2 = 11;
            swap = baraja[pos1];
            baraja[pos1] = baraja[pos2];
            baraja[pos2] = swap;      
        pos1 = 20;
        pos2 = 21;
            swap = baraja[pos1];
            baraja[pos1] = baraja[pos2];
            baraja[pos2] = swap;      
        pos1 = 30;
        pos2 = 31;
            swap = baraja[pos1];
            baraja[pos1] = baraja[pos2];
            baraja[pos2] = swap;      
    }

}

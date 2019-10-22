package main;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Houston511 {

    public static void main(String[] args) throws IOException {

        //    InputStreamReader isr = new InputStreamReader(System.in);
        //    BufferedReader br = new BufferedReader(isr);
        //    String line = null;
        //    String[] temp;
        Scanner sc = new Scanner(System.in);
        int indice1 = 0;
        int indice2 = 0;
        int suma = 0;
        int menor = 0;
        int mayor = 0;
        int numeros = 0;

        while (sc.hasNextInt()) {

            indice1 = 0;
            indice2 = 0;
            suma = 0;
            menor = 0;
            numeros = 0;
//            temp = line.split(" ");
            int casosA = sc.nextInt();
            int casosB = sc.nextInt();

            int[] entrada1 = new int[casosA * 2];
            int[] entrada2 = new int[casosB * 2];

//            line = br.readLine();
            int tamano1 = 0;
//            temp = line.split(" ");
            for (int i = 0; i < entrada1.length; i++) {
                entrada1[i] = sc.nextInt();
                if (i % 2 == 0) {
                    tamano1 += entrada1[i];
                }
            }

//            line = br.readLine();
//            temp = line.split(" ");
            for (int i = 0; i < entrada2.length; i++) {
                entrada2[i] = sc.nextInt();
            }

            while (numeros < tamano1) {

                menor = entrada2[indice2];
                if (entrada1[indice1] < entrada2[indice2]) {
                    menor = entrada1[indice1];
                }

                suma += entrada1[indice1 + 1] * entrada2[indice2 + 1] * menor;

                numeros += menor;
                entrada1[indice1] -= menor;
                entrada2[indice2] -= menor;
                if (entrada1[indice1] <= 0) {
                    indice1 += 2;
                }
                if (entrada2[indice2] <= 0) {
                    indice2 += 2;
                }
            }
            System.out.println(suma);
        }
    }
}
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
public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numero1 = sc.nextInt();
        int numero2 = sc.nextInt();

        if (numero1
                > numero2) {
            int swap = numero2;
            numero2 = numero1;
            numero1 = swap;
        }

        for (int i = numero1; i <= numero2; i++) {
            System.out.println(i);
        }
    }

}

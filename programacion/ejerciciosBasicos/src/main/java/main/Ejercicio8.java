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
public class Ejercicio8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mayor;
        int menor;
        // el primer numero
        mayor = sc.nextInt();
        menor = mayor;
        
        for (int i = 1; i < 10; i++) {
            int numero = sc.nextInt();
            if (numero > mayor)
                mayor = numero;
            if (numero < menor)
                menor = numero;
        }
        
        System.out.println(mayor + " "+menor);
    }

}

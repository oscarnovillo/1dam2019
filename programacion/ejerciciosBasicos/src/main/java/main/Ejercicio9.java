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
public class Ejercicio9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero;
        numero = sc.nextInt();
        int factorial = 1;
        for (int i = numero; i > 1; i--) {
            factorial *= i;
        }

        System.out.println(factorial);
    }

}

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
public class Condicional {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime tu edad");
        int edad = sc.nextInt();
        System.out.println("Dime tu edad mental");
        int edadMental = sc.nextInt();

        boolean jubilado = true;
        jubilado = false;
        jubilado = (edad >= 65);

        if (jubilado) {
            System.out.println("felicidades");
        } else if (edad >= 18) {
            System.out.println("mayor ");
        } else {
            System.out.println("menor");
        }

        System.out.println("Dime uyn numero");
        int numero = sc.nextInt();

        switch (numero) {
            case 1:
                System.out.println("UNO");
            case 2:
                System.out.println("DOS");
                break;
            case 3:
                System.out.println("TRES");
                break;
            case 4:
                System.out.println("CUATRO");
                break;
            default:
                break;
        }

    }

}

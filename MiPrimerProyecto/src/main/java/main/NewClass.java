package main;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oscar
 */
public class NewClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime tu nombre, por favor:");
        String nombreDelUsuario = sc.nextLine();
        System.out.println("Hello " + nombreDelUsuario);
        System.out.println("Dime un numero:");
        int numero = sc.nextInt();
        int doble = numero *2;
        System.out.println("el doble del numero es " + doble);
    }
    

}

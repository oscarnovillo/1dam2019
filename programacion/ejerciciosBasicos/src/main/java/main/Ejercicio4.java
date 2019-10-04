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
public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int suma = 0;
        for (int i = 0; i < 15; i++) {
            suma += sc.nextInt();
        }
        
        System.out.println(suma / 15.0);
    }
}

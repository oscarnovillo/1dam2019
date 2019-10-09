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
public class Ejercicio6 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int horas = sc.nextInt();
        int minutos = sc.nextInt();
        int segundos = sc.nextInt();
        
        minutos += horas *60;
        
        minutos += segundos /60;
        
        System.out.println(minutos);
    }
    
}

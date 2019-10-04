/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;

/**
 *
 * @author oscar
 */
public class Ejercicio11 {
    
    public static void main(String[] args) {
        Random r = new Random();
        
        for ( int i=0; i<100; i++)
        System.out.println(r.nextInt(11)+10);
        
    }
    
}

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
public class Sumatorio {
    
    public static void main(String[] args) {
        
        int numero = 1;
        int sumatorio = 0;
        
        while (sumatorio <125)
        {
            numero ++;
            sumatorio = 0;
            for (int i=1; i<= numero;i++)
            {
                sumatorio += i;
            }
        }
        System.out.println(numero);
        
    }
    
}

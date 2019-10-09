/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author oscar
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        int suma = 0;
        int num = 1;
        while (suma < 125) {
            num++;

            suma = 0;
            for (int i = 0; i <= num; i++) {
                suma += i;
            }
            
//            for (int i = num; i> 0; i--)
//            {
//                suma += i;
//            }

        }
        
        System.out.println(num);
        
        
        // otra manera
        
        suma = 0;
        int i;
        for (i=0; suma <= 125; i++)
        {
            suma += i;
        }

        
        System.out.println(i-1);
        
        System.out.println(num);
        num = 0;
        suma =0 ;
        
        
        while (suma <= 125)
        {
            num ++;
            suma += num;
        }
        System.out.println(num);
        
        

    }

}

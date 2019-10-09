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
public class Repetitivas {

    public static void main(String[] args) {
        int num = 1;
        while (num <= 10) {
            System.out.println(num);
            num++;
        }
        num = 19;

        for (int i = 1; i <= 10;
                i++) {
            System.out.println(" no se escribe en la pizarra");
        }

        do {
            System.out.println("por lo menos una vez");
        } while (false);

    }
}

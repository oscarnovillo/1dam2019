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
public class Ejericicio7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int segundos = sc.nextInt();
        int minutos;
        int horas;

        minutos = segundos / 60;

        segundos = segundos % 60;

        horas = minutos / 60;

        minutos = minutos % 60;

        System.out.println(horas + ":" + minutos + ":" + segundos);
    }
}

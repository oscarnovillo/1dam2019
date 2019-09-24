package ejercicios;

import java.util.Scanner;

public class Ejercicios {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("dame la base:");
        int base = sc.nextInt();
        System.out.print("dame la altura:");
        int altura = sc.nextInt();
        int perimetro = altura * 2 + base * 2;
        int area = base * altura;
        System.out.println("el perimetro es " + perimetro + " area = " + area);

        System.out.print("dame cateto1:");
        int cateto1 = sc.nextInt();
        System.out.print("dame cateto2:");
        int cateto2 = sc.nextInt();
        sc.nextLine();
        double hipotenusa = Math.hypot(cateto1, cateto2);
        System.out.println("la hipotenusa =  " + hipotenusa);

        System.out.println("dime tu nombre");
        String nombre = sc.nextLine();
        System.out.println("Hola " + nombre);

        System.out.print("dame num 1:");
        int num1 = sc.nextInt();
        System.out.print("dame num 2:");
        int num2 = sc.nextInt();
        int suma = num1 + num2;
        int resta = num1 - num2;
        int multiplicacion = num1 * num2;
        int division = num1 / num2;
        System.out.println(
                suma + " " + resta + " " + multiplicacion + " " + division);


        System.out.print("dame grados farenhait:");
        double gradosFarenhait = sc.nextDouble();
        double celsius = (gradosFarenhait - 32) * 5 / 9.0;
        System.out.println("en celsius" + celsius);

        System.out.print("dame num 1:");
        num1 = sc.nextInt();
        System.out.print("dame num 2:");
        num2 = sc.nextInt();
        System.out.print("dame num 3:");
        int num3 = sc.nextInt();

        double media = (num1+num2+num3)/3.0;
        System.out.println("la media es"+media);



        System.out.print("dame minutos:");
        int minutos = sc.nextInt();

        int horas = minutos / 60;
        int restoMinutos = minutos % 60;
        System.out.println("horas "+horas+" minutos"+restoMinutos);

        System.out.print("dame ventas:");
        int ventas = sc.nextInt();
        System.out.print("dame sueldo base:");
        int sueldoBase = sc.nextInt();
        double comision = ventas * 0.10;
        double sueldo = sueldoBase+ventas * 0.10;
        System.out.println(
                "sueldo "+sueldo);


    }
}

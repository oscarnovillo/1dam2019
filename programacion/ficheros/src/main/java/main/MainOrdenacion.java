package main;

import dao.modelo.Animal;
import dao.modelo.Guardable;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;

public class MainOrdenacion {

  public static void main(String[] args) {
      Set<Animal> animales = new TreeSet<>();
      Animal a = new Animal("z",2, LocalDate.of(2000,1,1));
      animales.add(a);
    animales.add(a);
    animales.add(new Animal("z",5,LocalDate.of(2000,1,1)));
    animales.add(new Animal("a",2,LocalDate.of(2000,1,1)));
    animales.add(new Animal("b",2,LocalDate.of(2000,1,1)));

    //animales.forEach(System.out::println);

    animales.add(new Animal("c",2,LocalDate.of(2000,1,1)));
    animales.forEach(System.out::println);
    try  (BufferedWriter bw =
              Files.newBufferedWriter(Paths.get("./animales.obj")
                  )
          )
    {
      PrintWriter pw = new PrintWriter(bw);
      animales.forEach(animal -> pw.println(animal.guardar()));
    } catch (IOException e) {

    }

    Set<Guardable> animales2 = new TreeSet<>();

    try {
      Files.readAllLines(Paths.get("./animales.obj")).forEach(s -> {
        Animal animal = new Animal();
       animal.cargar(s);
        animales2.add(animal);
      });
    } catch (IOException e) {

    }

    animales2.forEach(System.out::println);
  }
}

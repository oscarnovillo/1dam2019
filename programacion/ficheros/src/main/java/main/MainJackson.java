package main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.modelo.Animal;
import dao.modelo.Armario;
import dao.modelo.Cajonera;
import dao.modelo.Ropa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class MainJackson {

  public static void main(String[] args) throws IOException {
    Set<Animal> animales = new TreeSet<>();

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());



    Animal a = new Animal("z", 2, LocalDate.of(2000, 1, 1));
    animales.add(a);
    animales.add(a);
    animales.add(new Animal("z", 5, LocalDate.of(2000, 1, 1)));
    animales.add(new Animal("a", 2, LocalDate.of(2000, 1, 1)));
    animales.add(new Animal("b", 2, LocalDate.of(2000, 1, 1)));

    //animales.forEach(System.out::println);

    animales.add(new Animal("c", 2, LocalDate.of(2000, 1, 1)));
    animales.forEach(System.out::println);


    mapper.writeValue(Files.newBufferedWriter(Paths.get("./animales.json")), animales);


    Set<Animal> animales2;
    animales2 = mapper.readValue(Files.newBufferedReader(Paths.get("./animales.json")),
        new TypeReference<TreeSet<Animal>>() {
        });


    animales2.forEach(System.out::println);


    Animal animal = mapper.readValue(Files.newBufferedReader(Paths.get("./animal.json")), Animal.class);
    System.out.println(
        animal);


    List<Ropa> prendas = new ArrayList<>();
    prendas.add(new Ropa("M","pantalones"));
    prendas.add(new Ropa("M","polo de pijo"));

    Armario armario = new Armario("habitacion 1",200,prendas,new Cajonera(3,50,50));

    Map<String,Armario> armarios = new LinkedHashMap<>();

    armarios.put(armario.getUbicacion(),armario);
    mapper.writeValue(Files.newOutputStream(Paths.get("./armarios.json")),armarios);

    System.out.println(mapper.writeValueAsString(armarios));

  }
}

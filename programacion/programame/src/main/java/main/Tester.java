/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * @author oscar
 */
public class Tester {

  public static void main(String[] args) throws IOException {
//    String entrada = "3 2\n" +
//        "1 2 2 5 2 4\n" +
//        "2 1 3 3\n" +
      String entrada =   "2 3\n" +
        "10 1 1 1\n" +
        "2 1 8 2 1 1";

    final ByteArrayInputStream input
        = new ByteArrayInputStream(entrada.getBytes());
    System.setIn(input);
    LocalDateTime antes = LocalDateTime.now();
    Houston511.main(args);
    LocalDateTime despues = LocalDateTime.now();
    System.out.println();
    System.out.println(Duration.between(antes,despues).toMillis());
  }

}

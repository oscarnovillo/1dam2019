package main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class FileReadExample {


  public Logger logger = Logger.getLogger("main.FileExample");

  public static void main(String[] args) {



    try  (BufferedReader br = Files.newBufferedReader(Paths.get("./testing.txt"));
          BufferedInputStream os = new BufferedInputStream(Files.newInputStream(Paths.get("./testingBytes.dat")));
          )
    {
      String linea  = null;
      do
      {
        linea =  br.readLine();
        if (linea != null)
          System.out.println(linea);
      } while (linea != null);

      System.out.println("con Files");
      Files.readAllLines(Paths.get("./testing.txt")).forEach(System.out::println);




      byte[]b = new byte[100];
      int number = os.read(b);
      number = 0;

    } catch (IOException e) {
      FileReadExample f = new FileReadExample();
      f.logger.log(Level.SEVERE,e.getMessage(),e);
    }
    System.out.println("fin");

  }
}

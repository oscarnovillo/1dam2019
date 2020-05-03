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


  public static Logger logger = Logger.getLogger("main.FileExample");

  public static void main(String[] args) {


    try  (BufferedReader bw = Files.newBufferedReader(Paths.get("./testing.txt"));
          BufferedInputStream os = new BufferedInputStream(Files.newInputStream(Paths.get("./testingBytes.dat")));
          Stream<Path> stream = Files.list(Paths.get("./")))
    {
      stream.forEach(path -> System.out.println(path.toAbsolutePath().toString()+" "+Files.isDirectory(path)));
      String linea  = null;

      while ((linea =  bw.readLine()) != null)
      {
        System.out.print(linea);
      }

      byte[]b = new byte[100];
      int number = os.read(b);
      number = 0;


    } catch (IOException e) {
      logger.log(Level.SEVERE,e.getMessage(),e);
    }

  }
}

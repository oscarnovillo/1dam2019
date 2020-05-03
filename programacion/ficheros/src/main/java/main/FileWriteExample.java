package main;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class FileWriteExample {


  public static Logger logger = Logger.getLogger("main.FileExample");

  public static void main(String[] args) {


    try  (BufferedWriter bw = Files.newBufferedWriter(Paths.get("./testing.txt"), StandardOpenOption.APPEND,StandardOpenOption.CREATE);
          BufferedOutputStream os = new BufferedOutputStream(Files.newOutputStream(Paths.get("./testingBytes.dat")));
          Stream<Path> stream = Files.list(Paths.get("./")))
    {
      stream.forEach(path -> System.out.println(path.toAbsolutePath().toString()+" "+Files.isDirectory(path)));
        bw.write("hola\n");
        os.write("hola\n".getBytes());
        os.write(new byte[]{2,3,4,5,6,8});

    } catch (IOException e) {
      logger.log(Level.SEVERE,e.getMessage(),e);
    }

  }
}

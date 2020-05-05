package main;

import java.io.*;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class FileWriteExample {


  public static Logger logger = Logger.getLogger("main.FileExample");

  public static void main(String[] args) {


    try  (BufferedWriter bw =
              Files.newBufferedWriter(Paths.get("./testing.txt"),
                  StandardOpenOption.APPEND);
          BufferedOutputStream os = new BufferedOutputStream(Files.newOutputStream(Paths.get("./testingBytes.dat")));
          )
    {
        PrintWriter pw = new PrintWriter(bw);
        pw.println("adios");
        pw.printf("%3.2f el numero ",16.5788);

        //bw.write("adios\nla");


        os.write("hola\n".getBytes());
        os.write(new byte[]{2,3,4,5,6,8});

    } catch (IOException e) {
      logger.log(Level.SEVERE,e.getMessage(),e);
    }

  }
}

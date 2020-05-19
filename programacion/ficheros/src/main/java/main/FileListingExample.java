package main;


import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;


public class FileListingExample  {

  public static Logger logger = Logger.getLogger("main.FileListingExample");

  public static void main(String[] args) {

    try  (Stream<Path> stream = Files.list(Paths.get(".")))
    {
      stream.forEach(path -> {
        System.out.println(path.getFileName().toString());
        if (Files.isDirectory(path))
        {
          try {
            Files.list(Paths.get(".")).forEach(path1 -> System.out.println(path1));
          } catch (IOException e) {
            logger.log(Level.SEVERE,e.getMessage(),e);
          }

        }

      } );
    } catch (IOException e) {
      logger.log(Level.SEVERE,e.getMessage(),e);
    }

  }


}

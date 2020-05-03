package main;


import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class FileListingExample {

  public static Logger logger = Logger.getLogger("main.FileListingExample");

  public static void main(String[] args) {
    try  (Stream<Path> stream = Files.list(Paths.get("./")))
    {
      stream.forEach(path -> System.out.println(path.toAbsolutePath().toString()+" "+Files.isDirectory(path)));
    } catch (IOException e) {
      logger.log(Level.SEVERE,e.getMessage(),e);
    }
  }
}

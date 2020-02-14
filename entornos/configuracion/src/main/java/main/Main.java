package main;

import config.singleton.ConfigSingleton;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Main {



  public static void main(String[] args) {

    Properties prop = new Properties();
    try {
      prop.load(new FileReader("config/config.properties"));
      String clave = (String)prop.get("clave");
      int numero = Integer.parseInt((String)prop.get("manzanas"));
      System.out.println(clave + " "+numero);
      prop.load(new FileReader("kk.properties"));

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }



    ConfigSingleton.getInstance().getConfig().getAlumnos().forEach(System.out::println);


    System.out.println(ConfigSingleton.getInstance().getClave()+ " "
     +ConfigSingleton.getInstance().getConfig().getManzanas());

    ConfigSingleton.getInstance().getClave();
  }
}

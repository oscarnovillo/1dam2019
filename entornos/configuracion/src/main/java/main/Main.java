package main;

import config.singleton.ConfigSingleton;

public class Main {

  public static void main(String[] args) {
    ConfigSingleton.getInstance().getAlumnos().forEach(System.out::println);
  }
}

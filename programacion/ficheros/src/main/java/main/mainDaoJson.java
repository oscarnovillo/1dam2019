package main;

import dao.DaoArmario;
import dao.modelo.Armario;
import dao.modelo.Cajonera;
import dao.modelo.Ropa;

import java.util.ArrayList;
import java.util.List;

public class mainDaoJson {

  public static void main(String[] args) {
    List<Ropa> prendas = new ArrayList<>();
    prendas.add(new Ropa("M","pantalones"));
    prendas.add(new Ropa("M","polo de pijo"));

    Armario armario = new Armario("habitacion 1",200,prendas,new Cajonera(3,50,50));
    DaoArmario dao = new DaoArmario();
    dao.nuevoArmario(armario);
    dao.nuevoArmario(armario);

    armario.setUbicacion("ZZZZZZZZZZZZZZZZZZZZZ");
    dao.editarArmario(armario);

    armario.setId(14);
    dao.borrarArmario(armario);

    Armario a = dao.getArmario(14);
    System.out.println(a);








  }
}

import config.Config;
import dao.DaoArmario;
import dao.modelo.Armario;
import dao.modelo.Cajonera;
import dao.modelo.Ropa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DaoArmarioTest {

  @BeforeAll
  static void copiarBackUp() throws IOException {
    Config.getInstance().setRutaFicheros("./ficherosPruebas/");
    Files.copy(Paths.get("./ficherosPruebas/armarios.json.bak"), Paths.get("./ficherosPruebas/armarios.json"),
        StandardCopyOption.REPLACE_EXISTING);
  }

  @Test
  public void testCargaArmarios()
  {

    DaoArmario dao = new DaoArmario();
    assertEquals(dao.getTodosArmarios().size(),1);


  }

  @Test
  public void testAddArmarios()
  {
    //Given
    List<Ropa> prendas = new ArrayList<>();
    prendas.add(new Ropa("M","pantalones"));
    prendas.add(new Ropa("M","polo de pijo"));

    Armario armario = new Armario("habitacion 1",200,prendas,new Cajonera(3,50,50));
    DaoArmario dao = new DaoArmario();

    //when
    dao.nuevoArmario(armario);


    //then
    assertEquals(dao.getTodosArmarios().size(),2);


  }

  @Test
  @DisplayName("edita el nombre deu narmario")
  public void testEditarArmarios()
  {
    //given
    DaoArmario dao = new DaoArmario();
    Armario a = dao.getArmario(1);
    a.setUbicacion("ZZZZZZ");

    //when
    dao.editarArmario(a);

    //then
    assertEquals(dao.getArmario(1).getUbicacion(),"ZZZZZZ");


  }

}

package servicios;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiciosTestTest {

  private static ServiciosTest st;

  @BeforeAll
  static void setup()
  {
    st = new ServiciosTest();
  }



  @Test
  void dameNumero() {
    assertTrue(true);

  }

  @Test
  @DisplayName("probando nombre")
  void dameNombre() {

    st.dameNombre(1);

    assertTrue(true);




  }
}
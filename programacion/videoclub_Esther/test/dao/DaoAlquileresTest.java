package dao;

import dao.modelo.Alquiler;
import dao.modelo.Producto;
import dao.modelo.Socio;
import dao.modelo.Videojuego;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DaoAlquileresTest {

  static DaoAlquileres dao;
  Alquiler alquiler;

  @BeforeAll
  static void setupAll()
  {
    dao = new DaoAlquileres();

  }

  @BeforeEach
  void setUp() {
    Socio s = new Socio("koko","asd","asd","aasd",12);
    Producto p = new Videojuego("as",12,"asd","asd");
    alquiler =  new Alquiler(LocalDateTime.of(2000,1,1,1,1),s,p);

  }

  @AfterEach
  void tearDown() {
 //   dao.borrarAlquiler(alquiler);
  }

  @Test
  @Order(1)
  @DisplayName("probar que se añade al alquiler")
  void addAlquiler() {
    //Given
    //when
    boolean resultado = dao.addAlquiler(alquiler);

    //Then
    assertTrue(resultado);
  }

  @Test
  @Order(2)
  void addAlquilerDeSocioExiste() {
    //Given


    //when
    boolean resultado = dao.addAlquiler(alquiler);

    //Then
    assertFalse(resultado);

  }

  @Test
  @Order(3)
  void addAlquilerComprobarExiste() {
    //Given


    //when
    Alquiler a = dao.alquilerSocio("koko");

    //Then
    assertEquals(alquiler,a);
  }



  @Test
  void borrarAlquiler() {


  }

  @Test
  void alquilerSocio() {
  }


}
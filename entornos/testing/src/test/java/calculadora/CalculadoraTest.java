package calculadora;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

  @Test
  void probarSuma() {
    //Given
    Calculadora c = new Calculadora();
Random r = new Random();
int num1 = r.nextInt(100)+1;
int num2 = r.nextInt(100)+1;

    //when
    int resultado = c.suma(-1*num1, num2);

    //then
    assertEquals(num1+num2+1, resultado);

  }

//  @Test
//  void probarSumaNegativos() {
//    //Given
//    Calculadora c = new Calculadora();
//
//    //when
//    int resultado = c.suma(-1, 1);
//    int resultado2 = c.suma(1, -1);
//
//    //then
//    assertEquals(-1, resultado);
//    assertEquals(-1, resultado2);
//
//  }

  @Test
  void probarResta() {
    //Given
    Calculadora c = new Calculadora();

    //when
    int resultado = c.resta(-1, -2);

    //then
    assertEquals(1, resultado);

  }


}

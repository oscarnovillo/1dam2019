package servicios;

import dao.DaoSocios;
import dao.modelo.Socio;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServiciosVideoclubTest {

  @Spy
  DaoSocios daoSocio;

  @InjectMocks
  ServiciosVideoclub sv = new ServiciosVideoclub();

  @BeforeAll
  void setup()
  {
    MockitoAnnotations.initMocks(this);
   // when(daoSocio.deleteSocio(new Socio("aa","","","",1))).thenReturn(true);
    when(daoSocio.getSocioPorNif("aa")).thenReturn(new Socio("aa","","","",1));
  }
  @Mock
  List<String> mockedList;

  @Test
  public void whenUseMockAnnotation_thenMockIsInjected() {
    mockedList.add("one");
    verify(mockedList).add("one");
    assertEquals(0, mockedList.size());

    when(mockedList.size()).thenReturn(100);
    assertEquals(100, mockedList.size());
  }
  @Test
  void borrarSocio() {

    boolean actualResult = sv.borrarSocio("aa");
    assertTrue(actualResult);
  }
}
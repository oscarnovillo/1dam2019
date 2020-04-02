package main;

import pedidos.dao.modelo.Producto;
import pedidos.servicios.ServiciosPedido;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

// productos de pedidos
public class StreamsProductos {

  // con reduce y con sorted
  public void productoMasCaro() {
  }

  //con reduce y con sorted
  public void productoMasBarato() {
  }


  public void mediaPrecioTodosLosProductos() {
  }


  // ****  % un grupo de producto por cada franja de 10, de 0 a 10, 11 a 20, etc...
  public void productosAgrupadosPorRangoPrecio10en10() {

    ServiciosPedido sp = new ServiciosPedido();

    Map<String, List<Producto>> m = sp.todosProductos().stream().collect(Collectors.groupingBy(producto -> {
      String solucion = "";
      int centena = producto.getPrecio() / 10;
      solucion  = centena + "_10";
      return solucion;
    } ));
    m.keySet().parallelStream().sorted().forEachOrdered(s -> {
      System.out.println(s + " "+ m.get(s).toString());
    });
  }

  // de los productos que tenga precio de 11 a 20, indicar cuales tienen stock mayor que 5
  public void productosConPrecio11a20YStockMayor5() {
  }

}

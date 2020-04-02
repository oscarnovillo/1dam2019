package main;

import pedidos.dao.modelo.LineaPedido;
import pedidos.servicios.ServiciosPedido;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class StreamsPedidos {

  // un map con nombre de producto y cantidad de veces pedido
  public void productosAgrupadosPorCantidadDeVecesPedidos(){
    ServiciosPedido sp = new ServiciosPedido();

    sp.getTodosPedidos().stream()
        .flatMap(pedidoCompuesto -> pedidoCompuesto.getPedidosSimples().stream())
        .flatMap(pedidoSimple -> pedidoSimple.getLineasPedido().stream())
        .filter(lineaPedido -> lineaPedido.getProducto().getNombre().equals("jjj"))
        .count();

    sp.getTodosPedidos().stream()
        .flatMap(pedidoCompuesto -> pedidoCompuesto.getPedidosSimples().stream())
        .flatMap(pedidoSimple -> pedidoSimple.getLineasPedido().stream())
        .map(lineaPedido -> lineaPedido.getProducto())
        .collect(Collectors.groupingBy(
            producto -> sp.getTodosPedidos().stream()
            .flatMap(pedidoCompuesto -> pedidoCompuesto.getPedidosSimples().stream())
            .flatMap(pedidoSimple -> pedidoSimple.getLineasPedido().stream())
            .filter(lineaPedido1 -> lineaPedido1.getProducto().equals(producto)).count())
            );


    Map<String,Long> mapPRoducto = sp.getTodosPedidos().stream()
        .flatMap(pedidoCompuesto -> pedidoCompuesto.getPedidosSimples().stream())
        .flatMap(pedidoSimple -> pedidoSimple.getLineasPedido().stream())
        .map(lineaPedido -> lineaPedido.getProducto())
        .collect(Collectors.groupingBy(
            producto -> producto.getNombre(),counting()
        ));

    mapPRoducto.get("jjj");






  }

  public void clienteQueMasDineroSehaGastado(){





  }


  // La cantidad media de producto por pedido simple, sumando todas las lineas de pedido de cada simple
  // devuelve solo un numero
  public void lacantidadMediaPedidaDeCadaProductoEnCadaPedidoCompuesto(){


  }


  public void pedidoSimpleConMasLineasdePedido() {}


  public void todoelDineroFacturadoEnTotalentodosLosPedidos(){}


}

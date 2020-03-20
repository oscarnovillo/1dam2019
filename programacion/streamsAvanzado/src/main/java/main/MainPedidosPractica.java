package main;

import com.github.javafaker.Faker;
import pedidos.dao.modelo.Cliente;
import pedidos.dao.modelo.Cuenta;
import pedidos.dao.modelo.Producto;
import pedidos.servicios.ServiciosPedido;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class MainPedidosPractica {

  public static void main(String[] args) {
    setupClienteClientes();
    ServiciosPedido sp = new ServiciosPedido();

    List<Cliente> clientes = sp.getTodosClientes();

    // Cliente con mas cuentas
    System.out.println(
        clientes.stream()
        .reduce((cliente, cliente2) -> cliente.getCuentas().size() >= cliente2.getCuentas().size() ? cliente : cliente2)
        .get());

    System.out.println(clientes.stream()
        .sorted(Comparator.comparing(cliente -> ((Cliente)cliente).getCuentas().size()).reversed())
        .findFirst().get());

    // Cliente + Numero de cuentas de cada cliente.
    clientes.stream().forEach(cliente -> System.out.println(cliente.getNombre()+" "+cliente.getCuentas().size()));

    // Clientes agrupados por el numero de cuentas
    System.out.println(clientes.stream().collect(Collectors.groupingBy(cliente -> cliente.getCuentas().size())));

    // Clientes que tienen mas cuentas o iguales a la media.
    final double media = clientes.stream().mapToInt(value -> value.getCuentas().size()).average().getAsDouble();


    System.out.println(media);
    System.out.println(clientes.stream()
        .filter(cliente -> cliente.getCuentas().size() >= media)
        .collect(Collectors.toList()).size());

    // media de dinero de todas las cuentas
    double mediaCuentas = clientes.stream()
        .flatMap(cliente -> cliente.getCuentas().stream())
        .mapToInt(value -> value.getSaldo())
        .average().getAsDouble();
    System.out.println(mediaCuentas);


    // Clientes ordenados por el saldo total.

    clientes.get(0).getCuentas().stream().mapToInt(value -> value.getSaldo()).sum();

    clientes.stream()
        .sorted(Comparator
            .comparingInt(cliente -> cliente.getCuentas().stream().mapToInt(value -> value.getSaldo()).sum()))
        .forEach(System.out::println);

    // Cliente con la suma del saldo de todas sus cuentas.
    clientes.stream().forEach(cliente ->
        System.out.println(cliente.getNombre()+" "+cliente.getCuentas().stream().mapToInt(value -> value.getSaldo()).sum()));

    // Clientes que tienen mas cuentas o iguales a la media.

    // Clientes que tienen todas las cuentas mayores a la media de dinero en cuenta



    // el cuarto cliente con más dinero
    clientes.stream()
        .sorted(Comparator
            .comparingInt(cliente -> cliente.getCuentas().stream().mapToInt(value -> value.getSaldo()).sum()))
        .skip(3)
        .findFirst().get();



    // numero de clientes agrupados por dominio del correo ya@gmail.com
    System.out.println(clientes.stream().collect(
        Collectors.groupingBy(cliente -> cliente.getEmail().substring(cliente.getEmail().indexOf("@")+1)
            ,counting())));

  }


  private static void setupClienteClientes() {
    Faker f = new Faker();
    ServiciosPedido sp = new ServiciosPedido();

    for (int i = 0; i < 100; i++) {
      String nombre = f.gameOfThrones().character();
      String direccion = f.gameOfThrones().city();
      String tel = f.phoneNumber().toString();
      String email = f.internet().emailAddress();
      Cliente cliente = new Cliente(nombre, direccion, tel, email);
      sp.addCliente(cliente);
      Random r = new Random();
      int numeroCuentas = r.nextInt(100);
      for (int j = 0; j < numeroCuentas; j++) {
        sp.addCuentaACliente(email, f).setSaldo(r.nextInt(100) + 100);
      }
    }
  }

  private static void setupProductos(){

  }


  private static void setPedidos(){
    ServiciosPedido sp = new ServiciosPedido();
    Random r = new Random();

    Cliente c = sp.getTodosClientes().get(r.nextInt(sp.getTodosClientes().size()));

    Producto p = sp.todosProductos().get(r.nextInt(sp.todosProductos().size()));

    Cuenta cuenta = c.getCuentas().get(r.nextInt(c.getCuentas().size()));



  }
}

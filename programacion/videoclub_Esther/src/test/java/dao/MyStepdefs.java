package dao;

import dao.modelo.Alquiler;
import dao.modelo.Producto;
import dao.modelo.Socio;
import dao.modelo.Videojuego;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStepdefs {

  private Socio socio;
  private Producto producto;
  private boolean alquilado;


  @Given("un socio")
  public void unSocio() {
    socio = new Socio("1","","","",10);
  }

  @And("un producto")
  public void unProducto() {
    producto = new Videojuego("",10,"","");

  }

  @When("el socio quiere coger prestado el producto")
  public void elSocioQuiereCogerPrestadoElProducto() {
    DaoAlquileres alquileres = new DaoAlquileres();
    alquilado = alquileres.addAlquiler(new Alquiler(LocalDateTime.now(),socio,producto));

  }

  @Then("el socio consigue el producto")
  public void elSocioConsigueElProducto() {
    assertTrue(alquilado);
  }

  @Given("un socio con algo prestado ya")
  public void unSocioConAlgoPrestadoYa() {
    socio = new Socio("2","","","",10);
    DaoAlquileres alquileres = new DaoAlquileres();
    alquilado = alquileres.addAlquiler(new Alquiler(LocalDateTime.now(),socio,producto));

  }

  @Then("el socio no consigue el producto")
  public void elSocioNoConsigueElProducto() {
    assertFalse(alquilado);
  }
}

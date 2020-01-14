/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.github.javafaker.Faker;
import dao.DaoFaker;
import dao.DaoTablero;
import dao.modelo.Celda;
import dao.modelo.EstadoCelda;

/**
 *
 * @author oscar
 */
public class ServiciosTablero {
  
  private DaoTablero daoTablero;

  public ServiciosTablero(int anchura,int altura) {
    rellenarTablero( anchura, altura);
  }

   
  private void rellenarTablero(int anchura,int altura)
  {
    DaoFaker faker = new DaoFaker((anchura*altura)/2);
    daoTablero = new DaoTablero(anchura,altura);
    
    for (int i = 0; i < altura; i++) {
      for (int j = 0; j < anchura; j++) {
        daoTablero.getTablero()[i][j] = 
                new Celda(faker.getNombres()[0]);
      }
    }
    
    // barajar las cosas.
    
  }
  
  
  
  
  
}

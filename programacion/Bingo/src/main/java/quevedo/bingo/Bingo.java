/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quevedo.bingo;

import modelo.Bola;
import modelo.Jugador;

/**
 *
 * @author oscar
 */
public class Bingo {
  
  private static double precioCarton = 5;
  private static double porcentajePremioLinea = 15;
  private static double porcentajePremioBingo = 45;
  
          
  public static void main(String[] args) {
    
    int bombo[] = new int [90];
    
    // crear bolas bingo
    
    // pedir numero jugadores
    
    Jugador jugadores[] = new Jugador[8] ;
    
    // por cada jugador dinero inicial, nomrbe
    jugadores[0].setNombre("Juan");
    
      
    // do partida
     
    // por cada jugador preguntar si quiere carton 
    
    // restar dinero, comprobar si puede comprarlo.
    
    // generar carton
      // 3 filas
        // 5 columnas
          // numero de columna aleatorio
          // miro si en esa columna hay numero
          //jugadores[0].getCarton()[fila][columna] != null
          
          // si lo hay elijo otro, en while

          // una vez que tengo columna elijo un numero del columna*10 al +9
          jugadores[0].getCarton()[0][0] = new Bola(47);
          
          // comprobar que ese numero no ha salido en la columna
          // sino volver a elegir.
                  
          
    
    // muevo el bombo del bingo
    
    // por cada bola sacada 
      
      // por cada jugador si tiene esa bola
      for ( int i=0; i<10;i++)
        for (int j=0; j<9; j++)
        {
          if ( jugadores[i].getCarton()[0][j] != null)
            jugadores[i].getCarton()[0][j].setMarcado(true);
        }
      // mirar por cada jugador si tiene linea o bingo
      
      // mirar si acaba la partida, si hay bingo
    
    // si hay bingo sacar el estado de las cuentas de los jugadores  

    // quieres mas partidas
    //while next partida
    
    // sacar las P&L 
    System.out.println(jugadores[0].getDineroInicial() 
            - jugadores[0].getDinero());
    
  }
  
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author ANTHONY
 */
public class Tablero {

    private List<Casilla> casillas;
    private List<JugadorDto> jugadores;
    private List<Tarjeta> tajetas;

    public Tablero(JugadorDto player1, JugadorDto player2) {
        jugadores = new ArrayList<>();
        casillas = new ArrayList<>();
        tajetas = new ArrayList<>();
        
        jugadores.add(player1);
        jugadores.add(player2);
        
        casillas.add(new Casilla("Go", "Go", 8, 8));
        casillas.add(new Casilla("?", "Suerte", 7, 8));
        casillas.add(new Casilla("Agua", "Propiedad", 6, 8));
        casillas.add(new Casilla("?", "Suerte", 5, 8));
        casillas.add(new Casilla("Avenida Lopez", "Propiedad", 4, 8));
        casillas.add(new Casilla("Tren 1", "Propiedad", 3, 8));
        casillas.add(new Casilla("Avenida Toros", "Propiedad", 2, 8));
        casillas.add(new Casilla("Avenida Camaano", "Propiedad", 1, 8));
        casillas.add(new Casilla("Carcel", "Carcel", 0, 8));
        casillas.add(new Casilla("Impuesto", "Impuesto", 0, 7));
        casillas.add(new Casilla("?", "Suerte", 0, 6));
        casillas.add(new Casilla("Tren 2", "Propiedad", 0, 5));
        casillas.add(new Casilla("Zona Franca", "Propiedad", 0, 4));
        casillas.add(new Casilla("?", "Suerte", 0, 3));
        casillas.add(new Casilla("Finca Miramar", "Propiedad", 0, 2));
        casillas.add(new Casilla("Mirador", "Propiedad", 0, 1));
        casillas.add(new Casilla("Parking Free", "Parking Free", 0, 0));
        casillas.add(new Casilla("Avenida Perez", "Propiedad", 1, 0));
        casillas.add(new Casilla("Luz", "Propiedad", 2, 0));
        casillas.add(new Casilla("Avenida Central", "Propiedad", 3, 0));
        casillas.add(new Casilla("Heredia Media Calle", "Propiedad", 4, 0));
        casillas.add(new Casilla("?", "Suerte", 5, 0));
        casillas.add(new Casilla("Tren 3", "Propiedad", 6, 0));
        casillas.add(new Casilla("Impuesto", "Impuesto", 7, 0));
        casillas.add(new Casilla("Ve a la Carcel", "Ve a la Carcel", 8, 0));
        casillas.add(new Casilla("Lagunilla Escuela", "Propiedad", 8, 1));
        casillas.add(new Casilla("Calle Los Perdidos", "Propiedad", 8, 2));
        casillas.add(new Casilla("?", "Suerte", 8, 3));
        casillas.add(new Casilla("Calle Soledad", "Propiedad", 8, 4));
        casillas.add(new Casilla("?", "Suerte", 8, 5));
        casillas.add(new Casilla("Tren 4", "Propiedad", 8, 6));
        casillas.add(new Casilla("?", "Suerte", 8, 7));

        tajetas.add(new Tarjeta("Ve a la carcel", "Ve a la carcel"));
        tajetas.add(new Tarjeta("Ve a la casilla Go", "Ve a la casilla Go"));
        tajetas.add(new Tarjeta("Cobras $600", "Recibes una herencia de un familiar el cual no sabías que existía Cobras $600"));
        tajetas.add(new Tarjeta("Pagas $200", "Te han puesto una multa por no recoger lo que deja tu perro en el parque Pagas $200"));
        tajetas.add(new Tarjeta("Retrocedes dos lugares", "Rompes la interfaz grafica de Ubuntu Retrocedes dos lugares"));
        tajetas.add(new Tarjeta("Cobras $400", "Inventas un nuevo código que hace que Win funcione 0.01% más rápido Cobras $400"));
        tajetas.add(new Tarjeta("Pagas $500", "No aguantas más el estrés de programar, dejas todo y te vas ed un crucero 15 días por el caribe Pagas $500"));
//        tajetas.add(new Tarjeta("", ""));
//        tajetas.add(new Tarjeta("", ""));
//        tajetas.add(new Tarjeta("", ""));
//        tajetas.add(new Tarjeta("", ""));
//        tajetas.add(new Tarjeta("", ""));
//        tajetas.add(new Tarjeta("", ""));
//        tajetas.add(new Tarjeta("", ""));
//        tajetas.add(new Tarjeta("", ""));
//        tajetas.add(new Tarjeta("", ""));
    }

    public Tablero(Tablero tableroDto) {
    }

    public List<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(List<Casilla> casillas) {
        this.casillas = casillas;
    }

    public List<JugadorDto> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDto> jugadores) {
        this.jugadores = jugadores;
    }
    
    public List<Tarjeta> getTajetas() {
        return tajetas;
    }

    public void setTajetas(List<Tarjeta> tajetas) {
        this.tajetas = tajetas;
    }

    public void moverJugador(JugadorDto jugador, int x, int y) {
        jugador.mover(x, y);
    }
}

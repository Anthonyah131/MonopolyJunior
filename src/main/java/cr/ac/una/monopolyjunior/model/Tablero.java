/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANTHONY
 */
public class Tablero {

    private List<Casilla> casillas;
    private List<Propiedad> propiedades;
    private List<JugadorDto> jugadores;
    private List<Tarjeta> tarjetas;
    public Boolean player1Debe = false;
    public Boolean player2Debe = false;

    public Tablero(JugadorDto player1, JugadorDto player2) {
        casillas = new ArrayList<>();
        propiedades = new ArrayList<>();
        jugadores = new ArrayList<>();
        tarjetas = new ArrayList<>();

        jugadores.add(player1);
        jugadores.add(player2);

        casillas.add(new Casilla("Go", "Go", 8, 8));
        casillas.add(new Casilla("?", "Suerte", 7, 8));
        casillas.add(new Casilla("Agua", "Servicio Publico", 6, 8));
        casillas.add(new Casilla("?", "Suerte", 5, 8));
        casillas.add(new Casilla("Avenida Lopez", "Solar", 4, 8));
        casillas.add(new Casilla("Tren 1", "Estacion", 3, 8));
        casillas.add(new Casilla("Avenida Toros", "Solar", 2, 8));
        casillas.add(new Casilla("Avenida Camaano", "Solar", 1, 8));
        casillas.add(new Casilla("Carcel", "Carcel", 0, 8));
        casillas.add(new Casilla("Impuesto", "Impuesto190", 0, 7));
        casillas.add(new Casilla("?", "Suerte", 0, 6));
        casillas.add(new Casilla("Tren 2", "Estacion", 0, 5));
        casillas.add(new Casilla("Zona Franca", "Solar", 0, 4));
        casillas.add(new Casilla("?", "Suerte", 0, 3));
        casillas.add(new Casilla("Finca Miramar", "Solar", 0, 2));
        casillas.add(new Casilla("Mirador", "Solar", 0, 1));
        casillas.add(new Casilla("Parking Free", "Parking Free", 0, 0));
        casillas.add(new Casilla("Avenida Perez", "Solar", 1, 0));
        casillas.add(new Casilla("Luz", "Servicio Publico", 2, 0));
        casillas.add(new Casilla("Avenida Central", "Solar", 3, 0));
        casillas.add(new Casilla("Heredia Media Calle", "Solar", 4, 0));
        casillas.add(new Casilla("?", "Suerte", 5, 0));
        casillas.add(new Casilla("Tren 3", "Estacion", 6, 0));
        casillas.add(new Casilla("Impuesto", "Impuesto160", 7, 0));
        casillas.add(new Casilla("Ve a la Carcel", "Ve a la Carcel", 8, 0));
        casillas.add(new Casilla("Lagunilla Escuela", "Solar", 8, 1));
        casillas.add(new Casilla("Calle Los Perdidos", "Solar", 8, 2));
        casillas.add(new Casilla("?", "Suerte", 8, 3));
        casillas.add(new Casilla("Calle Soledad", "Solar", 8, 4));
        casillas.add(new Casilla("?", "Suerte", 8, 5));
        casillas.add(new Casilla("Tren 4", "Estacion", 8, 6));
        casillas.add(new Casilla("?", "Suerte", 8, 7));

        propiedades.add(new ServicioPublico("Agua", 230, 0, 300));
        propiedades.add(new Solar("Avenida Lopez", 230, 60, 0, 0, 0, 0, 0, 140, "Azul"));
        propiedades.add(new Estacion("Tren 1", 200, 100, 205, 315, 450, 250));
        propiedades.add(new Solar("Avenida Toros", 100, 25, 0, 0, 0, 0, 0, 60, "Azul"));
        propiedades.add(new Solar("Avenida Camaano", 540, 135, 0, 0, 0, 0, 0, 310, "Azul"));
        propiedades.add(new Estacion("Tren 2", 200, 100, 205, 315, 450, 250));
        propiedades.add(new Solar("Zona Franca", 285, 70, 0, 0, 0, 0, 0, 160, "Amarillo"));
        propiedades.add(new Solar("Finca Miramar", 300, 80, 0, 0, 0, 0, 0, 175, "Amarillo"));
        propiedades.add(new Solar("Mirador", 300, 80, 0, 0, 0, 0, 0, 175, "Amarillo"));
        propiedades.add(new Solar("Avenida Perez", 200, 50, 0, 0, 0, 0, 0, 120, "Rojo"));
        propiedades.add(new ServicioPublico("Luz", 225, 0, 130));
        propiedades.add(new Solar("Avenida Central", 250, 60, 0, 0, 0, 0, 0, 150, "Rojo"));
        propiedades.add(new Solar("Heredia Media Calle", 450, 110, 0, 0, 0, 0, 0, 260, "Rojo"));
        propiedades.add(new Estacion("Tren 3", 200, 100, 205, 315, 450, 250));
        propiedades.add(new Solar("Lagunilla Escuela", 400, 100, 0, 0, 0, 0, 0, 230, "Verde"));
        propiedades.add(new Solar("Calle Los Perdidos", 230, 60, 0, 0, 0, 0, 0, 130, "Verde"));
        propiedades.add(new Solar("Calle Soledad", 280, 70, 0, 0, 0, 0, 0, 160, "Verde"));
        propiedades.add(new Estacion("Tren 4", 200, 100, 205, 315, 450, 250));

        tarjetas.add(new Tarjeta("Ve a la carcel", "Ve a la carcel"));
        tarjetas.add(new Tarjeta("Ve a la casilla Go", "Ve a la casilla Go"));
        tarjetas.add(new Tarjeta("Cobras $600", "Recibes una herencia de un familiar el cual no sabías que existía Cobras $600"));
        tarjetas.add(new Tarjeta("Pagas $200", "Te han puesto una multa por no recoger lo que deja tu perro en el parque Pagas $200"));
        tarjetas.add(new Tarjeta("Retrocedes dos lugares", "Rompes la interfaz grafica de Ubuntu Retrocedes dos lugares"));
        tarjetas.add(new Tarjeta("Cobras $400", "Inventas un nuevo código que hace que Win funcione 0.01% más rápido Cobras $400"));
        tarjetas.add(new Tarjeta("Pagas $500", "No aguantas más el estrés de programar, dejas todo y te vas ed un crucero 15 días por el caribe Pagas $500"));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
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

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public void moverJugador(JugadorDto jugador, int x, int y) {
        jugador.mover(x, y);
    }

    public Casilla getCasillaActual(JugadorDto jugador) {
        return casillas.stream()
                .filter(c -> c.getPosX() == jugador.getPosicionX() && c.getPosY() == jugador.getPosicionY())
                .findFirst()
                .orElse(null);
    }

    public Propiedad getPropiedad(String nombre) {
        return propiedades.stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public Tarjeta getTarjeta() {
        Tarjeta primerTarjeta = tarjetas.get(0);
        tarjetas.remove(0);
        tarjetas.add(primerTarjeta);

        return primerTarjeta;
    }
    
    public Tarjeta getUltimaTarjeta() {
        Tarjeta ultimaTarjeta = tarjetas.get(tarjetas.size() - 1);

        return ultimaTarjeta;
    }
}

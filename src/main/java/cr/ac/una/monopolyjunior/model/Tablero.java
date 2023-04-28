/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ANTHONY
 */
public class Tablero {
    private ObservableList<Casilla> casillas;
    private ObservableList<JugadorDto> jugadores;
    private ObservableList<Tarjeta> tajetas;

    public Tablero() {
        casillas = FXCollections.observableArrayList();
        jugadores = FXCollections.observableArrayList();
        tajetas = FXCollections.observableArrayList();
    }

    public Tablero(Tablero tableroDto) {
        this();
    }

    public ObservableList<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(ObservableList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public ObservableList<JugadorDto> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ObservableList<JugadorDto> jugadores) {
        this.jugadores = jugadores;
    }

    // Métodos
    /*public void moverJugador(JugadorDto jugador, int cantidad) {
        int posicionActual = jugador.getPosicion();
        int nuevaPosicion = (posicionActual + cantidad) % this.casillas.size();
        jugador.setPosicion(nuevaPosicion);
        Casilla casillaActual = this.casillas.get(nuevaPosicion);
        casillaActual.efecto(jugador);
    }

    public void imprimirTablero() {
        for (int i = 0; i < this.casillas.size(); i++) {
            System.out.print("[");
            Casilla casilla = this.casillas.get(i);
            if (casilla instanceof Propiedad) {
                Jugador propietario = ((Propiedad) casilla).getPropietario();
                if (propietario == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(propietario.getNombre().charAt(0));
                }
            } else if (casilla instanceof CasillaInicio) {
                System.out.print("I");
            } else {
                System.out.print(" ");
            }
            System.out.print("]");
        }
        System.out.println();
    }*/

}

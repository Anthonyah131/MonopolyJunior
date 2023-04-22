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
public class TableroDto {
    public SimpleStringProperty id;
    private ObservableList<CasillaDto> casillas;
    private ObservableList<JugadorDto> jugadores;
    private ObservableList<TarjetaDto> tajetas;

    public TableroDto() {
        this.id = new SimpleStringProperty();
        casillas = FXCollections.observableArrayList();
        jugadores = FXCollections.observableArrayList();
        tajetas = FXCollections.observableArrayList();
    }

    public TableroDto(TableroDto tableroDto) {
        this();
        this.id.set(tableroDto.getId().toString());
    }
    
    public Long getId() {
        if(id.get()!=null && !id.get().isEmpty())
            return Long.valueOf(id.get());
        else
            return null;
    }

    public void setId(Long id) {
        this.id.set(id.toString());
    }

    public ObservableList<CasillaDto> getCasillas() {
        return casillas;
    }

    public void setCasillas(ObservableList<CasillaDto> casillas) {
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
        CasillaDto casillaActual = this.casillas.get(nuevaPosicion);
        casillaActual.efecto(jugador);
    }

    public void imprimirTablero() {
        for (int i = 0; i < this.casillas.size(); i++) {
            System.out.print("[");
            CasillaDto casilla = this.casillas.get(i);
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

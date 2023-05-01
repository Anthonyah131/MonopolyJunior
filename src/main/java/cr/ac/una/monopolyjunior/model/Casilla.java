/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import cr.ac.una.monopolyjunior.controller.OpcionJugadorViewController;
import cr.ac.una.monopolyjunior.util.FlowController;
import javafx.stage.Stage;

/**
 *
 * @author ANTHONY
 */
public class Casilla {

    private String nombre;
    private String tipo;
    private int posX;
    private int posY;

    public Casilla(String nombre, String tipo, int posX, int posY) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.posX = posX;
        this.posY = posY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void accion(JugadorDto jugador, Banca banca, Tablero tablero, Stage stageJuegoView) {
        switch (this.tipo) {
            case "Go":
                break;
            case "Solar":
                Propiedad propiedad = tablero.getPropiedad(this.nombre);
                if (propiedad.getPropietario() == null) {
                    // El jugador puede comprar la propiedad
//                    if (jugador.getDinero() >= propiedad.getPrecio()) {
//                        jugador.comprar(propiedad, banca);
//                    }
                    OpcionJugadorViewController opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                    opcionJugadorViewController.comprarPropiedadInterfaz(jugador, propiedad);
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                } else if (!propiedad.getPropietario().getNombre().equals(jugador.getNombre())) {
                    System.out.println("Debe pagar alquiler a " + propiedad.getPropietario().getNombre());
                    // El jugador tiene que pagar renta al propietario
//                    int renta = propiedad.getRenta();
//                    jugador.pagar(renta, propiedad.getPropietario(), banca);
                }
                break;
            case "Servicio Publico":
                break;
            case "Estacion":
                break;
            case "Impuesto":
                break;
            case "Parking Free":
                break;
            case "Ve a la Carcel":
                break;
            case "Carcel":
                break;
            case "Suerte":
//                TarjetaDto tarjetaSuerte = tablero.getTarjetaSuerte();
//                tarjetaSuerte.aplicarEfecto(jugador, banca, tablero);
                break;
        }
    }
}

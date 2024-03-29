/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import cr.ac.una.monopolyjunior.controller.JuegoViewController;
import cr.ac.una.monopolyjunior.controller.OpcionJugadorViewController;
import cr.ac.una.monopolyjunior.util.FlowController;
import cr.ac.una.tarea.util.Mensaje;
import javafx.scene.control.Alert;
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

    public void accion(JugadorDto jugador, Banca banca, TableroDto tablero, Stage stageJuegoView, int dadoTirado) {
        PropiedadDto propiedad = null;
        OpcionJugadorViewController opcionJugadorViewController;
        switch (this.tipo) {
            case "Go":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.goInterfaz(jugador, banca, tablero, stageJuegoView);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, false);
                break;
            case "Solar":
                propiedad = tablero.getPropiedadSolar(this.nombre);
                if (!propiedad.tienePropietario()) {
                    opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                    opcionJugadorViewController.comprarPropiedadInterfaz(jugador, banca, propiedad);
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, false);
                } else if (!propiedad.getPropietario().getNombre().equals(jugador.getNombre())) {
                    System.out.println("Debe pagar alquiler a " + propiedad.getPropietario().getNombre());
                    opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                    opcionJugadorViewController.rentaSolarInterfaz(jugador, tablero, this.nombre);
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, false);
                }
                break;
            case "Servicio Publico":
                propiedad = tablero.getPropiedadServicio(this.nombre);
                if (!propiedad.tienePropietario()) {
                    opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                    opcionJugadorViewController.comprarServicioPublicoInterfaz(jugador, banca, propiedad);
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, false);
                } else if (!propiedad.getPropietario().getNombre().equals(jugador.getNombre())) {
                    System.out.println("Debe pagar alquiler a " + propiedad.getPropietario().getNombre());
                    opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                    opcionJugadorViewController.rentaServicioPublicoInterfaz(jugador, tablero, this.nombre, dadoTirado);
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, false);
                }
                break;
            case "Estacion":
                propiedad = tablero.getPropiedadEstacion(this.nombre);
                if (!propiedad.tienePropietario()) {
                    opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                    opcionJugadorViewController.comprarEstacionInterfaz(jugador, banca, propiedad);
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, false);
                } else if (!propiedad.getPropietario().getNombre().equals(jugador.getNombre())) {
                    System.out.println("Debe pagar alquiler a " + propiedad.getPropietario().getNombre());
                    opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                    opcionJugadorViewController.rentaEstacionInterfaz(jugador, tablero, nombre);
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, false);
                }
                break;
            case "Impuesto190":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.ImpuestoInterfaz(190, jugador, banca, tablero);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, false);
                break;
            case "Impuesto160":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.ImpuestoInterfaz(160, jugador, banca, tablero);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, false);
                break;
            case "Parking Free":
                break;
            case "Ve a la Carcel":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.CarcelInterfaz(jugador, tablero);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, false);

                JuegoViewController juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
                juegoViewController.moverFicha(jugador, 0, 8);
                jugador.mover(0, 8);
                break;
            case "Carcel":
                Boolean bandera = false;
                if (tablero.getJugadores().get(0).getNombre().equals(jugador.getNombre())) {
                    bandera = tablero.player1Debe;
                } else if (tablero.getJugadores().get(1).getNombre().equals(jugador.getNombre())) {
                    bandera = tablero.player2Debe;
                }
                if (bandera == true) {
                    opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                    opcionJugadorViewController.CarcelInterfaz(jugador, tablero);
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, false);
                } else {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Deuda o Multa", stageJuegoView, "Suerte que estas de paso, no pagas nada.");
                }
                break;
            case "Suerte":
                if (tablero.player1Debe || tablero.player2Debe) {
                    Tarjeta tarjetaSuerte = tablero.getUltimaTarjeta();
                    tarjetaSuerte.aplicarEfecto(jugador, banca, tablero, stageJuegoView);
                } else {
                    Tarjeta tarjetaSuerte = tablero.getTarjeta();
                    tarjetaSuerte.aplicarEfecto(jugador, banca, tablero, stageJuegoView);
                }
                break;
        }
    }
}

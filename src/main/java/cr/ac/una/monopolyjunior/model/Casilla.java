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

    public void accion(JugadorDto jugador, Banca banca, Tablero tablero, Stage stageJuegoView) {
        Propiedad propiedad = null;
        OpcionJugadorViewController opcionJugadorViewController;
        switch (this.tipo) {
            case "Go":
                break;
            case "Solar":
                propiedad = tablero.getPropiedad(this.nombre);
                if (propiedad.getPropietario() == null) {
                    opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
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
                propiedad = tablero.getPropiedad(this.nombre);
                if (propiedad.getPropietario() == null) {
                    opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                    opcionJugadorViewController.comprarServicioPublicoInterfaz(jugador, propiedad);
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                } else if (!propiedad.getPropietario().getNombre().equals(jugador.getNombre())) {
                    System.out.println("Debe pagar alquiler a " + propiedad.getPropietario().getNombre());
                    // El jugador tiene que pagar renta al propietario
//                    int renta = propiedad.getRenta();
//                    jugador.pagar(renta, propiedad.getPropietario(), banca);
                }
                break;
            case "Estacion":
                propiedad = tablero.getPropiedad(this.nombre);
                if (propiedad.getPropietario() == null) {
                    opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                    opcionJugadorViewController.comprarEstacionInterfaz(jugador, propiedad);
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                } else if (!propiedad.getPropietario().getNombre().equals(jugador.getNombre())) {
                    System.out.println("Debe pagar alquiler a " + propiedad.getPropietario().getNombre());
                    // El jugador tiene que pagar renta al propietario
//                    int renta = propiedad.getRenta();
//                    jugador.pagar(renta, propiedad.getPropietario(), banca);
                }
                break;
            case "Impuesto190":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.ImpuestoInterfaz(190, jugador, banca, tablero);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                break;
            case "Impuesto160":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.ImpuestoInterfaz(160, jugador, banca, tablero);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                break;
            case "Parking Free":
                break;
            case "Ve a la Carcel":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.CarcelInterfaz(jugador, tablero);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                
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
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                } else {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Deuda o Multa", stageJuegoView, "Deuda o Multa ya pago.");
                }
                break;
            case "Suerte":
//                TarjetaDto tarjetaSuerte = tablero.getTarjetaSuerte();
//                tarjetaSuerte.aplicarEfecto(jugador, banca, tablero);
                break;
        }
    }
}

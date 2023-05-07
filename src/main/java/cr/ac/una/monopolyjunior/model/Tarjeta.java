/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import cr.ac.una.monopolyjunior.controller.JuegoViewController;
import cr.ac.una.monopolyjunior.controller.OpcionJugadorViewController;
import cr.ac.una.monopolyjunior.util.FlowController;
import javafx.stage.Stage;

/**
 *
 * @author ANTHONY
 */
public class Tarjeta {
    private String tipo;
    private String descripcion;

    public Tarjeta(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void aplicarEfecto(JugadorDto jugador, Banca banca, Tablero tablero, Stage stageJuegoView) {
        System.out.println(this.tipo);
        OpcionJugadorViewController opcionJugadorViewController;
        JuegoViewController juegoViewController;
        switch (this.tipo) {
            case "Ve a la carcel":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.CarcelInterfaz(jugador, tablero);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                
                juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
                juegoViewController.moverFicha(jugador, 0, 8);
                jugador.mover(0, 8);
                break;
            case "Ve a la casilla Go":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.tarjetaInterfaz(jugador, banca, tablero, this, stageJuegoView);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                
                juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
                juegoViewController.moverFicha(jugador, 8, 8);
                jugador.mover(8, 8);
                juegoViewController.accionCasilla(jugador);
                break;
            case "Cobras $600":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.tarjetaInterfaz(jugador, banca, tablero, this, stageJuegoView);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                jugador.recibir(600);
                break;
            case "Cobras $400":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.tarjetaInterfaz(jugador, banca, tablero, this, stageJuegoView);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                jugador.recibir(400);
                break;
            case "Pagas $500":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.tarjetaInterfaz(jugador, banca, tablero, this, stageJuegoView);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                break;
            case "Pagas $200":
                opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.tarjetaInterfaz(jugador, banca, tablero, this, stageJuegoView);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", stageJuegoView, true);
                break;
            case "Retrocedes dos lugares":
                // ...
                break;
        }
    }
}

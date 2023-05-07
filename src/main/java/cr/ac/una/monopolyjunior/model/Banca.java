/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import cr.ac.una.tarea.util.Mensaje;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author ANTHONY
 */
public class Banca {

    public Banca() {
    }

    public void cobrarImpuesto(int monto, JugadorDto jugador) {
        jugador.pagar(monto);
    }
    
    public void pagar(int monto, JugadorDto jugador) {
        jugador.recibir(monto);
    }
}

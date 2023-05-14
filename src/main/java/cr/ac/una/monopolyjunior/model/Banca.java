/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

/**
 *
 * @author ANTHONY
 */
public class Banca {

    public Banca() {
    }

    public void cobrarConsCasa(int monto, JugadorDto jugador) {
        jugador.pagar(monto);
    }
    
    public void demolerConsCasa(int monto, JugadorDto jugador) {
        jugador.recibir(monto);
    }
    
    public void cobrarConsHotel(int monto, JugadorDto jugador) {
        jugador.pagar(monto);
    }
    
    public void demolerConsHotel(int monto, JugadorDto jugador) {
        jugador.recibir(monto);
    }
    
    public void cobrarImpuesto(int monto, JugadorDto jugador) {
        jugador.pagar(monto);
    }
    
    public void pagar(int monto, JugadorDto jugador) {
        jugador.recibir(monto);
    }
}

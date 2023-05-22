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

    public void comprarPropiedad(Propiedad propiedad, JugadorDto jugador) {
        propiedad.setPropietario(null);
        jugador.quitarPropiedad(propiedad.getNombre());
        jugador.recibir((int) (propiedad.getPrecioCompra() * 0.75));
    }
    
    public void venderPropiedad(JugadorDto jugador, Propiedad propiedad) {
        propiedad.setPropietario(jugador);
        jugador.agregarPropiedad(propiedad.getNombre());
        jugador.pagar(propiedad.getPrecioCompra());
    }
    
    public void hipotecarPropiedad(Propiedad propiedad, Tablero tablero, JugadorDto jugador) {
        propiedad.setHipotecada(true);
        jugador.recibir(propiedad.getValorHipoteca());
    }
    
    public void CobrarHipotecarPropiedad(Propiedad propiedad, Tablero tablero, JugadorDto jugador) {
        propiedad.setHipotecada(false);
        jugador.pagar((int) (propiedad.getValorHipoteca() + propiedad.getValorHipoteca() * 0.20));
    }
}

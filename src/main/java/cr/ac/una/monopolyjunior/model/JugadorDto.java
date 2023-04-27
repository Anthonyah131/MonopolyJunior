/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import java.util.ArrayList;

/**
 *
 * @author ANTHONY
 */
public class JugadorDto {
    private String nombre;
    private int saldo;
    private int posicionActual;
    private String ficha;
//    private ArrayList<Propiedad> propiedades;
//
//    public JugadorDto(String nombre, int saldo) {
//        this.nombre = nombre;
//        this.saldo = saldo;
//        this.posicionActual = 0; // El jugador empieza en la posición 0 del tablero
//        this.propiedades = new ArrayList<Propiedad>();
//    }
//
//    // Getters y setters
//    public String getNombre() {
//        return this.nombre;
//    }
//
//    public int getSaldo() {
//        return this.saldo;
//    }
//
//    public int getPosicionActual() {
//        return this.posicionActual;
//    }
//
//    public void setPosicionActual(int posicionActual) {
//        this.posicionActual = posicionActual;
//    }
//
//    public ArrayList<Propiedad> getPropiedades() {
//        return this.propiedades;
//    }
//
//    // Métodos
//    public void agregarPropiedad(Propiedad propiedad) {
//        this.propiedades.add(propiedad);
//    }
//
//    public void pagar(int cantidad) {
//        this.saldo -= cantidad;
//    }
//
//    public void recibir(int cantidad) {
//        this.saldo += cantidad;
//    }
//
//    public void mover(int cantidad) {
//        this.posicionActual += cantidad;
//        if (this.posicionActual >= Tablero.CANTIDAD_CASILLAS) {
//            // Si el jugador pasa por la casilla de salida, recibe una cantidad de dinero
//            this.posicionActual -= Tablero.CANTIDAD_CASILLAS;
//            this.recibir(Tablero.CANTIDAD_SALIDA);
//        }
//    }
}

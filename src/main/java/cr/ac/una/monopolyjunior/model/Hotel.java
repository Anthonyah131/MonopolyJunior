/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

/**
 *
 * @author ANTHONY
 */
public class Hotel {
    private int precio;
    private Casilla calle;

    public Hotel(int precio, Casilla calle) {
        this.precio = precio;
        this.calle = calle;
    }

    public int getPrecio() {
        return this.precio;
    }

    public Casilla getCalle() {
        return this.calle;
    }
}

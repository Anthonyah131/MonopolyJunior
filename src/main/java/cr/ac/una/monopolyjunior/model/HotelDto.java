/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

/**
 *
 * @author ANTHONY
 */
public class HotelDto {
    private int precio;
    private CasillaDto calle;

    public HotelDto(int precio, CasillaDto calle) {
        this.precio = precio;
        this.calle = calle;
    }

    public int getPrecio() {
        return this.precio;
    }

    public CasillaDto getCalle() {
        return this.calle;
    }
}

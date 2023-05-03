/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

/**
 *
 * @author ANTHONY
 */
public class ServicioPublico extends Propiedad {
    private static final int MULTIPLICADOR_RENTA = 10;

    public ServicioPublico(String nombre, int precioCompra, int renta, int renta1Casa, int renta2Casa, int renta3Casa, int renta4Casa, int rentaHotel, int valorHipoteca) {
        super(nombre, precioCompra, renta, renta1Casa, renta2Casa, renta3Casa, renta4Casa, rentaHotel, valorHipoteca);
    }

    public int calcularRenta(int valorDados) {
        if (tienePropietario()) {
            return valorDados * MULTIPLICADOR_RENTA;
        } else {
            return 0;
        }
    }
}

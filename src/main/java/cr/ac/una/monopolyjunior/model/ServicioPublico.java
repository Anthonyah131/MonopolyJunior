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

    public ServicioPublico(String nombre, int precioCompra, int renta, int valorHipoteca) {
        super(nombre, precioCompra, renta, valorHipoteca);
    }

    public int calcularRenta(int dado, int cantidadServicios) {
        switch (cantidadServicios) {
            case 1:
                return dado * 10;
            case 2:
                return dado * 20;
            default:
                throw new AssertionError();
        }
    }
}

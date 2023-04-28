/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

/**
 *
 * @author ANTHONY
 */
public class Estacion extends Propiedad {
    private static final int MULTIPLICADOR_RENTA = 25;

    public Estacion(String nombre, int precioCompra, int renta, int valorHipoteca) {
        super(nombre, precioCompra, renta, valorHipoteca);
    }

    public int calcularRenta(int numeroEstaciones) {
//        if (tienePropietario()) {
//            return MULTIPLICADOR_RENTA * numeroEstaciones;
//        } else {
            return 0;
//        }
    }
}

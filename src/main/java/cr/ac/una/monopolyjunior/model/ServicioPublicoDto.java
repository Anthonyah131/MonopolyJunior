/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

/**
 *
 * @author ANTHONY
 */
public class ServicioPublicoDto extends PropiedadDto {
    private static final int MULTIPLICADOR_RENTA = 10;

    public ServicioPublicoDto(String nombre, int precioCompra, int renta, int valorHipoteca) {
        super(nombre, precioCompra, renta, valorHipoteca);
    }

    public int calcularRenta(int valorDados) {
        if (tienePropietario()) {
            return valorDados * MULTIPLICADOR_RENTA;
        } else {
            return 0;
        }
    }
}

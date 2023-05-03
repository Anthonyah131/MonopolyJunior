/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

/**
 *
 * @author ANTHONY
 */
public class Propiedad {

    private String nombre;
    private int precioCompra;
    private int renta;
    private int renta1Casa;
    private int renta2Casa;
    private int renta3Casa;
    private int renta4Casa;
    private int rentaHotel;
    private int valorHipoteca;
    private JugadorDto propietario;

    public Propiedad(String nombre, int precioCompra, int renta, int renta1Casa, int renta2Casa, int renta3Casa, int renta4Casa, int rentaHotel, int valorHipoteca) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.renta = renta;
        this.valorHipoteca = valorHipoteca;
        this.propietario = null;
    }

    // Getters y setters
    public String getNombre() {
        return this.nombre;
    }

    public int getPrecioCompra() {
        return this.precioCompra;
    }

    public int getRenta() {
        return this.renta;
    }

    public int getRenta1Casa() {
        return renta1Casa;
    }

    public int getRenta2Casa() {
        return renta2Casa;
    }

    public int getRenta3Casa() {
        return renta3Casa;
    }

    public int getRenta4Casa() {
        return renta4Casa;
    }

    public int getRentaHotel() {
        return rentaHotel;
    }

    public int getValorHipoteca() {
        return valorHipoteca;
    }

    public void setValorHipoteca(int valorHipoteca) {
        this.valorHipoteca = valorHipoteca;
    }

    public JugadorDto getPropietario() {
        return this.propietario;
    }

    public void setPropietario(JugadorDto propietario) {
        this.propietario = propietario;
    }

    // Métodos
    public boolean estaHipotecada() {
        // Este método podría implementarse en una subclase Hipoteca de Propiedad
        return false;
    }

    public void cobrarRenta(JugadorDto jugador) {
//        jugador.pagar(this.renta);
//        this.propietario.recibir(this.renta);
    }
    
    public boolean tienePropietario() {
        return this.propietario != null;
    }
}

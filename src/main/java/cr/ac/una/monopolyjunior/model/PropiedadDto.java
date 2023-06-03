/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

/**
 *
 * @author ANTHONY
 */
public class PropiedadDto {

    protected Long id;
    protected String nombre;
    private int precioCompra;
    private int renta;
    protected boolean hipotecada;
    private int valorHipoteca;
    private JugadorDto propietario;

    public PropiedadDto() {
        this.id = null;
        this.nombre = "";
        this.precioCompra = 0;
        this.renta = 0;
        this.hipotecada = false;
        this.valorHipoteca = 0;
        this.propietario = null;
    }

    public PropiedadDto(String nombre, int precioCompra, int renta, int valorHipoteca) {
        this.id = null;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.renta = renta;
        this.hipotecada = false;
        this.valorHipoteca = valorHipoteca;
        this.propietario = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecioCompra() {
        return this.precioCompra;
    }

    public int getRenta() {
        return this.renta;
    }

    public boolean isHipotecada() {
        return hipotecada;
    }

    public void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
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

    public boolean tienePropietario() {
        return this.propietario != null;
    }
}

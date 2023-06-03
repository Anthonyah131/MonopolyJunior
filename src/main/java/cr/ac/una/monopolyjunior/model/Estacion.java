/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

/**
 *
 * @author ANTHONY
 */
public class Estacion extends PropiedadDto {

    private static final int MULTIPLICADOR_RENTA = 25;
    private int renta2Estaciones;
    private int renta3Estaciones;
    private int renta4Estaciones;

    public Estacion(String nombre, int precioCompra, int renta, int renta2Estaciones, int renta3Estaciones, int renta4Estaciones, int valorHipoteca) {
        super(nombre, precioCompra, renta, valorHipoteca);
        this.renta2Estaciones = renta2Estaciones;
        this.renta3Estaciones = renta3Estaciones;
        this.renta4Estaciones = renta4Estaciones;
    }
    
    public Estacion(Propiedad propiedad) {
        this.id = propiedad.getProId();
        this.nombre = propiedad.getProNombre();
        this.hipotecada = "S".equals(propiedad.getProHipotecada());
//        setPropietario(propiedad.getJugId());
    }

    public int calcularRenta(int numeroEstaciones) {
        int rentaa = 0;
        switch (numeroEstaciones) {
            case 1:
                rentaa = this.getRenta();
                break;
            case 2:
                rentaa = this.renta2Estaciones;
                break;
            case 3:
                rentaa = this.renta3Estaciones;
                break;
            case 4:
                rentaa = this.renta4Estaciones;
                break;

            default:
        }
        return rentaa;

    }

    public int getRenta2Estaciones() {
        return renta2Estaciones;
    }

    public int getRenta3Estaciones() {
        return renta3Estaciones;
    }

    public int getRenta4Estaciones() {
        return renta4Estaciones;
    }
}

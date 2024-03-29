/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import cr.ac.una.monopolyjunior.controller.JuegoViewController;
import cr.ac.una.monopolyjunior.util.FlowController;

/**
 *
 * @author ANTHONY
 */
public class Solar extends PropiedadDto {

    private String color;
    private int casas;
    private int hotel;
    private int renta1Casa;
    private int renta2Casa;
    private int renta3Casa;
    private int renta4Casa;
    private int rentaHotel;

    public Solar() {
        super("", 0, 0, 0);
        this.color = "";
        this.casas = 0;
        this.hotel = 0;
    }

    public Solar(String nombre, int precioCompra, int renta, int renta1Casa, int renta2Casa, int renta3Casa, int renta4Casa, int rentaHotel, int valorHipoteca, String color) {
        super(nombre, precioCompra, renta, valorHipoteca);
        this.color = color;
        this.casas = 0;
        this.hotel = 0;
        this.renta1Casa = renta1Casa;
        this.renta2Casa = renta2Casa;
        this.renta3Casa = renta3Casa;
        this.renta4Casa = renta4Casa;
        this.rentaHotel = rentaHotel;
    }

    public Solar(Propiedad propiedad) {
        this.id = propiedad.getProId();
        this.nombre = propiedad.getProNombre();
        this.casas = Integer.parseInt(propiedad.getProCasas().toString());
        this.hotel = Integer.parseInt(propiedad.getProHotel().toString());
        this.hipotecada = "S".equals(propiedad.getProHipotecada());
//        setPropietario(propiedad.getJugId());
    }

    public void construirCasa(Banca banca) {
        if (this.hotel == 0 && this.casas < 4 && getPropietario().getSaldo() >= 100) {
            banca.cobrarConsCasa(100, getPropietario());
            this.casas++;
            JuegoViewController juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
            juegoViewController.agregarCasaIntefaz(this);
            juegoViewController.actualizarDatosInterfaz(getPropietario());
        }
    }

    public void construirHotel(Banca banca) {
        if (this.hotel == 0 && this.casas == 4 && getPropietario().getSaldo() >= 400) {
            banca.cobrarConsHotel(400, getPropietario());
            this.hotel++;
            JuegoViewController juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
            juegoViewController.agregarHotelIntefaz(this);
            juegoViewController.actualizarDatosInterfaz(getPropietario());
        }
    }

    public void demolerCasa(Banca banca) {
        if (this.hotel == 0 && this.casas > 0) {
            banca.demolerConsCasa(95, getPropietario());
            this.casas--;
            JuegoViewController juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
            juegoViewController.demolerCasaIntefaz(this);
            juegoViewController.actualizarDatosInterfaz(getPropietario());
        }
    }

    public void demolerHotel(Banca banca) {
        if (this.hotel == 1 && this.casas == 4) {
            banca.demolerConsHotel(390, getPropietario());
            this.hotel--;
            JuegoViewController juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
            juegoViewController.demolerHotelIntefaz(this);
            juegoViewController.actualizarDatosInterfaz(getPropietario());
        }
    }

    public int calcularRenta() {
        if (this.hotel == 1) {
            return this.rentaHotel;
        } else {
            switch (casas) {
                case 0:
                    return this.getRenta();
                case 1:
                    return this.renta1Casa;
                case 2:
                    return this.renta2Casa;
                case 3:
                    return this.renta3Casa;
                case 4:
                    return this.renta4Casa;
                default:
                    return getRenta();
            }
        }
    }

    public String getColor() {
        return this.color;
    }

    public int getCasas() {
        return casas;
    }

    public void setCasas(int casas) {
        this.casas = casas;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
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

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

/**
 *
 * @author ANTHONY
 */
public class Solar extends Propiedad {
    private Color color;
    private ObservableList<Casa> casas;
    private Hotel hotel;

    public Solar(String nombre, int precioCompra, int renta, int valorHipoteca, Color color) {
        super(nombre, precioCompra, renta, valorHipoteca);
        this.color = color;
        this.casas = FXCollections.observableArrayList();
    }

    public Color getColor() {
        return this.color;
    }

    public void construirCasa() {
//        if (this.hotel == null && this.casas.size() < 4) {
//            Casa casa = new Casa(this.costoConstruccion, this);
//            this.casas.add(casa);
//        }
    }

    public void construirHotel() {
//        if (this.hotel == null && this.casas.size() == 4) {
//            this.hotel = new Hotel(this.costoConstruccion, this);
//            this.casas.clear();
//        }
    }

    public int calcularRenta() {
        if (tienePropietario()) {
            int renta = getRenta();
            if (this.hotel != null) {
                renta += this.hotel.getPrecio();
            } else {
                renta += this.casas.size() * 50;
            }
            return renta;
        } else {
            return 0;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANTHONY
 */
public class Banca {
    private List<Propiedad> propiedades;

    public Banca() {
        propiedades = new ArrayList<>();
        propiedades.add(new ServicioPublico("Agua", 230, 0, 300));
        propiedades.add(new Solar("Avenida Lopez", 230, 60, 140, "Azul"));
        propiedades.add(new Estacion("Tren 1", 200, 100, 250));
        propiedades.add(new Solar("Avenida Toros", 100, 25, 60, "Azul"));
        propiedades.add(new Solar("Avenida Camaano", 540, 135, 310, "Azul"));
        propiedades.add(new Estacion("Tren 2", 200, 100, 250));
        propiedades.add(new Solar("Zona Franca", 285, 70, 160, "Amarillo"));
        propiedades.add(new Solar("Finca Miramar", 300, 80, 175, "Amarillo"));
        propiedades.add(new Solar("Mirador", 300, 80, 175, "Amarillo"));
        propiedades.add(new Solar("Avenida Perez", 200, 50, 120, "Rojo"));
        propiedades.add(new ServicioPublico("Luz", 225, 0, 130));
        propiedades.add(new Solar("Avenida Central", 250, 60, 150, "Rojo"));
        propiedades.add(new Solar("Heredia Media Calle", 450, 110, 260, "Rojo"));
        propiedades.add(new Estacion("Tren 3", 200, 100, 250));
        propiedades.add(new Solar("Lagunilla Escuela", 400, 100, 230, "Verde"));
        propiedades.add(new Solar("Calle Los Perdidos", 230, 60, 130, "Verde"));
        propiedades.add(new Solar("Calle Soledad", 280, 70, 160, "Verde"));
        propiedades.add(new Estacion("Tren 4", 200, 100, 250));
    }
}

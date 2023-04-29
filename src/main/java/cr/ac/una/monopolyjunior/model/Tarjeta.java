/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

/**
 *
 * @author ANTHONY
 */
public class Tarjeta {
    private String tipo;
    private String descripcion;

    public Tarjeta(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void aplicarEfecto(JugadorDto jugador, Banca banca, Tablero tablero) {
        switch (this.tipo) {
            case "suerte":
                // ...
                break;
            case "comunidad":
                // ...
                break;
            case "Ve a la carcel":
                // ...
                break;
            case "Ve a la casilla Go":
                // ...
                break;
            case "Cobras $600":
                // ...
                break;
            case "Cobras $400":
                // ...
                break;
            case "Pagas $500":
                // ...
                break;
            case "Pagas $200":
                // ...
                break;
            case "Retrocedes dos lugares":
                // ...
                break;
        }
    }
}

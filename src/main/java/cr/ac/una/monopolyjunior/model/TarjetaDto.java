/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

/**
 *
 * @author ANTHONY
 */
public class TarjetaDto {
    private String tipo;
    private String descripcion;

    public TarjetaDto(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void aplicarEfecto(JugadorDto jugador, BancaDto banca, TableroDto tablero) {
        switch (this.tipo) {
            case "suerte":
                // Acciones a realizar cuando el jugador recibe una tarjeta de suerte
                // ...
                break;
            case "comunidad":
                // Acciones a realizar cuando el jugador recibe una tarjeta de comunidad
                // ...
                break;
        }
    }
}

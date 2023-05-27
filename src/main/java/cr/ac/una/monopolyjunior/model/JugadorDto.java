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
public class JugadorDto {
    private Long id;
    private String nombre;
    private int saldo;
    private String ficha;
    private int posicionX;
    private int posicionY;
    private List<String> propiedades;
    private Boolean modificado;

    public JugadorDto(String nombre, String ficha, int saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.ficha = ficha;
        this.posicionX = 8;
        this.posicionY = 8;
//        this.posicionX = 6;
//        this.posicionY = 0;
        this.propiedades = new ArrayList<>();
        this.modificado = false;
    }
    
    public JugadorDto(Jugador jugador) {
        this.id = jugador.getId();
        this.nombre = jugador.getNombre();
        this.saldo = Integer.parseInt(jugador.getSaldo().toString());
        this.ficha = jugador.getFicha();
        this.posicionX = Integer.parseInt(jugador.getPosicionx().toString());
        this.posicionY = Integer.parseInt(jugador.getPosiciony().toString());
        this.propiedades = new ArrayList<>();
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public List<String> getPropiedades() {
        return this.propiedades;
    }

    public Boolean getModificado() {
        return modificado;
    }

    public void setModificado(Boolean modificado) {
        this.modificado = modificado;
    }

    // Métodos
    public void agregarPropiedad(String propiedad) {
        this.propiedades.add(propiedad);
    }
    
    public void quitarPropiedad(String propiedad) {
        for(int i = 0; i < this.propiedades.size(); i++) {
            if(this.propiedades.get(i).equals(propiedad)) {
                this.propiedades.remove(i);
            }
        }
    }

    public void pagar(int cantidad) {
        this.saldo -= cantidad;
    }

    public void recibir(int cantidad) {
        this.saldo += cantidad;
    }

    public void mover(int x, int y) {
        this.posicionX = x;
        this.posicionY = y;
    }
}

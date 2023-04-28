/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import java.util.Random;

/**
 *
 * @author ANTHONY
 */
public class Dado {
    private int caras;

    public Dado(int caras) {
        this.caras = caras;
    }

    public int lanzar() {
        Random random = new Random();
        return random.nextInt(this.caras) + 1;
    }
}

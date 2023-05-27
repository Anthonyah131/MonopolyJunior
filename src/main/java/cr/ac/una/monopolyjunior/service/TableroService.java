/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.service;

import cr.ac.una.monopolyjunior.model.Jugador;
import cr.ac.una.monopolyjunior.model.JugadorDto;
import cr.ac.una.monopolyjunior.model.Tablero;
import cr.ac.una.monopolyjunior.model.TableroDto;
import cr.ac.una.monopolyjunior.util.EntityManagerHelper;
import cr.ac.una.monopolyjunior.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author ANTHONY
 */
public class TableroService {

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta guardarTablero(TableroDto tableroDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Tablero tablero;
            if (tableroDto.getId() != null && tableroDto.getId() > 0) {
                tablero = em.find(Tablero.class, tableroDto.getId());
                if (tablero == null) {
                    et.rollback();
                    return new Respuesta(false, "No se encontró el Tablero a modificar.", "guardarTablero NoResultException");
                }
                tablero.actualizarTablero(tableroDto);
//                for (EmpleadoDto emp : tableroDto.getEmpleadosEliminados()) {
//                    tablero.getEmpleados().remove(new Empleado(emp.getId()));
//                }
                if (!tableroDto.getJugadores().isEmpty()) {
                    for (JugadorDto jug : tableroDto.getJugadores()) {
                        Jugador jugador = em.find(Jugador.class, jug.getId());
                        tablero.getJugadorList().add(jugador);
                    }
                }
                tablero = em.merge(tablero);
            } else {
                tablero = new Tablero(tableroDto);
                em.persist(tablero);
            }
            et.commit();
            tableroDto = new TableroDto(tablero);
            for (Jugador jug : tablero.getJugadorList()) {
                tableroDto.getJugadores().add(new JugadorDto(jug));
            }
            return new Respuesta(true, "", "", "Tablero", tableroDto);
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(TableroService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Tablero.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el Tablero.", "guardar Tablero " + ex.getMessage());
        }
    }
}

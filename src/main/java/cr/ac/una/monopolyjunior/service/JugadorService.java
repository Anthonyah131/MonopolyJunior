/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.service;

import cr.ac.una.monopolyjunior.model.Jugador;
import cr.ac.una.monopolyjunior.model.JugadorDto;
import cr.ac.una.monopolyjunior.model.Propiedad;
import cr.ac.una.monopolyjunior.model.Solar;
import cr.ac.una.monopolyjunior.model.TableroDto;
import cr.ac.una.monopolyjunior.util.EntityManagerHelper;
import cr.ac.una.monopolyjunior.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author ANTHONY
 */
public class JugadorService {

    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta guardarJugador(JugadorDto jugadorDto, TableroDto tableroDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Jugador jugador;
            if (jugadorDto.getId() != null && jugadorDto.getId() > 0) {
                jugador = em.find(Jugador.class, jugadorDto.getId());
                if (jugador == null) {
                    et.rollback();
                    return new Respuesta(false, "No se encontró el jugador a modificar", "guardarJugador NoResultException");
                }
                jugador.actualizar(jugadorDto);
                if (!jugadorDto.getPropiedades().isEmpty()) {
                    for (Solar sol : tableroDto.getPropiedadesSolar()) {
                        if (jugadorDto.getPropiedades().stream().anyMatch(propiedad -> propiedad.equals(sol.getNombre()))) {
                            Propiedad propiedad = em.find(Propiedad.class, sol.getId());
                            jugador.getPropiedadList().add(propiedad);
                            propiedad.setJugId(jugador);
                        }
                    }
                }
                jugador = em.merge(jugador);
            } else {
                jugador = new Jugador(jugadorDto);
                em.persist(jugador);
            }
            et.commit();
            jugadorDto = new JugadorDto(jugador);
            for (Propiedad propiedad : jugador.getPropiedadList()) {
                jugadorDto.getPropiedades().add(propiedad.getProNombre());
            }
            return new Respuesta(true, "", "", "Jugador", jugadorDto);
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(JugadorService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el jugador.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el jugador", "guardarJugador " + ex.getMessage());
        }
    }
}

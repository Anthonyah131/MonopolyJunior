/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.service;

import cr.ac.una.monopolyjunior.model.Estacion;
import cr.ac.una.monopolyjunior.model.Jugador;
import cr.ac.una.monopolyjunior.model.JugadorDto;
import cr.ac.una.monopolyjunior.model.Propiedad;
import cr.ac.una.monopolyjunior.model.ServicioPublico;
import cr.ac.una.monopolyjunior.model.Solar;
import cr.ac.una.monopolyjunior.model.TableroDto;
import cr.ac.una.monopolyjunior.util.EntityManagerHelper;
import cr.ac.una.monopolyjunior.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
                    for (Estacion esta : tableroDto.getPropiedadesEstacion()) {
                        if (jugadorDto.getPropiedades().stream().anyMatch(propiedad -> propiedad.equals(esta.getNombre()))) {
                            Propiedad propiedad = em.find(Propiedad.class, esta.getId());
                            jugador.getPropiedadList().add(propiedad);
                            propiedad.setJugId(jugador);
                        }
                    }
                    for (ServicioPublico servi : tableroDto.getPropiedadesServicios()) {
                        if (jugadorDto.getPropiedades().stream().anyMatch(propiedad -> propiedad.equals(servi.getNombre()))) {
                            Propiedad propiedad = em.find(Propiedad.class, servi.getId());
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
    
    public Respuesta eliminarJugador(Long id) {
        try {
            et = em.getTransaction();
            et.begin();
            Jugador jugador;
            if (id != null && id > 0) {
                jugador = em.find(Jugador.class, id);
                if (jugador == null) {
                    et.rollback();
                    return new Respuesta(false, "No se encrontró el jugador a eliminar.", "eliminarJugador NoResultException");
                }
                em.remove(jugador);
            } else {
                et.rollback();
                return new Respuesta(false, "Debe cargar el jugador a eliminar.", "eliminarJugador NoResultException");
            }
            et.commit();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            et.rollback();
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, "No se puede eliminar el jugador porque tiene relaciones con otros registros.", "eliminarJugador " + ex.getMessage());
            }
            Logger.getLogger(JugadorService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el jugador.", ex);
            return new Respuesta(false, "Ocurrio un error al eliminar el jugador.", "eliminarJugador " + ex.getMessage());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.service;

import cr.ac.una.monopolyjunior.model.Estacion;
import cr.ac.una.monopolyjunior.model.Propiedad;
import cr.ac.una.monopolyjunior.model.Solar;
import cr.ac.una.monopolyjunior.model.Propiedad;
import cr.ac.una.monopolyjunior.model.ServicioPublico;
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
public class PropiedadService {
    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;

    public Respuesta guardarSolar(Solar solarDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Propiedad propiedad;
            if (solarDto.getId() != null && solarDto.getId() > 0) {
                propiedad = em.find(Propiedad.class, solarDto.getId());
                if (propiedad == null) {
                    et.rollback();
                    return new Respuesta(false, "No se encontró el Solar a modificar.", "guardarSolar NoResultException");
                }
                propiedad.actualizar(solarDto);
                propiedad = em.merge(propiedad);
            } else {
                propiedad = new Propiedad(solarDto);
                em.persist(propiedad);
            }
            et.commit();
            return new Respuesta(true, "", "", "Solar", new Solar(propiedad));
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(PropiedadService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Solar.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el Solar.", "guardar Solar " + ex.getMessage());
        }
    }
    public Respuesta guardarEstacion(Estacion estacionDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Propiedad propiedad;
            if (estacionDto.getId() != null && estacionDto.getId() > 0) {
                propiedad = em.find(Propiedad.class, estacionDto.getId());
                if (propiedad == null) {
                    et.rollback();
                    return new Respuesta(false, "No se encontró el Estacion a modificar.", "guardarEstacion NoResultException");
                }
                propiedad.actualizar(estacionDto);
                propiedad = em.merge(propiedad);
            } else {
                propiedad = new Propiedad(estacionDto);
                em.persist(propiedad);
            }
            et.commit();
            return new Respuesta(true, "", "", "Estacion", new Estacion(propiedad));
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(PropiedadService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Estacion.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el Estacion.", "guardar Estacion " + ex.getMessage());
        }
    }
    public Respuesta guardarServicio(ServicioPublico servicioDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Propiedad propiedad;
            if (servicioDto.getId() != null && servicioDto.getId() > 0) {
                propiedad = em.find(Propiedad.class, servicioDto.getId());
                if (propiedad == null) {
                    et.rollback();
                    return new Respuesta(false, "No se encontró el ServicioPublico a modificar.", "guardarServicioPublico NoResultException");
                }
                propiedad.actualizar(servicioDto);
                propiedad = em.merge(propiedad);
            } else {
                propiedad = new Propiedad(servicioDto);
                em.persist(propiedad);
            }
            et.commit();
            return new Respuesta(true, "", "", "ServicioPublico", new ServicioPublico(propiedad));
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(PropiedadService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el ServicioPublico.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el ServicioPublico.", "guardar ServicioPublico " + ex.getMessage());
        }
    }
    
    public Respuesta eliminarPropiedad(Long id) {
        try {
            et = em.getTransaction();
            et.begin();
            Propiedad propiedad;
            if (id != null && id > 0) {
                propiedad = em.find(Propiedad.class, id);
                if (propiedad == null) {
                    et.rollback();
                    return new Respuesta(false, "No se encrontró el propiedad a eliminar.", "eliminarPropiedad NoResultException");
                }
                em.remove(propiedad);
            } else {
                et.rollback();
                return new Respuesta(false, "Debe cargar el propiedad a eliminar.", "eliminarPropiedad NoResultException");
            }
            et.commit();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            et.rollback();
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, "No se puede eliminar el propiedad porque tiene relaciones con otros registros.", "eliminarPropiedad " + ex.getMessage());
            }
            Logger.getLogger(PropiedadService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el propiedad.", ex);
            return new Respuesta(false, "Ocurrio un error al eliminar el propiedad.", "eliminarPropiedad " + ex.getMessage());
        }
    }
}

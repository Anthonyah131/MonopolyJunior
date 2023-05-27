/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.service;

import cr.ac.una.monopolyjunior.model.Propiedad;
import cr.ac.una.monopolyjunior.model.Solar;
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
}

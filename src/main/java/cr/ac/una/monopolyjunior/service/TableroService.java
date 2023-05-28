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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
                if(tablero == null) {
                    et.rollback();
                    return new Respuesta(false, "No se encontró el Tablero a modificar.", "guardarTablero NoResultException");
                }
                tablero.actualizarTablero(tableroDto);
                if(!tableroDto.getJugadores().isEmpty()) {
                    for(JugadorDto jug : tableroDto.getJugadores()) {
                        Jugador jugador = em.find(Jugador.class, jug.getId());
                        tablero.getJugadorList().add(jugador);
                        jugador.setTabId(tablero);
                    }
                }
                tablero = em.merge(tablero);
            } else {
                tablero = new Tablero(tableroDto);
                em.persist(tablero);
            }
            et.commit();
            tableroDto = new TableroDto(tablero, tableroDto);
            return new Respuesta(true, "", "", "Tablero", tableroDto);
        } catch(Exception ex) {
            et.rollback();
            Logger.getLogger(TableroService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Tablero.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el Tablero.", "guardar Tablero " + ex.getMessage());
        }
    }
    
    public Respuesta getTableros() {
        try {
            Query query = em.createNamedQuery("Tablero.findAll",Tablero.class);
            List<Tablero> tablero = (List<Tablero>) query.getResultList();
            List<TableroDto> tableroDto = new ArrayList<>();
            for (Tablero tpl : tablero) {
                tableroDto.add(new TableroDto(tpl));
            }
            return new Respuesta(true, "", "", "Tableros", tableroDto);
        } catch (NoResultException ex) {
            return new Respuesta(false, "No existen planillas con los criterios ingresados.", "getPlanillas NoResultException");
        } catch (Exception ex) {
            Logger.getLogger(TableroService.class.getName()).log(Level.SEVERE, "Error obteniendo planillas.", ex);
            return new Respuesta(false, "Error obteniendo planillas.", "getPlanillas " + ex.getMessage());
        }
    }
}

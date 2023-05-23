/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.monopolyjunior.model;

import cr.ac.una.monopolyjunior.controller.ConstruirViewController;
import cr.ac.una.monopolyjunior.util.FlowController;
import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;

/**
 *
 * @author ANTHONY
 */
public class TableroDto {

    private List<Casilla> casillas;
    private List<Solar> propiedadesSolar;
    private List<ServicioPublico> propiedadesServicio;
    private List<Estacion> propiedadesEstacion;
    private List<JugadorDto> jugadores;
    private List<Tarjeta> tarjetas;
    public Boolean player1Debe = false;
    public Boolean player2Debe = false;

    public TableroDto(JugadorDto player1, JugadorDto player2) {
        casillas = new ArrayList<>();
        propiedadesSolar = new ArrayList<>();
        propiedadesServicio = new ArrayList<>();
        propiedadesEstacion = new ArrayList<>();
        jugadores = new ArrayList<>();
        tarjetas = new ArrayList<>();

        jugadores.add(player1);
        jugadores.add(player2);

        casillas.add(new Casilla("Go", "Go", 8, 8));
        casillas.add(new Casilla("?", "Suerte", 7, 8));
        casillas.add(new Casilla("Agua", "Servicio Publico", 6, 8));
        casillas.add(new Casilla("?", "Suerte", 5, 8));
        casillas.add(new Casilla("Avenida Lopez", "Solar", 4, 8));
        casillas.add(new Casilla("Tren 1", "Estacion", 3, 8));
        casillas.add(new Casilla("Avenida Toros", "Solar", 2, 8));
        casillas.add(new Casilla("Avenida Camaano", "Solar", 1, 8));
        casillas.add(new Casilla("Carcel", "Carcel", 0, 8));
        casillas.add(new Casilla("Impuesto", "Impuesto190", 0, 7));
        casillas.add(new Casilla("?", "Suerte", 0, 6));
        casillas.add(new Casilla("Tren 2", "Estacion", 0, 5));
        casillas.add(new Casilla("Zona Franca", "Solar", 0, 4));
        casillas.add(new Casilla("?", "Suerte", 0, 3));
        casillas.add(new Casilla("Finca Miramar", "Solar", 0, 2));
        casillas.add(new Casilla("Mirador", "Solar", 0, 1));
        casillas.add(new Casilla("Parking Free", "Parking Free", 0, 0));
        casillas.add(new Casilla("Avenida Perez", "Solar", 1, 0));
        casillas.add(new Casilla("Luz", "Servicio Publico", 2, 0));
        casillas.add(new Casilla("Avenida Central", "Solar", 3, 0));
        casillas.add(new Casilla("Heredia Media Calle", "Solar", 4, 0));
        casillas.add(new Casilla("?", "Suerte", 5, 0));
        casillas.add(new Casilla("Tren 3", "Estacion", 6, 0));
        casillas.add(new Casilla("Impuesto", "Impuesto160", 7, 0));
        casillas.add(new Casilla("Ve a la Carcel", "Ve a la Carcel", 8, 0));
        casillas.add(new Casilla("Lagunilla Escuela", "Solar", 8, 1));
        casillas.add(new Casilla("Calle Los Perdidos", "Solar", 8, 2));
        casillas.add(new Casilla("?", "Suerte", 8, 3));
        casillas.add(new Casilla("Calle Soledad", "Solar", 8, 4));
        casillas.add(new Casilla("?", "Suerte", 8, 5));
        casillas.add(new Casilla("Tren 4", "Estacion", 8, 6));
        casillas.add(new Casilla("?", "Suerte", 8, 7));

        propiedadesServicio.add(new ServicioPublico("Agua", 230, 0, 300));
        propiedadesSolar.add(new Solar("Avenida Lopez", 230, 60, 95, 115, 140, 155, 230, 140, "Azul"));
        propiedadesEstacion.add(new Estacion("Tren 1", 200, 100, 205, 315, 450, 250));
        propiedadesSolar.add(new Solar("Avenida Toros", 100, 25, 40, 50, 60, 70, 100, 60, "Azul"));
        propiedadesSolar.add(new Solar("Avenida Camaano", 540, 135, 215, 270, 325, 360, 540, 310, "Azul"));
        propiedadesEstacion.add(new Estacion("Tren 2", 200, 100, 205, 315, 450, 250));
        propiedadesSolar.add(new Solar("Zona Franca", 285, 70, 115, 140, 170, 190, 285, 160, "Amarillo"));
        propiedadesSolar.add(new Solar("Finca Miramar", 300, 80, 120, 160, 180, 200, 300, 175, "Amarillo"));
        propiedadesSolar.add(new Solar("Mirador", 300, 80, 120, 160, 180, 200, 300, 175, "Amarillo"));
        propiedadesSolar.add(new Solar("Avenida Perez", 200, 50, 80, 100, 120, 135, 200, 120, "Rojo"));
        propiedadesServicio.add(new ServicioPublico("Luz", 225, 0, 130));
        propiedadesSolar.add(new Solar("Avenida Central", 250, 60, 100, 150, 160, 170, 250, 150, "Rojo"));
        propiedadesSolar.add(new Solar("Heredia Media Calle", 450, 110, 180, 225, 270, 300, 450, 260, "Rojo"));
        propiedadesEstacion.add(new Estacion("Tren 3", 200, 100, 205, 315, 450, 250));
        propiedadesSolar.add(new Solar("Lagunilla Escuela", 400, 100, 160, 200, 240, 270, 400, 230, "Verde"));
        propiedadesSolar.add(new Solar("Calle Los Perdidos", 230, 60, 95, 115, 140, 155, 230, 130, "Verde"));
        propiedadesSolar.add(new Solar("Calle Soledad", 280, 70, 110, 140, 170, 190, 280, 160, "Verde"));
        propiedadesEstacion.add(new Estacion("Tren 4", 200, 100, 205, 315, 450, 250));

//        player1.agregarPropiedad("Avenida Lopez");
//        player1.agregarPropiedad("Avenida Toros");
//        player1.agregarPropiedad("Avenida Camaano");
//        player1.agregarPropiedad("Mirador");
//        propiedadesSolar.get(0).setPropietario(player1);
//        propiedadesSolar.get(1).setPropietario(player1);
//        propiedadesSolar.get(2).setPropietario(player1);
//        propiedadesSolar.get(5).setPropietario(player1);

//        player1.agregarPropiedad("Agua");
//        player1.agregarPropiedad("Luz");
//        propiedadesServicio.get(0).setPropietario(player1);
//        propiedadesServicio.get(1).setPropietario(player1);

//        player1.agregarPropiedad("Tren 1");
//        player1.agregarPropiedad("Tren 2");
//        player1.agregarPropiedad("Tren 3");
//        player1.agregarPropiedad("Tren 4");
//        propiedadesEstacion.get(0).setPropietario(player1);
//        propiedadesEstacion.get(1).setPropietario(player1);
//        propiedadesEstacion.get(2).setPropietario(player1);
//        propiedadesEstacion.get(3).setPropietario(player1);
        
        tarjetas.add(new Tarjeta("Cobras $600", "Recibes una herencia de un familiar el cual no sabías que existía Cobras $600"));
        tarjetas.add(new Tarjeta("Pagas $200", "Te han puesto una multa por no recoger lo que deja tu perro en el parque Pagas $200"));
        tarjetas.add(new Tarjeta("Ve a la carcel", "Ve a la carcel"));
        tarjetas.add(new Tarjeta("Ve a la casilla Go", "Ve a la casilla Go"));
        tarjetas.add(new Tarjeta("Retrocedes dos lugares", "Rompes la interfaz grafica de Ubuntu Retrocedes dos lugares"));
        tarjetas.add(new Tarjeta("Cobras $400", "Inventas un nuevo código que hace que Win funcione 0.01% más rápido Cobras $400"));
        tarjetas.add(new Tarjeta("Pagas $500", "No aguantas más el estrés de programar, dejas todo y te vas ed un crucero 15 días por el caribe Pagas $500"));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
//        tarjetas.add(new Tarjeta("", ""));
    }

    public TableroDto(TableroDto tablero) {
    }

    public List<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(List<Casilla> casillas) {
        this.casillas = casillas;
    }

    public List<JugadorDto> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorDto> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public void moverJugador(JugadorDto jugador, int x, int y) {
        jugador.mover(x, y);
    }

    public Casilla getCasillaActual(JugadorDto jugador) {
        return casillas.stream()
                .filter(c -> c.getPosX() == jugador.getPosicionX() && c.getPosY() == jugador.getPosicionY())
                .findFirst()
                .orElse(null);
    }

    public Casilla getCasilla(String nombre) {
        return casillas.stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public Solar getPropiedadSolar(String nombre) {
        return propiedadesSolar.stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public ServicioPublico getPropiedadServicio(String nombre) {
        return propiedadesServicio.stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public Estacion getPropiedadEstacion(String nombre) {
        return propiedadesEstacion.stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    public List<Solar> getPropiedadesSolar() {
        return propiedadesSolar;
    }

    public List<ServicioPublico> getPropiedadesServicios() {
        return propiedadesServicio;
    }

    public List<Estacion> getPropiedadesEstacion() {
        return propiedadesEstacion;
    }

    public void puedeConstruir(JugadorDto jugador, Stage stageJuegoView, Banca banca) {
        List<String> propi = jugador.getPropiedades();
        boolean azul = propi.stream().anyMatch(p -> p.equals("Avenida Lopez")) && propi.stream().anyMatch(p -> p.equals("Avenida Toros")) && propi.stream().anyMatch(p -> p.equals("Avenida Camaano"));
        boolean amarillo = propi.stream().anyMatch(p -> p.equals("Zona Franca")) && propi.stream().anyMatch(p -> p.equals("Finca Miramar")) && propi.stream().anyMatch(p -> p.equals("Mirador"));
        boolean rojo = propi.stream().allMatch(p -> p.equals("Avenida Perez")) && propi.stream().anyMatch(p -> p.equals("Avenida Central")) && propi.stream().anyMatch(p -> p.equals("Heredia Media Calle"));
        boolean verde = propi.stream().allMatch(p -> p.equals("Lagunilla Escuela")) && propi.stream().anyMatch(p -> p.equals("Calle Los Perdidos")) && propi.stream().anyMatch(p -> p.equals("Calle Soledad"));

        ConstruirViewController construirViewController = (ConstruirViewController) FlowController.getInstance().getController("ConstruirView");
        construirViewController.construirCasasHoteles(jugador, this, banca, azul, amarillo, rojo, verde);
        FlowController.getInstance().goViewInWindowModal("ConstruirView", stageJuegoView, true);

        System.out.println(azul + " : " + amarillo + " : " + rojo + " : " + verde);
    }

    public int cuantosServicios(JugadorDto jugador) {
        List<String> propi = jugador.getPropiedades();
        int cont = 0;
        for(String serv : propi) {
            if(getPropiedadServicio(serv) != null && getPropiedadServicio(serv).tienePropietario() && getPropiedadServicio(serv).getPropietario().getNombre().equals(jugador.getNombre())) {
                cont++;
            }
        }
        return cont;
    }
    
    public int cuantasEstaciones(JugadorDto jugador) {
        List<String> propi = jugador.getPropiedades();
        int cont = 0;
        for(String esta : propi) {
            if(getPropiedadEstacion(esta) != null && getPropiedadEstacion(esta).tienePropietario() && getPropiedadEstacion(esta).getPropietario().getNombre().equals(jugador.getNombre())) {
                cont++;
            }
        }
        return cont;
    }

    public Tarjeta getTarjeta() {
        Tarjeta primerTarjeta = tarjetas.get(0);
        tarjetas.remove(0);
        tarjetas.add(primerTarjeta);

        return primerTarjeta;
    }

    public Tarjeta getUltimaTarjeta() {
        Tarjeta ultimaTarjeta = tarjetas.get(tarjetas.size() - 1);

        return ultimaTarjeta;
    }
}

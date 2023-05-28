/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopolyjunior.model.JugadorDto;
import cr.ac.una.monopolyjunior.model.Tablero;
import cr.ac.una.monopolyjunior.model.TableroDto;
import cr.ac.una.monopolyjunior.service.TableroService;
import cr.ac.una.monopolyjunior.util.FlowController;
import cr.ac.una.monopolyjunior.util.Respuesta;
import cr.ac.una.tarea.util.Mensaje;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class CargarPartidaViewController extends Controller implements Initializable {

    @FXML
    private VBox vboxContenedor;

    private ObservableList<TableroDto> tableros = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @Override
    public void initialize() {
        cargarPartidas();
    }

    private void cargarPartidas() {
        vboxContenedor.getChildren().clear();
        TableroService service = new TableroService();
        Respuesta respuesta = service.getTableros();

        if (respuesta.getEstado()) {
            tableros.clear();
            tableros.addAll((List<TableroDto>) respuesta.getResultado("Tableros"));
            for(TableroDto tablero : tableros) {
                TableroDto tableroDto = tablero;
                Label lbNombrePartida = new Label("Partida Guardada " + tableroDto.getId());
                Label lbNombreJugadores = new Label(tableroDto.getJugadores().get(0).getNombre() + " VS " + tableroDto.getJugadores().get(1).getNombre());
                VBox vboxContenedorInfo = new VBox(lbNombrePartida, lbNombreJugadores);
                vboxContenedorInfo.setAlignment(Pos.CENTER);

                JFXButton btnCargarPartida = new JFXButton("Cargar Partida");
                btnCargarPartida.setOnAction(event -> {
                    JuegoViewController juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
                    
                    juegoViewController.cargarTablero(tableroDto);
                    FlowController.getInstance().goViewInWindow("JuegoView");
                    getStage().close();
                });
                VBox vboxContenedorBoton = new VBox(btnCargarPartida);
                vboxContenedorBoton.setAlignment(Pos.CENTER);

                HBox hboxContendorPartida = new HBox(vboxContenedorInfo, vboxContenedorBoton);
                hboxContendorPartida.setAlignment(Pos.CENTER);

                vboxContenedor.getChildren().add(hboxContendorPartida);
            }
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Cargar tablero", getStage(), respuesta.getMensaje());
        }
    }

}

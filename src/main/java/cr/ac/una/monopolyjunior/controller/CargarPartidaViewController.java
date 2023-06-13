/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopolyjunior.model.TableroDto;
import cr.ac.una.monopolyjunior.service.TableroService;
import cr.ac.una.monopolyjunior.util.FlowController;
import cr.ac.una.monopolyjunior.util.Respuesta;
import cr.ac.una.tarea.util.Mensaje;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private ScrollPane scroll;
    @FXML
    private AnchorPane rootScroll;
    @FXML
    private JFXButton btnCancelar;

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

    private void cargarPartidas() {  // Busca partidas guardadas y si la hay las carga y muestra
        vboxContenedor.getChildren().clear();
        TableroService service = new TableroService();
        Respuesta respuesta = service.getTableros();
        scroll.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
        rootScroll.getStyleClass().add("CargarPartidaView-FondoTransparente");

        if (respuesta.getEstado()) {
            tableros.clear();
            tableros.addAll((List<TableroDto>) respuesta.getResultado("Tableros"));
            for (TableroDto tablero : tableros) {
                TableroDto tableroDto = tablero;
                Label lbNombrePartida = new Label("Partida Guardada " + tableroDto.getId());
                lbNombrePartida.getStyleClass().add("CargarPartidaView-lbTitulo");
                Label lbNombreJugadores = new Label(tableroDto.getJugadores().get(0).getNombre() + " VS " + tableroDto.getJugadores().get(1).getNombre());
                lbNombreJugadores.getStyleClass().add("CargarPartidaView-lbJugadores");
                VBox vboxContenedorInfo = new VBox(lbNombrePartida, lbNombreJugadores);
                vboxContenedorInfo.setAlignment(Pos.CENTER_LEFT);
                vboxContenedorInfo.setSpacing(10);

                JFXButton btnCargarPartida = new JFXButton("Cargar Partida");
                btnCargarPartida.getStyleClass().add("carta-button");
                btnCargarPartida.setOnAction(event -> {
                    JuegoViewController juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");

                    juegoViewController.cargarTablero(tableroDto);
                    FlowController.getInstance().goViewInWindow("JuegoView");
                    getStage().close();
                });
                VBox vboxContenedorBoton = new VBox(btnCargarPartida);
                vboxContenedorBoton.setAlignment(Pos.CENTER_RIGHT);

                Separator separator = new Separator();

                HBox hboxContendorPartida = new HBox(vboxContenedorInfo, vboxContenedorBoton);
                hboxContendorPartida.setAlignment(Pos.CENTER);
                hboxContendorPartida.setSpacing(50);

                vboxContenedor.getChildren().add(hboxContendorPartida);
                vboxContenedor.getChildren().add(separator);
            }
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Cargar tablero", getStage(), respuesta.getMensaje());
        }
    }

    @FXML
    private void onActionBtnCancelar(ActionEvent event) {
        FlowController.getInstance().goMain();
        getStage().close();
    }
}

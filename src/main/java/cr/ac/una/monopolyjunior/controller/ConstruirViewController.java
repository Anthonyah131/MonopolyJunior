/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopolyjunior.model.Banca;
import cr.ac.una.monopolyjunior.model.JugadorDto;
import cr.ac.una.monopolyjunior.model.Solar;
import cr.ac.una.monopolyjunior.model.TableroDto;
import cr.ac.una.tarea.util.Mensaje;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class ConstruirViewController extends Controller implements Initializable {

    @FXML
    private TableView<Solar> tbvPropiedades;
    @FXML
    private TableColumn<Solar, String> tbcNombre;
    @FXML
    private TableColumn<Solar, String> tbcCasas;
    @FXML
    private TableColumn<Solar, String> tbcHotel;
    @FXML
    private Label lbTitulo;
    @FXML
    private Label lbCasasCantidad;
    @FXML
    private Label lbHotelCantidad;
    @FXML
    private JFXButton btnMenos;
    @FXML
    private JFXButton btnMas;
    @FXML
    private JFXButton btnMenosH;
    @FXML
    private JFXButton btnMasH;
    @FXML
    private JFXButton btnListo;
    @FXML
    private TabPane tbpConstruirPropiedad;
    @FXML
    private Tab tbpPropiedades;
    @FXML
    private Tab tbpConstruir;

    ObservableList<Solar> propiedades = FXCollections.observableArrayList();
    Solar propiedad;
    Banca banca;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  // Acá muestra las propiedades para construir y demoler

        tbcNombre.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getNombre()));
        tbcCasas.setCellValueFactory(cd -> new SimpleStringProperty("" + cd.getValue().getCasas()));
        tbcHotel.setCellValueFactory(cd -> new SimpleStringProperty("" + cd.getValue().getHotel()));

        tbvPropiedades.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                propiedad = newValue;
            } else {
                nuevaPropiedad();
            }
            actualizarPropiedad();
        });
    }

    @Override
    public void initialize() {
        tbpConstruirPropiedad.getSelectionModel().select(tbpPropiedades);
        nuevaPropiedad();
        actualizarPropiedad();
    }

    @FXML
    private void onActionMenos(ActionEvent event) {
        propiedad.demolerCasa(banca);
        actualizarPropiedad();
    }

    @FXML
    private void onActionMas(ActionEvent event) {
        propiedad.construirCasa(banca);
        actualizarPropiedad();
    }

    @FXML
    private void onActionMenosH(ActionEvent event) {
        propiedad.demolerHotel(banca);
        actualizarPropiedad();
    }

    @FXML
    private void onActionMasH(ActionEvent event) {
        propiedad.construirHotel(banca);
        actualizarPropiedad();
    }

    @FXML
    private void onActionBtnListo(ActionEvent event) {
        getStage().close();
    }

    @FXML
    private void onSelectionChangedTbpConstruir(Event event) {
        if (tbpConstruir.isSelected()) {
            if (propiedad.getNombre().isBlank()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Construir", getStage(), "Debe seleccionar la propiedad antes.");
                tbpConstruirPropiedad.getSelectionModel().select(tbpPropiedades);
            }
        }
    }

    public void actualizarPropiedad() {
        lbTitulo.setText(!propiedad.getNombre().isBlank() ? propiedad.getNombre() : "Propiedad");
        lbCasasCantidad.setText("" + propiedad.getCasas());
        lbHotelCantidad.setText("" + propiedad.getHotel());
    }

    private void nuevaPropiedad() {
        propiedad = new Solar();
    }

    public void construirCasasHoteles(JugadorDto jugador, TableroDto tablero, Banca banca, boolean azul, boolean amarillo, boolean rojo, boolean verde) {
        tbvPropiedades.getItems().clear();
        this.banca = banca;
        getPropiedades(jugador, tablero, azul, amarillo, rojo, verde);
        tbvPropiedades.setItems(propiedades);
        tbvPropiedades.refresh();
    }

    public void getPropiedades(JugadorDto jugador, TableroDto tablero, boolean azul, boolean amarillo, boolean rojo, boolean verde) {  // Obtiene las propiedades en las que se puedan construir
        propiedades.clear();
        List<Solar> solaresPropios = new ArrayList<>();

        if (azul) {
            solaresPropios.addAll(tablero.getPropiedadesSolar().stream().filter(p -> "Azul".equals(p.getColor()))
                    .map(p -> p)
                    .collect(Collectors.toList()));
        }
        if (amarillo) {
            solaresPropios.addAll(tablero.getPropiedadesSolar().stream().filter(p -> "Amarillo".equals(p.getColor()))
                    .map(p -> p)
                    .collect(Collectors.toList()));
        }
        if (rojo) {
            solaresPropios.addAll(tablero.getPropiedadesSolar().stream().filter(p -> "Rojo".equals(p.getColor()))
                    .map(p -> p)
                    .collect(Collectors.toList()));
        }
        if (verde) {
            solaresPropios.addAll(tablero.getPropiedadesSolar().stream().filter(p -> "Verde".equals(p.getColor()))
                    .map(p -> p)
                    .collect(Collectors.toList()));
        }

        for (Solar sola : solaresPropios) {
            propiedades.add(sola);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.monopolyjunior.model.Banca;
import cr.ac.una.monopolyjunior.model.JugadorDto;
import cr.ac.una.monopolyjunior.model.Propiedad;
import cr.ac.una.monopolyjunior.model.Solar;
import cr.ac.una.monopolyjunior.model.Tablero;
import cr.ac.una.tarea.util.Mensaje;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class VenderViewController extends Controller implements Initializable {

    @FXML
    private StackPane root;
    @FXML
    private TableView tbvPropiedades;
    @FXML
    private JFXButton btnListo;

    ObservableList<Propiedad> propiedades = FXCollections.observableArrayList();
    Tablero tablero;
    JugadorDto jugador;
    Banca banca;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void initialize() {
    }

    @FXML
    private void onActionBtnListo(ActionEvent event) {
    }

    public void VenderPropiedades(Tablero tablero, JugadorDto jugador, Banca banca) {
        try {
            this.jugador = jugador;
            this.banca = banca;
            this.tablero = tablero;

            tbvPropiedades.getColumns().clear();
            tbvPropiedades.getItems().clear();

            TableColumn<Propiedad, String> tbcNombre = new TableColumn<>("Nombre");
            tbcNombre.setPrefWidth(150);
            tbcNombre.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getNombre()));

            TableColumn<Propiedad, Boolean> tbcVender = new TableColumn<>("Vender");
            tbcVender.setPrefWidth(100);
            tbcVender.setCellValueFactory(cd -> new SimpleObjectProperty(cd.getValue() != null));
            tbcVender.setCellFactory(cd -> new ButtonCell("Vender"));

            tbvPropiedades.getColumns().add(tbcNombre);
            tbvPropiedades.getColumns().add(tbcVender);
            tbvPropiedades.refresh();
            
            tbvPropiedades.getItems().clear();
            getPropiedades();
            tbvPropiedades.setItems(propiedades);
            tbvPropiedades.refresh();

        } catch (Exception ex) {
            Logger.getLogger(VenderViewController.class.getName()).log(Level.SEVERE, "Error consultando los empleado", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Consultar empleado", getStage(), "Ocurrio un error consultando los empleados");
        }
    }

    public void getPropiedades() {
        propiedades.clear();
        
        propiedades.addAll(tablero.getPropiedadesSolar().stream().filter(p -> p.getPropietario()!= null && jugador.getNombre().equals(p.getPropietario().getNombre()))
                .map(p -> p)
                .collect(Collectors.toList()));
        
        propiedades.addAll(tablero.getPropiedadesEstacion().stream().filter(p -> p.getPropietario()!= null && jugador.getNombre().equals(p.getPropietario().getNombre()))
                .map(p -> p)
                .collect(Collectors.toList()));
        
        propiedades.addAll(tablero.getPropiedadesServicios().stream().filter(p -> p.getPropietario()!= null && jugador.getNombre().equals(p.getPropietario().getNombre()))
                .map(p -> p)
                .collect(Collectors.toList()));

    }

    private class ButtonCell extends TableCell<Propiedad, Boolean> {

        final Button cellButton = new Button();

        ButtonCell(String nombre) {
            cellButton.setText(nombre);
            cellButton.setPrefWidth(500);
//            cellButton.getStyleClass().add("jfx-btnimg-tbveliminar");

            cellButton.setOnAction((ActionEvent t) -> {
                Propiedad prop = (Propiedad) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());

                if (prop != null && prop instanceof Solar) {
                    Solar propSolar = (Solar) prop;
                    for (Solar pro : tablero.getPropiedadesSolar()) {
                        if (pro.getColor().equals(propSolar.getColor())) {
                            if(pro.getHotel() == 1) {
                                pro.demolerHotel(banca);
                            }
                            for (int i = pro.getCasas(); i > 0; i--) {
                                pro.demolerCasa(banca);
                            }
                            if (propSolar.getNombre().equals(pro.getNombre())) {
                                pro.setPropietario(null);
                                jugador.quitarPropiedad(pro.getNombre());
                            }
                        }
                    }
                }
                tbvPropiedades.getItems().remove(prop);
                tbvPropiedades.refresh();
            });
        }

        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(cellButton);
            }
        }
    }

}

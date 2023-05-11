/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopolyjunior.model.JugadorDto;
import cr.ac.una.monopolyjunior.model.Propiedad;
import cr.ac.una.monopolyjunior.model.Tablero;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class ConstruirViewController extends Controller implements Initializable {

    @FXML
    private TableColumn<Propiedad, String> tbcNombre;
    @FXML
    private TableColumn<Propiedad, String> tbcCasas;
    @FXML
    private TableColumn<Propiedad, String> tbcHotel;
    @FXML
    private Label lbTitulo;
    @FXML
    private JFXButton btnMenos;
    @FXML
    private Label lbCasasCantidad;
    @FXML
    private JFXButton btnMas;
    @FXML
    private JFXButton btnMenosH;
    @FXML
    private Label lbCasasCantidad1;
    @FXML
    private JFXButton btnMasH;
    @FXML
    private JFXButton btnListo;
    @FXML
    private Tab tbpPropiedades;
    @FXML
    private Tab tbpConstruir;

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
    private void onActionMenos(ActionEvent event) {
    }

    @FXML
    private void onActionMas(ActionEvent event) {
    }

    @FXML
    private void onActionMenosH(ActionEvent event) {
    }

    @FXML
    private void onActionMasH(ActionEvent event) {
    }

    @FXML
    private void onActionBtnListo(ActionEvent event) {
    }

    @FXML
    private void onSelectionChangedTbpConstruir(Event event) {
    }

    public void construirCasasHoteles(JugadorDto jugador, Tablero aThis, boolean azul, boolean amarillo, boolean rojo, boolean verde) {
    }
    
}

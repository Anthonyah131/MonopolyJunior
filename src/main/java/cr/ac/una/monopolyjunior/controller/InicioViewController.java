/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class InicioViewController extends Controller implements Initializable {

    @FXML
    private ImageView imgView;
    @FXML
    private JFXButton btnNuevaPartida;
    @FXML
    private JFXButton btnCargarPartida;
    @FXML
    private JFXButton btnSalir;

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
    private void onActionBtnNuevaPartida(ActionEvent event) {
    }

    @FXML
    private void onActionCargarPartida(ActionEvent event) {
    }

    @FXML
    private void onActionBtnSalir(ActionEvent event) {
    }
    
}
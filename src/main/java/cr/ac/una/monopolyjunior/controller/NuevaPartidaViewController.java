/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class NuevaPartidaViewController extends Controller implements Initializable {

    @FXML
    private VBox containerPlayer1;
    @FXML
    private Label lbPlayer1;
    @FXML
    private VBox containerPlayer2;
    @FXML
    private Label lbPlayer2;
    @FXML
    private Label lbPlayer;
    @FXML
    private JFXTextField txfNombreJugador;
    @FXML
    private HBox contenedorFichas1;
    @FXML
    private HBox contenedorFichas2;

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
    
}

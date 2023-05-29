/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopolyjunior.util.FlowController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgView.setImage(new Image("cr/ac/una/monopolyjunior/resources/MonopolyLogo1.png"));
    }

    @Override
    public void initialize() {
    }

    @FXML
    private void onActionBtnNuevaPartida(ActionEvent event) {
        FlowController.getInstance().salir();
        FlowController.getInstance().goViewInWindow("NuevaPartidaView");
    }

    @FXML
    private void onActionCargarPartida(ActionEvent event) {
        FlowController.getInstance().salir();
        FlowController.getInstance().goViewInWindowModal("CargarPartidaView", getStage(), true);
    }

    @FXML
    private void onActionBtnSalir(ActionEvent event) {
        FlowController.getInstance().salir();
    }

}

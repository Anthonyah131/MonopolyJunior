/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import cr.ac.una.monopolyjunior.util.FlowController;
import cr.ac.una.tarea.util.Mensaje;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView imgPlayer1;
    @FXML
    private VBox containerPlayer2;
    @FXML
    private Label lbPlayer2;
    @FXML
    private ImageView imgPlayer2;
    @FXML
    private Label lbPlayer;
    @FXML
    private HBox contenedorFichas1;
    @FXML
    private HBox contenedorFichas2;
    @FXML
    private JFXTextField txfNombreJugador;
    @FXML
    private JFXButton btnContinuar;

    String fichaPlayer = "";
    List<Image> fichas = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fichas.add(new Image("cr/ac/una/monopolyjunior/resources/fichas/Battleship.png"));
        fichas.add(new Image("cr/ac/una/monopolyjunior/resources/fichas/Car.png"));
        fichas.add(new Image("cr/ac/una/monopolyjunior/resources/fichas/Dog.png"));
        fichas.add(new Image("cr/ac/una/monopolyjunior/resources/fichas/Hat.png"));
        fichas.add(new Image("cr/ac/una/monopolyjunior/resources/fichas/Iron.png"));
        fichas.add(new Image("cr/ac/una/monopolyjunior/resources/fichas/Shoe.png"));
        fichas.add(new Image("cr/ac/una/monopolyjunior/resources/fichas/Thimble.png"));
        fichas.add(new Image("cr/ac/una/monopolyjunior/resources/fichas/Wheelbarrow.png"));

        for (int i = 0; i < 8; i++) {
            ImageView imageview = new ImageView(fichas.get(i));
            imageview.setPreserveRatio(false);
            imageview.setFitHeight(75);
            imageview.setFitWidth(75);
            imageview.setOnMouseClicked(event -> {
                fichaPlayer = imageview.getImage().getUrl();
                System.out.println(fichaPlayer);
            });
            if (i >= 4) {
                contenedorFichas2.getChildren().add(imageview);
            } else {
                contenedorFichas1.getChildren().add(imageview);
            }
        }
    }

    @Override
    public void initialize() {
    }

    @FXML
    private void onActionBtnContinuar(ActionEvent event) {
        if ("Player 1".equals(lbPlayer.getText())) {
            if (!fichaPlayer.isBlank() && !txfNombreJugador.getText().isBlank()) {
                imgPlayer1.setImage(new Image(fichaPlayer));
                lbPlayer1.setText(txfNombreJugador.getText());
                fichaPlayer = "";
                txfNombreJugador.setText("");
                lbPlayer.setText("Player 2");
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Player 1", getStage(), "Error creando el Player 1, revise los campos");
            }
        } else if ("Player 2".equals(lbPlayer.getText())) {
            if (!fichaPlayer.isBlank() && !txfNombreJugador.getText().isBlank()) {
                imgPlayer2.setImage(new Image(fichaPlayer));
                lbPlayer2.setText(txfNombreJugador.getText());
                JuegoViewController juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
                juegoViewController.crearTablero(lbPlayer1.getText(), imgPlayer1.getImage().getUrl(), lbPlayer2.getText(), imgPlayer2.getImage().getUrl());
                FlowController.getInstance().goViewInWindow("JuegoView");
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Player 2", getStage(), "Error creando el Player 2, revise los campos");
            }
        }
    }

}

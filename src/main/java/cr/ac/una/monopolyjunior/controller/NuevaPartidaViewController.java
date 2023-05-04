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
import javafx.scene.input.MouseEvent;
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
    private JFXButton btnCancelar;
    @FXML
    private JFXButton btnContinuar;

    String fichaPlayer;
    List<String> fichas = new ArrayList<>();
    JFXButton imagenSeleccionada;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fichas.add("Battleship.png");
        fichas.add("Car.png");
        fichas.add("Dog.png");
        fichas.add("Hat.png");
        fichas.add("Iron.png");
        fichas.add("Shoe.png");
        fichas.add("Thimble.png");
        fichas.add("Wheelbarrow.png");
        
        contenedorFichas1.setSpacing(5);
        contenedorFichas2.setSpacing(5);
    }

    @Override
    public void initialize() {
        imagenSeleccionada = null;
        fichaPlayer = "Player 1";
        txfNombreJugador.setText("");
        lbPlayer.setText(fichaPlayer);
        
        lbPlayer1.setText("...");
        lbPlayer2.setText("...");
        imgPlayer1.setImage(null);
        imgPlayer2.setImage(null);
        
        contenedorFichas1.getChildren().clear();
        contenedorFichas2.getChildren().clear();
        
        for (int i = 0; i < 8; i++) {
            JFXButton btnFicha = new JFXButton();
            ImageView imageview = new ImageView("cr/ac/una/monopolyjunior/resources/fichas/" + fichas.get(i));
            btnFicha.setId(fichas.get(i));
            imageview.setPreserveRatio(false);
            imageview.setFitHeight(75);
            imageview.setFitWidth(75);
            btnFicha.setGraphic(imageview);
            btnFicha.setOnMouseClicked(this::seleccionarImagen);
            if (i >= 4) {
                contenedorFichas2.getChildren().add(btnFicha);
            } else {
                contenedorFichas1.getChildren().add(btnFicha);
            }
        }
    }

    @FXML
    private void onActionBtnContinuar(ActionEvent event) {
        if ("Player 1".equals(lbPlayer.getText())) {
            if (!fichaPlayer.isBlank() && !txfNombreJugador.getText().isBlank()) {
                imgPlayer1.setImage(new Image("cr/ac/una/monopolyjunior/resources/fichas/" + fichaPlayer));
                imgPlayer1.setId(fichaPlayer);
                lbPlayer1.setText(txfNombreJugador.getText());
                fichaPlayer = "";
                txfNombreJugador.setText("");
                imagenSeleccionada.setDisable(true);
                lbPlayer.setText("Player 2");
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Player 1", getStage(), "Error creando el Player 1, revise los campos");
            }
        } else if ("Player 2".equals(lbPlayer.getText())) {
            if (!fichaPlayer.isBlank() && !txfNombreJugador.getText().isBlank()) {
                imgPlayer2.setImage(new Image("cr/ac/una/monopolyjunior/resources/fichas/" + fichaPlayer));
                imgPlayer2.setId(fichaPlayer);
                lbPlayer2.setText(txfNombreJugador.getText());
                JuegoViewController juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
                juegoViewController.crearTablero(lbPlayer1.getText(), imgPlayer1.getId(), lbPlayer2.getText(), imgPlayer2.getId());
                FlowController.getInstance().goViewInWindow("JuegoView");
                getStage().close();
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Player 2", getStage(), "Error creando el Player 2, revise los campos");
            }
        }
    }

    public void seleccionarImagen(MouseEvent event) {
        JFXButton btnFicha = (JFXButton) event.getSource();

        if (imagenSeleccionada != null) {
            imagenSeleccionada.getStyleClass().remove("seleccionada");
        }
        
        btnFicha.getStyleClass().add("seleccionada");

        imagenSeleccionada = btnFicha;
        fichaPlayer = btnFicha.getId();
    }

    @FXML
    private void onActionBtnCancelar(ActionEvent event) {
        FlowController.getInstance().goMain();
        getStage().close();
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopolyjunior.model.Banca;
import cr.ac.una.monopolyjunior.model.JugadorDto;
import cr.ac.una.monopolyjunior.model.Tablero;
import cr.ac.una.monopolyjunior.util.FlowController;
import cr.ac.una.tarea.util.Mensaje;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class JuegoViewController extends Controller implements Initializable {

    @FXML
    private BorderPane rootJuegoView;
    @FXML
    private AnchorPane boardAnchor;
    @FXML
    private GridPane boardPane;
    @FXML
    private ImageView imgLogo;
    @FXML
    private Label lbTurno;
    @FXML
    private Label lbCapital;
    @FXML
    private JFXButton btnFinalizarTurno;
    @FXML
    private JFXButton btnMiCapital;
    @FXML
    private JFXButton btnComprarPropi;
    @FXML
    private JFXButton btnVerderPropi;
    @FXML
    private JFXButton btnContruir;
    @FXML
    private JFXButton btnHipotecar;
    @FXML
    private JFXButton btnPagarHipoteca;
    @FXML
    private JFXButton btnFinalizarJuego;

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;
    private static final int TILE_SIZE1 = 55;
    private static final int TILE_SIZE2 = 90;

    Tablero tablero;
    Banca banca;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @Override
    public void initialize() {
    }

    public void crearTablero(String player1, String ficha1, String player2, String ficha2) {
        JugadorDto jugador1 = new JugadorDto(player1, ficha1, 1500);
        JugadorDto jugador2 = new JugadorDto(player2, ficha2, 1500);
        tablero = new Tablero(jugador1, jugador2);

        lbTurno.setText(tablero.getJugadores().get(0).getNombre());

        banca = new Banca();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                StackPane tile = new StackPane();
                tile.getStylesheets().add("grid-pane");

                if (row == 0 && (col == 0 || col == 8) || row == 8 && (col == 0 || col == 8)) {
                    tile.setPrefSize(TILE_SIZE2, TILE_SIZE2);

                } else if (row == 0 || row == 8) {
                    tile.setPrefSize(TILE_SIZE1, TILE_SIZE2);

                } else if (col == 0 || col == 8) {
                    tile.setPrefSize(TILE_SIZE2, TILE_SIZE1);

                } else {
                    tile.setPrefSize(TILE_SIZE1, TILE_SIZE1);

                }
                boardPane.add(tile, col, row);
            }
        }

        StackPane node = null;
        for (Node child : boardPane.getChildren()) {
            if (GridPane.getColumnIndex(child) == 8 && GridPane.getRowIndex(child) == 8) {
                node = (StackPane) child;
                break;
            }
        }
        if (node != null) {
            ImageView imgPlayer1 = new ImageView(new Image(tablero.getJugadores().get(0).getFicha()));
            imgPlayer1.setFitWidth(50);
            imgPlayer1.setFitHeight(50);
            imgPlayer1.setId("imgPlayer1");

            ImageView imgPlayer2 = new ImageView(new Image(tablero.getJugadores().get(1).getFicha()));
            imgPlayer2.setFitWidth(50);
            imgPlayer2.setFitHeight(50);
            imgPlayer2.setId("imgPlayer2");

            node.getChildren().addAll(imgPlayer1, imgPlayer2);
        }
    }

    @FXML
    private void onActionBtnFinalizarTurno(ActionEvent event) {
        if (tablero.getJugadores().get(0).getNombre().equals(lbTurno.getText())) {
            int posX = tablero.getJugadores().get(0).getPosicionX();
            int posY = tablero.getJugadores().get(0).getPosicionY();

            StackPane node = null;
            for (Node child : boardPane.getChildren()) {
                if (GridPane.getColumnIndex(child) == posX && GridPane.getRowIndex(child) == posY) {
                    node = (StackPane) child;
                    break;
                }
            }

            Random rand = new Random();
            int dado = rand.nextInt(6) + 1;

            if (posX >= 0 && posX <= 7 && posY == 0) {
                posX += dado;
                if (posX > 8) {
                    posX = 8;
                }
            } else if (posX == 8 && posY >= 0 && posY <= 7) {
                posY += dado;
                if (posY > 8) {
                    posY = 8;
                }
            } else if (posX >= 1 && posX <= 8 && posY == 8) {
                posX -= dado;
                if (posX < 0) {
                    posX = 0;
                }
            } else if (posX == 0 && posY >= 1 && posY <= 8) {
                posY -= dado;
                if (posY < 0) {
                    posY = 0;
                }
            }

            if (node != null) {
                ImageView imgFicha = null;
                for (Node child : node.getChildren()) {
                    if ("imgPlayer1".equals(child.getId())) {
                        imgFicha = (ImageView) child;
                        break;
                    }
                }
                node.getChildren().remove(imgFicha);

                for (Node child : boardPane.getChildren()) {
                    if (GridPane.getColumnIndex(child) == posX && GridPane.getRowIndex(child) == posY) {
                        node = (StackPane) child;
                        node.getChildren().add(imgFicha);
                        break;
                    }
                }
            }

            tablero.getJugadores().get(0).mover(posX, posY);
            lbTurno.setText(tablero.getJugadores().get(1).getNombre());
        } else if (tablero.getJugadores().get(1).getNombre().equals(lbTurno.getText())) {
            int posX = tablero.getJugadores().get(1).getPosicionX();
            int posY = tablero.getJugadores().get(1).getPosicionY();

            StackPane node = null;
            for (Node child : boardPane.getChildren()) {
                if (GridPane.getColumnIndex(child) == posX && GridPane.getRowIndex(child) == posY) {
                    node = (StackPane) child;
                    break;
                }
            }

            Random rand = new Random();
            int dado = rand.nextInt(6) + 1;

            if (posX >= 0 && posX <= 7 && posY == 0) {
                posX += dado;
                if (posX > 8) {
                    posX = 8;
                }
            } else if (posX == 8 && posY >= 0 && posY <= 7) {
                posY += dado;
                if (posY > 8) {
                    posY = 8;
                }
            } else if (posX >= 1 && posX <= 8 && posY == 8) {
                posX -= dado;
                if (posX < 0) {
                    posX = 0;
                }
            } else if (posX == 0 && posY >= 1 && posY <= 8) {
                posY -= dado;
                if (posY < 0) {
                    posY = 0;
                }
            }

            if (node != null) {
                ImageView imgFicha = null;
                for (Node child : node.getChildren()) {
                    if ("imgPlayer2".equals(child.getId())) {
                        imgFicha = (ImageView) child;
                        break;
                    }
                }
                node.getChildren().remove(imgFicha);

                for (Node child : boardPane.getChildren()) {
                    if (GridPane.getColumnIndex(child) == posX && GridPane.getRowIndex(child) == posY) {
                        node = (StackPane) child;
                        node.getChildren().add(imgFicha);
                        break;
                    }
                }
            }

            tablero.getJugadores().get(1).mover(posX, posY);
            lbTurno.setText(tablero.getJugadores().get(0).getNombre());
        }
    }

    @FXML
    private void onActionBtnMiCapital(ActionEvent event) {
    }

    @FXML
    private void onActionBtnComprarPropi(ActionEvent event) {
    }

    @FXML
    private void onActionBtnVenderPropi(ActionEvent event) {
    }

    @FXML
    private void onActionBtnConstruir(ActionEvent event) {
    }

    @FXML
    private void onActionBtnHipotecar(ActionEvent event) {
    }

    @FXML
    private void btnPagarHipoteca(ActionEvent event) {
    }

    @FXML
    private void onActionBtnFinalizarJuego(ActionEvent event) {
    }
}

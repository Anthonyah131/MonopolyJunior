/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopolyjunior.model.Banca;
import cr.ac.una.monopolyjunior.model.Casilla;
import cr.ac.una.monopolyjunior.model.Dado;
import cr.ac.una.monopolyjunior.model.JugadorDto;
import cr.ac.una.monopolyjunior.model.Tablero;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

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
    @FXML
    private StackPane stakPaneDados;
    @FXML
    private JFXButton btnDados;

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;
    private static final int TILE_SIZE1 = 55;
    private static final int TILE_SIZE2 = 90;

    Tablero tablero;
    Banca banca;
    Dado dado;

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
        lbCapital.setText("" + tablero.getJugadores().get(0).getSaldo());

        banca = new Banca();
        dado = new Dado(6);

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
            System.out.println("cr/ac/una/monopolyjunior/resources/fichas/" + tablero.getJugadores().get(0).getFicha());
            ImageView imgPlayer1 = new ImageView(new Image("cr/ac/una/monopolyjunior/resources/fichas/" + tablero.getJugadores().get(0).getFicha()));
            imgPlayer1.setFitWidth(50);
            imgPlayer1.setFitHeight(50);
            imgPlayer1.setId("imgPlayer1");

            ImageView imgPlayer2 = new ImageView(new Image("cr/ac/una/monopolyjunior/resources/fichas/" + tablero.getJugadores().get(1).getFicha()));
            imgPlayer2.setFitWidth(50);
            imgPlayer2.setFitHeight(50);
            imgPlayer2.setId("imgPlayer2");

            node.getChildren().addAll(imgPlayer1, imgPlayer2);
        }
    }

    @FXML
    private void onActionBtnFinalizarTurno(ActionEvent event) {
        JugadorDto player;
        if (tablero.getJugadores().get(0).getNombre().equals(lbTurno.getText())) {
            player = tablero.getJugadores().get(1);
            actualizarDatosInterfaz(player);
        } else if (tablero.getJugadores().get(1).getNombre().equals(lbTurno.getText())) {
            player = tablero.getJugadores().get(0);
            actualizarDatosInterfaz(player);
        }
        translateAnimation(0.5, stakPaneDados, -2000);
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

    @FXML
    private void onActionBtnDados(ActionEvent event) {
        JugadorDto player;
        String id = "";

        if (tablero.getJugadores().get(0).getNombre().equals(lbTurno.getText())) {
            player = tablero.getJugadores().get(0);
            id = "imgPlayer1";
        } else {
            player = tablero.getJugadores().get(1);
            id = "imgPlayer2";
        }

        int posX = player.getPosicionX();
        int posY = player.getPosicionY();

        StackPane node = null;
        for (Node child : boardPane.getChildren()) {
            if (GridPane.getColumnIndex(child) == posX && GridPane.getRowIndex(child) == posY) {
                node = (StackPane) child;
                break;
            }
        }

        int dadoTirado = dado.lanzar();

        if (posX >= 0 && posX <= 7 && posY == 0) {
            posX += dadoTirado;
            if (posX > 8) {
                posX = 8;
            }
        } else if (posX == 8 && posY >= 0 && posY <= 7) {
            posY += dadoTirado;
            if (posY > 8) {
                posY = 8;
            }
        } else if (posX >= 1 && posX <= 8 && posY == 8) {
            posX -= dadoTirado;
            if (posX < 0) {
                posX = 0;
            }
        } else if (posX == 0 && posY >= 1 && posY <= 8) {
            posY -= dadoTirado;
            if (posY < 0) {
                posY = 0;
            }
        }

        if (node != null) {
            ImageView imgFicha = null;
            for (Node child : node.getChildren()) {
                if (id.equals(child.getId())) {
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

        tablero.moverJugador(player, posX, posY);
        accionCasilla(player);
        actualizarDatosInterfaz(player);
        translateAnimation(0.5, stakPaneDados, 2000);
    }

    public void accionCasilla(JugadorDto jugador) {
        Casilla casilla = tablero.getCasillaActual(jugador);
        casilla.accion(jugador, banca, tablero, getStage());
        System.out.println(jugador.getNombre() + " : " + casilla.getNombre());
    }

    public void actualizarDatosInterfaz(JugadorDto player) {
        lbTurno.setText(player.getNombre());
        lbCapital.setText("" + player.getSaldo());
    }

    public void translateAnimation(double duration, Node node, double width) { //Metodo de la animacion
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
        translateTransition.setOnFinished(event -> {
//            isAnimating = false;
//            jfxBtnAnt.setDisable(false);
//            jfxBtnSig.setDisable(false);
        });
        translateTransition.setByX(width);
        translateTransition.play();
    }

}

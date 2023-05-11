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
import cr.ac.una.monopolyjunior.model.Propiedad;
import cr.ac.una.monopolyjunior.model.Tablero;
import cr.ac.una.monopolyjunior.util.FlowController;
import cr.ac.una.tarea.util.Mensaje;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    private JFXButton btnPagarDeudaMulta;
    @FXML
    private JFXButton btnFinalizarJuego;

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;
    private static final int TILE_SIZE1 = 55;
    private static final int TILE_SIZE2 = 90;

    boolean turnoP1 = true;
    boolean turnoP2 = false;

    Tablero tablero;
    Banca banca;
    Dado dado;
    int dadoTirado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    }

    @Override
    public void initialize() {
    }

    public void crearTablero(String player1, String ficha1, String player2, String ficha2) {
        if (boardAnchor.getChildren().size() >= 2) {
            boardAnchor.getChildren().remove(1);
        }

        JFXButton btnDados = new JFXButton("Lanzar Dados");
        btnDados.setOnAction(this::onActionBtnDados);
        HBox hobxDados = new HBox(btnDados);
        hobxDados.setAlignment(Pos.CENTER);
        StackPane stakPaneDados = new StackPane(hobxDados);
        stakPaneDados.setMinWidth(564);
        stakPaneDados.setMinHeight(564);
        stakPaneDados.setMaxWidth(564);
        stakPaneDados.setMaxHeight(564);
        boardAnchor.getChildren().add(stakPaneDados);

        JugadorDto jugador1 = new JugadorDto(player1, ficha1, 1500);
        JugadorDto jugador2 = new JugadorDto(player2, ficha2, 1500);
        tablero = new Tablero(jugador1, jugador2);

        turnoP1 = true;
        turnoP2 = false;

        lbTurno.setText(tablero.getJugadores().get(0).getNombre());
        lbCapital.setText("" + tablero.getJugadores().get(0).getSaldo());

        banca = new Banca();
        dado = new Dado(6);

        StackPane node = null;
        for (Node child : boardPane.getChildren()) {
            node = (StackPane) child;
            node.getChildren().clear();
        }

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
        desactivarOpciones();
    }

    @FXML
    private void onActionBtnFinalizarTurno(ActionEvent event) {
        JugadorDto player;
        if (turnoP1) {
            player = tablero.getJugadores().get(1);
            if (tablero.player1Debe) {
                OpcionJugadorViewController opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.turnoBancarrota(player, tablero);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", getStage(), true);
            } else {
                turnoP1 = false;
                turnoP2 = true;
                actualizarDatosInterfaz(player);
                translateAnimation(0.5, boardAnchor.getChildren().get(1), -2000);
                desactivarOpciones();
            }
        } else if (turnoP2) {
            player = tablero.getJugadores().get(0);
            if (tablero.player1Debe) {
                OpcionJugadorViewController opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                opcionJugadorViewController.turnoBancarrota(player, tablero);
                FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", getStage(), true);
            } else {
                turnoP1 = true;
                turnoP2 = false;
                actualizarDatosInterfaz(player);
                translateAnimation(0.5, boardAnchor.getChildren().get(1), -2000);
                desactivarOpciones();
            }
        }
    }

    @FXML
    private void onActionBtnMiCapital(ActionEvent event) {
        JugadorDto player = null;
        if (tablero.getJugadores().get(0).getNombre().equals(lbTurno.getText())) {
            player = tablero.getJugadores().get(0);
        } else if (tablero.getJugadores().get(1).getNombre().equals(lbTurno.getText())) {
            player = tablero.getJugadores().get(1);
        }
        OpcionJugadorViewController opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
        opcionJugadorViewController.miCapitalInterfaz(player, tablero);
        FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", getStage(), true);
    }

    @FXML
    private void onActionBtnComprarPropi(ActionEvent event) {
        JugadorDto player = null;
        if (turnoP1) {
            player = tablero.getJugadores().get(0);
        } else if (turnoP2) {
            player = tablero.getJugadores().get(1);
        }
        comprarPropiedad(player);
    }

    @FXML
    private void onActionBtnVenderPropi(ActionEvent event) {
    }

    @FXML
    private void onActionBtnConstruir(ActionEvent event) {
        JugadorDto player = null;
        if (turnoP1) {
            player = tablero.getJugadores().get(0);
        } else if (turnoP2) {
            player = tablero.getJugadores().get(1);
        }
        tablero.puedeConstruir(player, getStage());
    }

    @FXML
    private void onActionBtnHipotecar(ActionEvent event) {
    }

    @FXML
    private void btnPagarHipoteca(ActionEvent event) {
    }

    @FXML
    private void onActionBtnPagarDeudaMulta(ActionEvent event) {
        JugadorDto player = null;
        Boolean bandera = false;
        if (tablero.getJugadores().get(0).getNombre().equals(lbTurno.getText())) {
            player = tablero.getJugadores().get(0);
            bandera = tablero.player1Debe;
        } else if (tablero.getJugadores().get(1).getNombre().equals(lbTurno.getText())) {
            player = tablero.getJugadores().get(1);
            bandera = tablero.player2Debe;
        }
        if (bandera == true) {
            accionCasilla(player);
        } else {
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Deuda o Multa", getStage(), "Sin pagos pendientes.");
        }
    }

    @FXML
    private void onActionBtnFinalizarJuego(ActionEvent event) {
        FlowController.getInstance().goMain();
        getStage().close();
    }

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

        dadoTirado = dado.lanzar();
//        dadoTirado = 5;

        moverFicha(dadoTirado, id, player);

        accionCasilla(player);
        translateAnimation(0.5, boardAnchor.getChildren().get(1), 2000);
        activarOpciones();
    }

    public void moverFicha(int dadoTirado, String id, JugadorDto player) {
        int posX = player.getPosicionX();
        int posY = player.getPosicionY();

        StackPane node = null;
        for (Node child : boardPane.getChildren()) {
            if (GridPane.getColumnIndex(child) == posX && GridPane.getRowIndex(child) == posY) {
                node = (StackPane) child;
                break;
            }
        }

        System.out.println("Dado : " + dadoTirado);
        if (posX >= 0 && posX <= 7 && posY == 0) {
            posX += dadoTirado;
            if (posX > 8) {
                dadoTirado = posX - 8;
                posX = 8;
                posY += dadoTirado;
            }
        } else if (posX == 8 && posY >= 0 && posY <= 7) {
            posY += dadoTirado;
            if (posY > 8) {
                pasaPorGo();
            }
            if (posY > 8) {
                dadoTirado = posY - 8;
                posY = 8;
                posX -= dadoTirado;
            }
        } else if (posX >= 1 && posX <= 8 && posY == 8) {
            posX -= dadoTirado;
            if (posX < 0) {
                dadoTirado = posX * -1;
                posX = 0;
                posY -= dadoTirado;
            }
        } else if (posX == 0 && posY >= 1 && posY <= 8) {
            posY -= dadoTirado;
            if (posY < 0) {
                dadoTirado = posY * -1;
                posY = 0;
                posX += dadoTirado;
            }
        }

//        posX = 8; // Ve a la Carcel
//        posY = 0; // Ve a la Carcel
//        posX = 0; // Impuesto
//        posY = 7; // Impuesto
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
    }

    public void moverFicha(JugadorDto player, int posX, int posY) {
        String id = "";

        if (tablero.getJugadores().get(0).getNombre().equals(lbTurno.getText())) {
            player = tablero.getJugadores().get(0);
            id = "imgPlayer1";
        } else {
            player = tablero.getJugadores().get(1);
            id = "imgPlayer2";
        }

        int posXA = player.getPosicionX();
        int posYA = player.getPosicionY();

        StackPane node = null;
        for (Node child : boardPane.getChildren()) {
            if (GridPane.getColumnIndex(child) == posXA && GridPane.getRowIndex(child) == posYA) {
                node = (StackPane) child;
                break;
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
    }

    public void pasaPorGo() {
        System.out.println("Ups te pasaste Go no olvides tus $200");

        JugadorDto jugador;

        if (tablero.getJugadores().get(0).getNombre().equals(lbTurno.getText())) {
            jugador = tablero.getJugadores().get(0);
        } else {
            jugador = tablero.getJugadores().get(1);
        }

        OpcionJugadorViewController opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
        opcionJugadorViewController.goInterfaz(jugador, banca, tablero, getStage());
        FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", getStage(), true);
    }

    public void comprarPropiedad(JugadorDto jugador) {
        Casilla casilla = tablero.getCasillaActual(jugador);
        Propiedad propiedad = tablero.getPropiedad(casilla.getNombre());
        if (propiedad.getPropietario() == null) {
            String tipo = tablero.getCasillaActual(jugador).getTipo();
            if ("Solar".equals(tipo) || "Servicio Publico".equals(tipo) || "Estacion".equals(tipo)) {
                accionCasilla(jugador);
            }
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Comprar Propiedad", getStage(), "La propiedad ya tiene un dueño.");
        }
    }

    public void accionCasilla(JugadorDto jugador) {
        Casilla casilla = tablero.getCasillaActual(jugador);
        casilla.accion(jugador, banca, tablero, getStage(), dadoTirado);
        actualizarDatosInterfaz(jugador);
        System.out.println(jugador.getNombre() + " : " + casilla.getNombre());
    }

    public void actualizarDatosInterfaz(JugadorDto player) {
        lbTurno.setText(player.getNombre());
        lbCapital.setText("" + player.getSaldo());
    }

    public void desactivarOpciones() {
        btnFinalizarTurno.setDisable(true);
        btnMiCapital.setDisable(true);
        btnComprarPropi.setDisable(true);
        btnVerderPropi.setDisable(true);
        btnContruir.setDisable(true);
        btnHipotecar.setDisable(true);
        btnPagarHipoteca.setDisable(true);
        btnPagarDeudaMulta.setDisable(true);
    }

    public void activarOpciones() {
        btnFinalizarTurno.setDisable(false);
        btnMiCapital.setDisable(false);
        btnComprarPropi.setDisable(false);
        btnVerderPropi.setDisable(false);
        btnContruir.setDisable(false);
        btnHipotecar.setDisable(false);
        btnPagarHipoteca.setDisable(false);
        btnPagarDeudaMulta.setDisable(false);
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

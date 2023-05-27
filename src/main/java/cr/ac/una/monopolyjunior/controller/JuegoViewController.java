/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopolyjunior.model.Banca;
import cr.ac.una.monopolyjunior.model.Casilla;
import cr.ac.una.monopolyjunior.model.Dado;
import cr.ac.una.monopolyjunior.model.Estacion;
import cr.ac.una.monopolyjunior.model.Jugador;
import cr.ac.una.monopolyjunior.model.JugadorDto;
import cr.ac.una.monopolyjunior.model.ServicioPublico;
import cr.ac.una.monopolyjunior.model.Solar;
import cr.ac.una.monopolyjunior.model.TableroDto;
import cr.ac.una.monopolyjunior.service.JugadorService;
import cr.ac.una.monopolyjunior.service.PropiedadService;
import cr.ac.una.monopolyjunior.service.TableroService;
import cr.ac.una.monopolyjunior.util.FlowController;
import cr.ac.una.monopolyjunior.util.Respuesta;
import cr.ac.una.tarea.util.Mensaje;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
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
import javafx.scene.layout.VBox;
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
    @FXML
    private ImageView imgFichaTurno;

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;
    private static final int TILE_SIZE1 = 55;
    private static final int TILE_SIZE2 = 90;

    boolean turnoP1 = true;
    boolean turnoP2 = false;

    TableroDto tablero;
    Banca banca;
    Dado dado1;
    Dado dado2;
    int dadoTirado1;
    int dadoTirado2;

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
        imgLogo.setImage(new Image("cr/ac/una/monopolyjunior/resources/MonopolyLogo2.png"));
    }

    @Override
    public void initialize() {
    }

    public void crearTablero(String player1, String ficha1, String player2, String ficha2) {
        if (boardAnchor.getChildren().size() >= 2) {
            boardAnchor.getChildren().remove(1);
        }

        ImageView dadoImage1 = new ImageView(new Image("cr/ac/una/monopolyjunior/resources/dados/1.png"));
        dadoImage1.setPreserveRatio(true);
        dadoImage1.setFitHeight(180);
        ImageView dadoImage2 = new ImageView(new Image("cr/ac/una/monopolyjunior/resources/dados/1.png"));
        dadoImage2.setPreserveRatio(true);
        dadoImage2.setFitHeight(180);
        Label lbDadoTotal = new Label("0");
        lbDadoTotal.getStyleClass().add("juegoView-lbDadosTotal");
        JFXButton btnDados = new JFXButton("Lanzar Dados");
        btnDados.getStyleClass().add("juegoView-button");
        btnDados.setOnAction(event -> {
            JugadorDto player;
            String id;

            if (tablero.getJugadores().get(0).getNombre().equals(lbTurno.getText())) {
                player = tablero.getJugadores().get(0);
                id = "imgPlayer1";
            } else {
                player = tablero.getJugadores().get(1);
                id = "imgPlayer2";
            }
            btnDados.setDisable(true);
            Thread thread = new Thread() {
                public void run() {
                    System.out.println("Thread Running");
                    try {
                        for (int i = 0; i < 15; i++) {
                            dadoTirado1 = dado1.lanzar();
                            dadoTirado2 = dado2.lanzar();
//                            dadoTirado1 = 5;
//                            dadoTirado2 = 6;
                            String imagePath1 = "cr/ac/una/monopolyjunior/resources/dados/" + dadoTirado1 + ".png";
                            String imagePath2 = "cr/ac/una/monopolyjunior/resources/dados/" + dadoTirado2 + ".png";

                            Platform.runLater(() -> {
                                dadoImage1.setImage(new Image(imagePath1));
                                dadoImage2.setImage(new Image(imagePath2));
                                lbDadoTotal.setText("" + (dadoTirado1 + dadoTirado2));
                            });
                            Thread.sleep(50);
                        }
                        Platform.runLater(() -> {
                            moverFicha(dadoTirado1 + dadoTirado2, id, player);
                            accionCasilla(player);
                            translateAnimation(0.5, boardAnchor.getChildren().get(1), 2000);
                            activarOpciones();
                            btnDados.setDisable(false);
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        });

        HBox hboxDados = new HBox(dadoImage1, dadoImage2);
        hboxDados.setAlignment(Pos.CENTER);
        hboxDados.setSpacing(20);
        VBox vboxDados = new VBox(hboxDados, lbDadoTotal, btnDados);
        vboxDados.setAlignment(Pos.CENTER);
        vboxDados.setSpacing(20);
        StackPane stakPaneDados = new StackPane(vboxDados);
        stakPaneDados.setMinWidth(564);
        stakPaneDados.setMinHeight(564);
        stakPaneDados.setMaxWidth(564);
        stakPaneDados.setMaxHeight(564);
        boardAnchor.getChildren().add(stakPaneDados);

        JugadorDto jugador1 = new JugadorDto(player1, ficha1, 1500);
        JugadorDto jugador2 = new JugadorDto(player2, ficha2, 1500);
        tablero = new TableroDto(jugador1, jugador2);

        turnoP1 = true;
        turnoP2 = false;

        lbTurno.setText(tablero.getJugadores().get(0).getNombre());
        imgFichaTurno.setImage(new Image("cr/ac/una/monopolyjunior/resources/fichas/" + tablero.getJugadores().get(0).getFicha()));
        lbCapital.setText("" + tablero.getJugadores().get(0).getSaldo());

        banca = new Banca();
        dado1 = new Dado(6);
        dado2 = new Dado(6);

        StackPane node = null;
        for (Node child : boardPane.getChildren()) {
            node = (StackPane) child;
            node.getChildren().clear();
            if (GridPane.getRowIndex(child) == 8 || GridPane.getRowIndex(child) == 0) {
                HBox hbox = new HBox();
                node.getChildren().add(hbox);
            } else {
                VBox vbox = new VBox();
                node.getChildren().add(vbox);
            }
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
                if (new Mensaje().showConfirmation("Saldo Pendiente", getStage(), "Tienes un saldo pendiente, si continuas con el, te declaras en bancarrota, deseas continuar?")) {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Bancarrota", getStage(), "Te has declarado en bancarrota");
                    OpcionJugadorViewController opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                    opcionJugadorViewController.declararGanador(player, tablero);
                    getStage().close();
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", getStage(), true);
                } else {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Bancarrota", getStage(), "Recuerda pagar la deuda, si no seras declarado en bancarrota.");
                }
            } else {
                turnoP1 = false;
                turnoP2 = true;
                actualizarDatosInterfaz(player);
                translateAnimation(0.5, boardAnchor.getChildren().get(1), -2000);
                desactivarOpciones();
            }
        } else if (turnoP2) {
            player = tablero.getJugadores().get(0);
            if (tablero.player2Debe) {
                if (new Mensaje().showConfirmation("Saldo Pendiente", getStage(), "Tienes un saldo pendiente, si continuas con el, te declaras en bancarrota, deseas continuar?")) {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Bancarrota", getStage(), "Te has declarado en bancarrota");
                    OpcionJugadorViewController opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
                    opcionJugadorViewController.declararGanador(player, tablero);
                    getStage().close();
                    FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", getStage(), true);
                } else {
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Bancarrota", getStage(), "Recuerda pagar la deuda, si no seras declarado en bancarrota.");
                }
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
        JugadorDto player = null;
        if (turnoP1) {
            player = tablero.getJugadores().get(0);
        } else if (turnoP2) {
            player = tablero.getJugadores().get(1);
        }
        VenderViewController venderViewViewController = (VenderViewController) FlowController.getInstance().getController("VenderView");
        venderViewViewController.VenderPropiedades(tablero, player, banca);
        FlowController.getInstance().goViewInWindow("VenderView");
    }

    @FXML
    private void onActionBtnConstruir(ActionEvent event) {
        JugadorDto player = null;
        if (turnoP1) {
            player = tablero.getJugadores().get(0);
        } else if (turnoP2) {
            player = tablero.getJugadores().get(1);
        }
        tablero.puedeConstruir(player, getStage(), banca);
    }

    @FXML
    private void onActionBtnHipotecar(ActionEvent event) {
        JugadorDto player = null;
        if (turnoP1) {
            player = tablero.getJugadores().get(0);
        } else if (turnoP2) {
            player = tablero.getJugadores().get(1);
        }
        VenderViewController venderViewViewController = (VenderViewController) FlowController.getInstance().getController("VenderView");
        venderViewViewController.hipotecarPropiedades(tablero, player, banca);
        FlowController.getInstance().goViewInWindow("VenderView");
    }

    @FXML
    private void btnPagarHipoteca(ActionEvent event) {
        JugadorDto player = null;
        if (turnoP1) {
            player = tablero.getJugadores().get(0);
        } else if (turnoP2) {
            player = tablero.getJugadores().get(1);
        }
        VenderViewController venderViewViewController = (VenderViewController) FlowController.getInstance().getController("VenderView");
        venderViewViewController.pagarHipotecaPropiedades(tablero, player, banca);
        FlowController.getInstance().goViewInWindow("VenderView");
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
        JugadorDto player = null;
        if (tablero.getJugadores().get(0).getNombre().equals(lbTurno.getText())) {
            player = tablero.getJugadores().get(0);
        } else if (tablero.getJugadores().get(1).getNombre().equals(lbTurno.getText())) {
            player = tablero.getJugadores().get(1);
        }
        if (new Mensaje().showConfirmation("Finalizar Partida", getStage(), "¿Desea guardar la partida, si dice que no se finalizara la partida actual?")) {
            FlowController.getInstance().goMain();
            guardarPropiedades();
            guardarJugadores();
            guardarJugadores();
//            guardarPartida();
            getStage().close();
        } else {
            OpcionJugadorViewController opcionJugadorViewController = (OpcionJugadorViewController) FlowController.getInstance().getController("OpcionJugadorView");
            opcionJugadorViewController.declararGanador(player, tablero);
            getStage().close();
            FlowController.getInstance().goViewInWindowModal("OpcionJugadorView", getStage(), true);
        }
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
        if (posX >= 1 && posX <= 8 && posY == 8) {
            posX -= dadoTirado;
            if (posX < 0) {
                dadoTirado = posX * -1;
                posX = 0;
                posY -= dadoTirado;
                if (posY < 0) {
                    dadoTirado = posY * -1;
                    posY = 0;
                    posX += dadoTirado;
                }
            }
        } else if (posX == 0 && posY >= 1 && posY <= 8) {
            posY -= dadoTirado;
            if (posY < 0) {
                dadoTirado = posY * -1;
                posY = 0;
                posX += dadoTirado;
                if (posX > 8) {
                    dadoTirado = posX - 8;
                    posX = 8;
                    posY += dadoTirado;
                }
            }
        } else if (posX >= 0 && posX <= 7 && posY == 0) {
            posX += dadoTirado;
            if (posX > 8) {
                dadoTirado = posX - 8;
                posX = 8;
                posY += dadoTirado;
                if (posY > 8) {
                    pasaPorGo();
                }
                if (posY > 8) {
                    dadoTirado = posY - 8;
                    posY = 8;
                    posX -= dadoTirado;
                }
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
                if (posX < 0) {
                    dadoTirado = posX * -1;
                    posX = 0;
                    posY -= dadoTirado;
                }
            }
        }
        System.out.println(player.getNombre() + ": posx " + posX + " : posy " + posY);

//        posX = 8; // Ve a la Carcel
//        posY = 0; // Ve a la Carcel
//        posX = 0; // Impuesto
//        posY = 7; // Impuesto
        if (node != null) {
            ImageView imgFicha = null;
            for (Node child : node.getChildren()) {
                if (child instanceof ImageView && id.equals(child.getId())) {
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

    public void agregarCasaIntefaz(Solar solar) {
        Casilla casilla = tablero.getCasilla(solar.getNombre());
        int posX = casilla.getPosX();
        int posY = casilla.getPosY();

        StackPane node;
        for (Node child : boardPane.getChildren()) {
            if (GridPane.getColumnIndex(child) == posX && GridPane.getRowIndex(child) == posY) {
                node = (StackPane) child;
                if (GridPane.getRowIndex(child) == 8 || GridPane.getRowIndex(child) == 0) {
                    HBox hbox = (HBox) node.getChildren().get(0);
                    ImageView imgCasa = new ImageView(new Image("cr/ac/una/monopolyjunior/resources/Casa.png"));
                    imgCasa.setPreserveRatio(false);
                    imgCasa.setFitHeight(13);
                    imgCasa.setFitWidth(13);
                    hbox.getChildren().add(imgCasa);
                } else {
                    VBox vbox = (VBox) node.getChildren().get(0);
                    ImageView imgCasa = new ImageView(new Image("cr/ac/una/monopolyjunior/resources/Casa.png"));
                    imgCasa.setPreserveRatio(false);
                    imgCasa.setFitHeight(13);
                    imgCasa.setFitWidth(13);
                    vbox.getChildren().add(imgCasa);
                }
                break;
            }
        }

    }

    public void demolerCasaIntefaz(Solar solar) {
        Casilla casilla = tablero.getCasilla(solar.getNombre());
        int posX = casilla.getPosX();
        int posY = casilla.getPosY();

        StackPane node;
        for (Node child : boardPane.getChildren()) {
            if (GridPane.getColumnIndex(child) == posX && GridPane.getRowIndex(child) == posY) {
                node = (StackPane) child;
                if (GridPane.getRowIndex(child) == 8 || GridPane.getRowIndex(child) == 0) {
                    HBox hbox = (HBox) node.getChildren().get(0);
                    hbox.getChildren().remove(0);
                } else {
                    VBox vbox = (VBox) node.getChildren().get(0);
                    vbox.getChildren().remove(0);
                }
                break;
            }
        }
    }

    public void agregarHotelIntefaz(Solar solar) {
        Casilla casilla = tablero.getCasilla(solar.getNombre());
        int posX = casilla.getPosX();
        int posY = casilla.getPosY();

        StackPane node;
        for (Node child : boardPane.getChildren()) {
            if (GridPane.getColumnIndex(child) == posX && GridPane.getRowIndex(child) == posY) {
                node = (StackPane) child;
                if (GridPane.getRowIndex(child) == 8 || GridPane.getRowIndex(child) == 0) {
                    HBox hbox = (HBox) node.getChildren().get(0);
                    hbox.getChildren().clear();
                    ImageView imgCasa = new ImageView(new Image("cr/ac/una/monopolyjunior/resources/Hotel.png"));
                    imgCasa.setPreserveRatio(false);
                    imgCasa.setFitHeight(13);
                    imgCasa.setFitWidth(13);
                    hbox.getChildren().add(imgCasa);
                } else {
                    VBox vbox = (VBox) node.getChildren().get(0);
                    vbox.getChildren().clear();
                    ImageView imgCasa = new ImageView(new Image("cr/ac/una/monopolyjunior/resources/Hotel.png"));
                    imgCasa.setPreserveRatio(false);
                    imgCasa.setFitHeight(13);
                    imgCasa.setFitWidth(13);
                    vbox.getChildren().add(imgCasa);
                }
                break;
            }
        }

    }

    public void demolerHotelIntefaz(Solar solar) {
        Casilla casilla = tablero.getCasilla(solar.getNombre());
        int posX = casilla.getPosX();
        int posY = casilla.getPosY();

        StackPane node;
        for (Node child : boardPane.getChildren()) {
            if (GridPane.getColumnIndex(child) == posX && GridPane.getRowIndex(child) == posY) {
                node = (StackPane) child;
                if (GridPane.getRowIndex(child) == 8 || GridPane.getRowIndex(child) == 0) {
                    HBox hbox = (HBox) node.getChildren().get(0);
                    hbox.getChildren().remove(0);
                    for (int i = 0; i < 4; i++) {
                        ImageView imgCasa = new ImageView(new Image("cr/ac/una/monopolyjunior/resources/Casa.png"));
                        imgCasa.setPreserveRatio(false);
                        imgCasa.setFitHeight(13);
                        imgCasa.setFitWidth(13);
                        hbox.getChildren().add(imgCasa);
                    }
                } else {
                    VBox vbox = (VBox) node.getChildren().get(0);
                    vbox.getChildren().remove(0);
                    for (int i = 0; i < 4; i++) {
                        ImageView imgCasa = new ImageView(new Image("cr/ac/una/monopolyjunior/resources/Casa.png"));
                        imgCasa.setPreserveRatio(false);
                        imgCasa.setFitHeight(13);
                        imgCasa.setFitWidth(13);
                        vbox.getChildren().add(imgCasa);
                    }
                }
                break;
            }
        }
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
        String tipo = tablero.getCasillaActual(jugador).getTipo();
        switch (tipo) {
            case "Solar":
                Solar solar = tablero.getPropiedadSolar(casilla.getNombre());
                if (solar.getPropietario() == null) {
                    accionCasilla(jugador);
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Comprar Propiedad", getStage(), "La propiedad ya tiene un dueño.");
                }
                break;
            case "Servicio Publico":
                ServicioPublico servicio = tablero.getPropiedadServicio(casilla.getNombre());
                if (servicio.getPropietario() == null) {
                    accionCasilla(jugador);
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Comprar Propiedad", getStage(), "La propiedad ya tiene un dueño.");
                }
                break;
            case "Estacion":
                Estacion estacion = tablero.getPropiedadEstacion(casilla.getNombre());
                if (estacion.getPropietario() == null) {
                    accionCasilla(jugador);
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Comprar Propiedad", getStage(), "La propiedad ya tiene un dueño.");
                }
                break;
            default:
                new Mensaje().showModal(Alert.AlertType.ERROR, "Comprar Propiedad", getStage(), "No es posible comprar esto.");
        }
    }

    public void accionCasilla(JugadorDto jugador) {
        Casilla casilla = tablero.getCasillaActual(jugador);
        casilla.accion(jugador, banca, tablero, getStage(), dadoTirado1 + dadoTirado2);
        actualizarDatosInterfaz(jugador);
        System.out.println("Jugador " + jugador.getNombre() + " : En la casilla " + casilla.getNombre());
    }

    public void actualizarDatosInterfaz(JugadorDto player) {
        imgFichaTurno.setImage(new Image("cr/ac/una/monopolyjunior/resources/fichas/" + player.getFicha()));
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

    public void guardarPartida() {
        try {
            TableroService service = new TableroService();
            Respuesta respuesta = service.guardarTablero(tablero);
            if (!respuesta.getEstado()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar tablero", getStage(), respuesta.getMensaje());
            } else {
                tablero = (TableroDto) respuesta.getResultado("Tablero");
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar tablero", getStage(), "Tablero actualizado correctamente.");
            }
        } catch (Exception ex) {
            Logger.getLogger(JuegoViewController.class.getName()).log(Level.SEVERE, "Error guardando el Tablero.", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar tablero", getStage(), "Ocurrio un error guardando el Tablero.");
        }
    }

    public void guardarJugadores() {
        for(int i = 0; i < tablero.getJugadores().size(); i++) {
            try {
                JugadorDto jug = tablero.getJugadores().get(i);
                JugadorService service = new JugadorService();
                Respuesta respuesta = service.guardarJugador(jug, tablero);
                if (!respuesta.getEstado()) {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar jugador", getStage(), respuesta.getMensaje());
                } else {
                    jug = (JugadorDto) respuesta.getResultado("Jugador");
                    tablero.getJugadores().get(i).setId(jug.getId());
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar jugador", getStage(), "Jugador actualizado correctamente.");
                }
            } catch (Exception ex) {
                Logger.getLogger(JuegoViewController.class.getName()).log(Level.SEVERE, "Error guardando el jugador.", ex);
                new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar jugador", getStage(), "Ocurrio un error guardando el jugador.");
            }
        }
    }

    public void guardarPropiedades() {
        for(int i = 0; i < tablero.getPropiedadesSolar().size(); i++) {
            try {
                Solar solar = tablero.getPropiedadesSolar().get(i);
                if (solar.tienePropietario()) {
                    PropiedadService service = new PropiedadService();
                    Respuesta respuesta = service.guardarSolar(solar);
                    if (!respuesta.getEstado()) {
                        new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Solar", getStage(), respuesta.getMensaje());
                    } else {
                        solar = (Solar) respuesta.getResultado("Solar");
                        tablero.getPropiedadesSolar().get(i).setId(solar.getId());
                        new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar Solar", getStage(), "Solar actualizado correctamente.");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(JuegoViewController.class.getName()).log(Level.SEVERE, "Error guardando el Solar.", ex);
                new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Solar", getStage(), "Ocurrio un error guardando el Solar.");
            }
        }
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

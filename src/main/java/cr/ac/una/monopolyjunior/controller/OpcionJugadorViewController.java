/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopolyjunior.model.Banca;
import cr.ac.una.monopolyjunior.model.Estacion;
import cr.ac.una.monopolyjunior.model.JugadorDto;
import cr.ac.una.monopolyjunior.model.PropiedadDto;
import cr.ac.una.monopolyjunior.model.ServicioPublico;
import cr.ac.una.monopolyjunior.model.Solar;
import cr.ac.una.monopolyjunior.model.TableroDto;
import cr.ac.una.monopolyjunior.model.Tarjeta;
import cr.ac.una.monopolyjunior.util.FlowController;
import cr.ac.una.tarea.util.Mensaje;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class OpcionJugadorViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane rootOpcionJugadorView;

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

    public void comprarPropiedadInterfaz(JugadorDto jugador, Banca banca, PropiedadDto propiedad) {
        rootOpcionJugadorView.getChildren().clear();

        Solar prop = (Solar) propiedad;

        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(200);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        VBox cartaPropiedad = new VBox();
        cartaPropiedad.getStyleClass().add("carta-contenedor");

        VBox vboxTitulo = new VBox();
        vboxTitulo.getStyleClass().add("carta-contenedorTitulo");
        VBox.setMargin(vboxTitulo, new Insets(5, 0, 5, 0));
        vboxTitulo.setAlignment(Pos.CENTER);
        switch (prop.getColor()) {
            case "Azul":
                vboxTitulo.getStyleClass().add("carta-contenedorTituloAzul");
                break;
            case "Amarillo":
                vboxTitulo.getStyleClass().add("carta-contenedorTituloAmarillo");
                break;
            case "Rojo":
                vboxTitulo.getStyleClass().add("carta-contenedorTituloRojo");
                break;
            case "Verde":
                vboxTitulo.getStyleClass().add("carta-contenedorTituloVerde");
                break;
            default:
                throw new AssertionError();
        }
        Label lbTituloPropiedad = new Label("Solar");
        lbTituloPropiedad.getStyleClass().add("carta-lbTituloPropiedad");
        Label lbPropiedadNombre = new Label(prop.getNombre());
        lbPropiedadNombre.getStyleClass().add("carta-lbNombrePropiedad");
        vboxTitulo.getChildren().addAll(lbTituloPropiedad, lbPropiedadNombre);

        Label lbAlquiler = new Label("Alquiler:");
        lbAlquiler.getStyleClass().add("carta-lbTitulo");

        Label lbSola = new Label("Solar sin edificar");
        HBox hboxSola1 = new HBox(lbSola);
        Label lbSolaAlquiler = new Label("$" + prop.getRenta());
        HBox hboxSola2 = new HBox(lbSolaAlquiler);
        HBox.setHgrow(hboxSola2, Priority.ALWAYS);
        hboxSola2.setAlignment(Pos.CENTER_RIGHT);
        hboxSola2.getStyleClass().add("carta-lbRenta");
        HBox hboxSola = new HBox(hboxSola1, hboxSola2);

        Label lb1Casa = new Label("Con 1 casa");
        HBox hbox1Casa1 = new HBox(lb1Casa);
        Label lb1CasaAlquiler = new Label("$" + prop.getRenta1Casa());
        HBox hbox1Casa2 = new HBox(lb1CasaAlquiler);
        HBox.setHgrow(hbox1Casa2, Priority.ALWAYS);
        hbox1Casa2.setAlignment(Pos.CENTER_RIGHT);
        hbox1Casa2.getStyleClass().add("carta-lbRenta");
        HBox hbox1Casa = new HBox(hbox1Casa1, hbox1Casa2);

        Label lb2Casa = new Label("Con 2 casas");
        HBox hbox2Casa1 = new HBox(lb2Casa);
        Label lb2CasaAlquiler = new Label("$" + prop.getRenta2Casa());
        HBox hbox2Casa2 = new HBox(lb2CasaAlquiler);
        HBox.setHgrow(hbox2Casa2, Priority.ALWAYS);
        hbox2Casa2.setAlignment(Pos.CENTER_RIGHT);
        hbox2Casa2.getStyleClass().add("carta-lbRenta");
        HBox hbox2Casa = new HBox(hbox2Casa1, hbox2Casa2);

        Label lb3Casa = new Label("Con 3 casas");
        HBox hbox3Casa1 = new HBox(lb3Casa);
        Label lb3CasaAlquiler = new Label("$" + prop.getRenta3Casa());
        HBox hbox3Casa2 = new HBox(lb3CasaAlquiler);
        HBox.setHgrow(hbox3Casa2, Priority.ALWAYS);
        hbox3Casa2.setAlignment(Pos.CENTER_RIGHT);
        hbox3Casa2.getStyleClass().add("carta-lbRenta");
        HBox hbox3Casa = new HBox(hbox3Casa1, hbox3Casa2);

        Label lb4Casa = new Label("Con 4 casas");
        HBox hbox4Casa1 = new HBox(lb4Casa);
        Label lb4CasaAlquiler = new Label("$" + prop.getRenta4Casa());
        HBox hbox4Casa2 = new HBox(lb4CasaAlquiler);
        HBox.setHgrow(hbox4Casa2, Priority.ALWAYS);
        hbox4Casa2.setAlignment(Pos.CENTER_RIGHT);
        hbox4Casa2.getStyleClass().add("carta-lbRenta");
        HBox hbox4Casa = new HBox(hbox4Casa1, hbox4Casa2);

        Label lbHotel = new Label("Con Hotel");
        HBox hboxHotel1 = new HBox(lbHotel);
        Label lbHotelAlquiler = new Label("$" + prop.getRentaHotel());
        HBox hboxHotel2 = new HBox(lbHotelAlquiler);
        HBox.setHgrow(hboxHotel2, Priority.ALWAYS);
        hboxHotel2.setAlignment(Pos.CENTER_RIGHT);
        hboxHotel2.getStyleClass().add("carta-lbRenta");
        HBox hboxHotel = new HBox(hboxHotel1, hboxHotel2);

        VBox vboxAlquiler = new VBox(hboxSola, hbox1Casa, hbox2Casa, hbox3Casa, hbox4Casa, hboxHotel);
        VBox.setMargin(vboxAlquiler, new Insets(0, 40, 0, 0));

        Label lbInfo = new Label("Si un jugador posee todas las propiedades de un mismo color el precio de alquiler se duplica");
        lbInfo.setWrapText(true);
        lbInfo.getStyleClass().add("carta-lbDescripcion");

        Separator separator1 = new Separator();

        Label lbPrecioConstruc = new Label("Precio de construcción:");
        lbPrecioConstruc.getStyleClass().add("carta-lbTitulo");

        Label lbCostoXCasa = new Label("Costo x Casa");
        HBox hboxCostoXCasa1 = new HBox(lbCostoXCasa);
        Label lbCostoXCasaAlquiler = new Label("$100 c/u");
        HBox hboxCostoXCasa2 = new HBox(lbCostoXCasaAlquiler);
        HBox.setHgrow(hboxCostoXCasa2, Priority.ALWAYS);
        hboxCostoXCasa2.setAlignment(Pos.CENTER_RIGHT);
        hboxCostoXCasa2.getStyleClass().add("carta-lbRenta");
        HBox hboxCostoXCasa = new HBox(hboxCostoXCasa1, hboxCostoXCasa2);

        Label lbCostoXHotel = new Label("Costo x Hotel");
        HBox hboxCostoXHotel1 = new HBox(lbCostoXHotel);
        Label lbCostoXHotelAlquiler = new Label("$400 c/u");
        HBox hboxCostoXHotel2 = new HBox(lbCostoXHotelAlquiler);
        HBox.setHgrow(hboxCostoXHotel2, Priority.ALWAYS);
        hboxCostoXHotel2.setAlignment(Pos.CENTER_RIGHT);
        hboxCostoXHotel2.getStyleClass().add("carta-lbRenta");
        HBox hboxCostoXHotel = new HBox(hboxCostoXHotel1, hboxCostoXHotel2);

        VBox vboxPrecioConstruc = new VBox(hboxCostoXCasa, hboxCostoXHotel);
        VBox.setMargin(vboxPrecioConstruc, new Insets(0, 40, 0, 0));

        Separator separator2 = new Separator();

        Label lbValorHipo = new Label("Valor Hipotecario   $" + prop.getValorHipoteca());
        lbValorHipo.getStyleClass().add("carta-lbTitulo");
        lbValorHipo.setAlignment(Pos.CENTER);

        cartaPropiedad.getChildren().addAll(vboxTitulo, lbAlquiler, vboxAlquiler, lbInfo, separator1, lbPrecioConstruc, vboxPrecioConstruc, separator2, lbValorHipo);

        JFXButton btnComprar = new JFXButton("Comprar");
        btnComprar.getStyleClass().add("carta-button");
        btnComprar.setOnAction(event -> {
            if (new Mensaje().showConfirmation("Comprar Propiedad", getStage(), "¿Esta seguro que desea comprar " + prop.getNombre() + " por un valor de $" + prop.getPrecioCompra() + "?")) {
                if (jugador.getSaldo() >= prop.getPrecioCompra()) {
                    banca.venderPropiedad(jugador, propiedad);
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Comprar Propiedad", getStage(), "Compra realizada exitosamente.");
                    getStage().close();
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Comprar Propiedad", getStage(), "Saldo insuficiente para realizar la compra.");
                }
            }
        });
        JFXButton btnNoComprar = new JFXButton("No Comprar");
        btnNoComprar.getStyleClass().add("carta-button");
        btnNoComprar.setOnAction(event -> {
            getStage().close();
        });
        HBox hboxOpciones = new HBox(btnComprar, btnNoComprar);
        VBox.setMargin(hboxOpciones, new Insets(10, 0, 20, 0));
        hboxOpciones.setSpacing(10);
        hboxOpciones.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(cartaPropiedad, hboxOpciones);
        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);
    }

    public void comprarServicioPublicoInterfaz(JugadorDto jugador, Banca banca, PropiedadDto propiedad) {
        rootOpcionJugadorView.getChildren().clear();

        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(200);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        VBox cartaPropiedad = new VBox();
        cartaPropiedad.getStyleClass().add("carta-contenedor");

        VBox vboxTitulo = new VBox();
        vboxTitulo.getStyleClass().add("carta-contenedorTitulo");
        VBox.setMargin(vboxTitulo, new Insets(0, 0, 10, 0));
        vboxTitulo.setAlignment(Pos.CENTER);

        Label lbTituloPropiedad = new Label("Servicio Publico");
        lbTituloPropiedad.getStyleClass().add("carta-lbTituloPropiedad");
        Label lbPropiedadNombre = new Label(propiedad.getNombre());
        lbPropiedadNombre.getStyleClass().add("carta-lbTituloPropiedad");
        vboxTitulo.getChildren().addAll(lbTituloPropiedad, lbPropiedadNombre);

        Separator separator1 = new Separator();

        Label lbAlquiler = new Label("Renta:");
        lbAlquiler.getStyleClass().add("carta-lbTitulo");

        Label lb1Servicio = new Label("1 Servicio:");
        lb1Servicio.getStyleClass().add("carta-lbTitulo");
        Label lb1ServicioDes = new Label("10 veces el número que obtenido con los dados");
        lb1ServicioDes.setWrapText(true);
        VBox vbox1Servicio = new VBox(lb1Servicio, lb1ServicioDes);
        VBox.setMargin(vbox1Servicio, new Insets(0, 0, 20, 0));

        Label lb2Servicio = new Label("2 Servicios:");
        lb2Servicio.getStyleClass().add("carta-lbTitulo");
        Label lb2ServicioDes = new Label("20 veces el número que obtenido con los dados");
        lb2ServicioDes.setWrapText(true);
        VBox vbox2Servicio = new VBox(lb2Servicio, lb2ServicioDes);
        VBox.setMargin(vbox2Servicio, new Insets(0, 0, 20, 0));

        VBox vboxAlquiler = new VBox(vbox1Servicio, vbox2Servicio);

        Separator separator2 = new Separator();

        Label lbValorHipo = new Label("Valor Hipotecario   $" + propiedad.getValorHipoteca());
        lbValorHipo.getStyleClass().add("carta-lbTitulo");
        lbValorHipo.setAlignment(Pos.CENTER);

        cartaPropiedad.getChildren().addAll(vboxTitulo, separator1, lbAlquiler, vboxAlquiler, separator2, lbValorHipo);

        JFXButton btnComprar = new JFXButton("Comprar");
        btnComprar.getStyleClass().add("carta-button");
        btnComprar.setOnAction(event -> {
            if (new Mensaje().showConfirmation("Comprar Propiedad", getStage(), "¿Esta seguro que desea comprar " + propiedad.getNombre() + " por un valor de $" + propiedad.getPrecioCompra() + "?")) {
                if (jugador.getSaldo() >= propiedad.getPrecioCompra()) {
                    banca.venderPropiedad(jugador, propiedad);
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Comprar Propiedad", getStage(), "Compra realizada exitosamente.");
                    getStage().close();
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Comprar Propiedad", getStage(), "Saldo insuficiente para realizar la compra.");
                }
            }
        });
        JFXButton btnNoComprar = new JFXButton("No Comprar");
        btnNoComprar.getStyleClass().add("carta-button");
        btnNoComprar.setOnAction(event -> {
            getStage().close();
        });
        HBox hboxOpciones = new HBox(btnComprar, btnNoComprar);
        VBox.setMargin(hboxOpciones, new Insets(10, 0, 20, 0));
        hboxOpciones.setSpacing(10);
        hboxOpciones.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(cartaPropiedad, hboxOpciones);
        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);
    }

    public void comprarEstacionInterfaz(JugadorDto jugador, Banca banca, PropiedadDto propiedad) {
        rootOpcionJugadorView.getChildren().clear();

        Estacion prop = (Estacion) propiedad;

        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(200);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        VBox cartaPropiedad = new VBox();
        cartaPropiedad.getStyleClass().add("carta-contenedor");

        VBox vboxTitulo = new VBox();
        vboxTitulo.getStyleClass().add("carta-contenedorTitulo");
        VBox.setMargin(vboxTitulo, new Insets(5, 0, 5, 0));
        vboxTitulo.setAlignment(Pos.CENTER);
        Label lbTituloPropiedad = new Label("Estacion");
        lbTituloPropiedad.getStyleClass().add("carta-lbTituloPropiedad");
        Label lbPropiedadNombre = new Label(prop.getNombre());
        lbPropiedadNombre.getStyleClass().add("carta-lbTituloPropiedad");
        vboxTitulo.getChildren().addAll(lbTituloPropiedad, lbPropiedadNombre);

        Separator separator1 = new Separator();

        Label lbAlquiler = new Label("Renta:");
        lbAlquiler.getStyleClass().add("carta-lbTitulo");

        Label lb1Estacion = new Label("Con 1 estacion");
        HBox hbox1Estacion1 = new HBox(lb1Estacion);
        Label lb1EstacionAlquiler = new Label("$" + prop.getRenta());
        HBox hbox1Estacion2 = new HBox(lb1EstacionAlquiler);
        HBox.setHgrow(hbox1Estacion2, Priority.ALWAYS);
        hbox1Estacion2.setAlignment(Pos.CENTER_RIGHT);
        hbox1Estacion2.getStyleClass().add("carta-lbRenta");
        HBox hbox1Estacion = new HBox(hbox1Estacion1, hbox1Estacion2);

        Label lb2Estacion = new Label("Con 2 estaciones");
        HBox hbox2Estacion1 = new HBox(lb2Estacion);
        Label lb2EstacionAlquiler = new Label("$" + prop.getRenta2Estaciones());
        HBox hbox2Estacion2 = new HBox(lb2EstacionAlquiler);
        HBox.setHgrow(hbox2Estacion2, Priority.ALWAYS);
        hbox2Estacion2.setAlignment(Pos.CENTER_RIGHT);
        hbox2Estacion2.getStyleClass().add("carta-lbRenta");
        HBox hbox2Estacion = new HBox(hbox2Estacion1, hbox2Estacion2);

        Label lb3Estacion = new Label("Con 3 estaciones");
        HBox hbox3Estacion1 = new HBox(lb3Estacion);
        Label lb3EstacionAlquiler = new Label("$" + prop.getRenta3Estaciones());
        HBox hbox3Estacion2 = new HBox(lb3EstacionAlquiler);
        HBox.setHgrow(hbox3Estacion2, Priority.ALWAYS);
        hbox3Estacion2.setAlignment(Pos.CENTER_RIGHT);
        hbox3Estacion2.getStyleClass().add("carta-lbRenta");
        HBox hbox3Estacion = new HBox(hbox3Estacion1, hbox3Estacion2);

        Label lb4Estacion = new Label("Con 4 estaciones");
        HBox hbox4Estacion1 = new HBox(lb4Estacion);
        Label lb4EstacionAlquiler = new Label("$" + prop.getRenta4Estaciones());
        HBox hbox4Estacion2 = new HBox(lb4EstacionAlquiler);
        HBox.setHgrow(hbox4Estacion2, Priority.ALWAYS);
        hbox4Estacion2.setAlignment(Pos.CENTER_RIGHT);
        hbox4Estacion2.getStyleClass().add("carta-lbRenta");
        HBox hbox4Estacion = new HBox(hbox4Estacion1, hbox4Estacion2);

        VBox vboxAlquiler = new VBox(hbox1Estacion, hbox2Estacion, hbox3Estacion, hbox4Estacion);
        VBox.setMargin(vboxAlquiler, new Insets(0, 0, 40, 0));

        Separator separator2 = new Separator();

        Label lbValorHipo = new Label("Valor Hipotecario   $" + prop.getValorHipoteca());
        lbValorHipo.getStyleClass().add("carta-lbTitulo");
        lbValorHipo.setAlignment(Pos.CENTER);

        cartaPropiedad.getChildren().addAll(vboxTitulo, separator1, lbAlquiler, vboxAlquiler, separator2, lbValorHipo);

        JFXButton btnComprar = new JFXButton("Comprar");
        btnComprar.getStyleClass().add("carta-button");
        btnComprar.setOnAction(event -> {
            if (new Mensaje().showConfirmation("Comprar Propiedad", getStage(), "¿Esta seguro que desea comprar " + prop.getNombre() + " por un valor de $" + propiedad.getPrecioCompra() + "?")) {
                if (jugador.getSaldo() >= prop.getPrecioCompra()) {
                    banca.venderPropiedad(jugador, propiedad);
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Comprar Propiedad", getStage(), "Compra realizada exitosamente.");
                    getStage().close();
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Comprar Propiedad", getStage(), "Saldo insuficiente para realizar la compra.");
                }
            }
        });
        JFXButton btnNoComprar = new JFXButton("No Comprar");
        btnNoComprar.getStyleClass().add("carta-button");
        btnNoComprar.setOnAction(event -> {
            getStage().close();
        });
        HBox hboxOpciones = new HBox(btnComprar, btnNoComprar);
        VBox.setMargin(hboxOpciones, new Insets(10, 0, 20, 0));
        hboxOpciones.setSpacing(10);
        hboxOpciones.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(cartaPropiedad, hboxOpciones);
        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);
    }

    public void miCapitalInterfaz(JugadorDto jugador, TableroDto tablero) {
        rootOpcionJugadorView.getChildren().clear();

        StackPane stackPane = new StackPane();
        VBox vbox = new VBox();
        TableView tbvPropiedades = new TableView();

        tbvPropiedades.getColumns().clear();
        tbvPropiedades.getItems().clear();

        TableColumn<PropiedadDto, String> tbcNombre = new TableColumn<>("Nombre");
        tbcNombre.setPrefWidth(150);
        tbcNombre.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getNombre()));

        TableColumn<PropiedadDto, String> tbcRenta = new TableColumn<>("Renta");
        tbcRenta.setPrefWidth(100);
        tbcRenta.setCellValueFactory(cd -> new SimpleStringProperty("" + cd.getValue().getRenta()));

        tbvPropiedades.getColumns().add(tbcNombre);
        tbvPropiedades.getColumns().add(tbcRenta);
        tbvPropiedades.refresh();

        tbvPropiedades.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Verifica si es un solo clic
                PropiedadDto propiedadSeleccionada = (PropiedadDto) tbvPropiedades.getSelectionModel().getSelectedItem();
                if (propiedadSeleccionada != null) {
                    if (propiedadSeleccionada instanceof Solar) {
                        CartaViewController cartaViewController = (CartaViewController) FlowController.getInstance().getController("CartaView");
                        cartaViewController.solarInterfaz(propiedadSeleccionada);
                        FlowController.getInstance().goViewInWindowModal("CartaView", getStage(), false);
                    } else if (propiedadSeleccionada instanceof ServicioPublico) {
                        CartaViewController cartaViewController = (CartaViewController) FlowController.getInstance().getController("CartaView");
                        cartaViewController.servicioPublicoInterfaz(propiedadSeleccionada);
                        FlowController.getInstance().goViewInWindowModal("CartaView", getStage(), false);
                    } else if (propiedadSeleccionada instanceof Estacion) {
                        CartaViewController cartaViewController = (CartaViewController) FlowController.getInstance().getController("CartaView");
                        cartaViewController.estacionInterfaz(propiedadSeleccionada);
                        FlowController.getInstance().goViewInWindowModal("CartaView", getStage(), false);
                    }
                }
            }
        });

        vbox.getChildren().add(tbvPropiedades);
        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);

        cargarPropiedades(tbvPropiedades, jugador, tablero);
    }

    public void ImpuestoInterfaz(int impuesto, JugadorDto jugador, Banca banca, TableroDto tablero) {
        rootOpcionJugadorView.getChildren().clear();

        for (int i = 0; i < tablero.getJugadores().size(); i++) {
            if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                tablero.player1Debe = true;
            } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                tablero.player2Debe = true;
            }
        }

        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(200);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        VBox cartaPropiedad = new VBox();
        cartaPropiedad.getStyleClass().add("carta-contenedor");

        VBox vboxTitulo = new VBox();
        vboxTitulo.getStyleClass().add("carta-contenedorTitulo");
        VBox.setMargin(vboxTitulo, new Insets(5, 0, 5, 0));
        vboxTitulo.setAlignment(Pos.CENTER);
        Label lbTituloPropiedad = new Label("Impuesto");
        lbTituloPropiedad.getStyleClass().add("carta-lbTituloPropiedad");
        vboxTitulo.getChildren().addAll(lbTituloPropiedad);

        Label lbInfo = new Label("Debes pagar un impuesto de $" + impuesto);
        lbInfo.setWrapText(true);

        cartaPropiedad.getChildren().addAll(vboxTitulo, lbInfo);

        JFXButton btnPagar = new JFXButton("Pagar");
        btnPagar.getStyleClass().add("carta-button");
        btnPagar.setOnAction(event -> {
            if (jugador.getSaldo() >= impuesto) {
                banca.cobrarImpuesto(190, jugador);
                for (int i = 0; i < tablero.getJugadores().size(); i++) {
                    if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                        tablero.player1Debe = false;
                    } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                        tablero.player2Debe = false;
                    }
                }
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Impuesto", getStage(), "Impuesto pagado exitosamente.");
                getStage().close();
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Impuesto", getStage(), "Saldo insuficiente para pagar el Impuesto.");
            }
        });
        JFXButton btnEsperar = new JFXButton("Esperar");
        btnEsperar.getStyleClass().add("carta-button");
        btnEsperar.setOnAction(event -> {
            for (int i = 0; i < tablero.getJugadores().size(); i++) {
                if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                    tablero.player1Debe = true;
                } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                    tablero.player2Debe = true;
                }
            }
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Impuesto", getStage(), "Recuerda pagar el Impuesto, si no seras declarado en bancarrota.");
            getStage().close();
        });
        HBox hboxOpciones = new HBox(btnPagar, btnEsperar);
        VBox.setMargin(hboxOpciones, new Insets(10, 0, 20, 0));
        hboxOpciones.setSpacing(10);
        hboxOpciones.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(cartaPropiedad, hboxOpciones);
        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);
    }

    public void CarcelInterfaz(JugadorDto jugador, TableroDto tablero) {
        rootOpcionJugadorView.getChildren().clear();

        for (int i = 0; i < tablero.getJugadores().size(); i++) {
            if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                tablero.player1Debe = true;
            } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                tablero.player2Debe = true;
            }
        }

        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(200);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        VBox cartaPropiedad = new VBox();
        cartaPropiedad.getStyleClass().add("carta-contenedor");

        VBox vboxTitulo = new VBox();
        vboxTitulo.getStyleClass().add("carta-contenedorTitulo");
        VBox.setMargin(vboxTitulo, new Insets(5, 0, 5, 0));
        vboxTitulo.setAlignment(Pos.CENTER);
        Label lbTituloPropiedad = new Label("Carcel");
        lbTituloPropiedad.getStyleClass().add("carta-lbTituloPropiedad");
        vboxTitulo.getChildren().addAll(lbTituloPropiedad);

        Random random = new Random();
        int multa = random.nextInt(300) + 20;

        Label lbInfo = new Label("Te encuentras en la carcel debes pagar $" + multa);
        lbInfo.setWrapText(true);
        Label lbInfo2 = new Label("(Si no pagas la multa ya, el monto vuelve a cambiar)");
        lbInfo2.setWrapText(true);

        cartaPropiedad.getChildren().addAll(vboxTitulo, lbInfo, lbInfo2);

        JFXButton btnPagar = new JFXButton("Pagar");
        btnPagar.getStyleClass().add("carta-button");
        btnPagar.setOnAction(event -> {
            if (jugador.getSaldo() >= multa) {
                jugador.pagar(multa);
                for (int i = 0; i < tablero.getJugadores().size(); i++) {
                    if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                        tablero.player1Debe = false;
                    } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                        tablero.player2Debe = false;
                    }
                }
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Carcel", getStage(), "Multa pagada exitosamente.");
                getStage().close();
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Carcel", getStage(), "Saldo insuficiente para pagar la multa.");
            }
        });
        JFXButton btnEsperar = new JFXButton("Esperar");
        btnEsperar.getStyleClass().add("carta-button");
        btnEsperar.setOnAction(event -> {
            for (int i = 0; i < tablero.getJugadores().size(); i++) {
                if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                    tablero.player1Debe = true;
                } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                    tablero.player2Debe = true;
                }
            }
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Carcel", getStage(), "Recuerda pagar la multa, si no seras declarado en bancarrota.");
            getStage().close();
        });
        HBox hboxOpciones = new HBox(btnPagar, btnEsperar);
        VBox.setMargin(hboxOpciones, new Insets(10, 0, 20, 0));
        hboxOpciones.setSpacing(10);
        hboxOpciones.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(cartaPropiedad, hboxOpciones);
        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);
    }

    public void rentaSolarInterfaz(JugadorDto jugador, TableroDto tablero, String nombre) {
        rootOpcionJugadorView.getChildren().clear();

        for (int i = 0; i < tablero.getJugadores().size(); i++) {
            if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                tablero.player1Debe = true;
            } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                tablero.player2Debe = true;
            }
        }

        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(200);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        VBox cartaPropiedad = new VBox();
        cartaPropiedad.getStyleClass().add("carta-contenedor");

        VBox vboxTitulo = new VBox();
        vboxTitulo.getStyleClass().add("carta-contenedorTitulo");
        VBox.setMargin(vboxTitulo, new Insets(5, 0, 5, 0));
        vboxTitulo.setAlignment(Pos.CENTER);
        Label lbTituloPropiedad = new Label("Renta");
        lbTituloPropiedad.getStyleClass().add("carta-lbTituloPropiedad");
        vboxTitulo.getChildren().addAll(lbTituloPropiedad);

        int renta = tablero.getPropiedadSolar(nombre).calcularRenta();

        Label lbInfo = new Label("Te encuentras en propiedad ajena debes pagar $" + renta);
        lbInfo.setWrapText(true);

        cartaPropiedad.getChildren().addAll(vboxTitulo, lbInfo);

        JFXButton btnPagar = new JFXButton("Pagar");
        btnPagar.getStyleClass().add("carta-button");
        btnPagar.setOnAction(event -> {
            if (jugador.getSaldo() >= renta) {
                jugador.pagar(renta);
                if (tablero.getPropiedadSolar(nombre).isHipotecada()) {
                    System.out.println("Propiedad Hipotecada, el banco cobra");
                } else {
                    tablero.getPropiedadSolar(nombre).getPropietario().recibir(renta);
                }
                for (int i = 0; i < tablero.getJugadores().size(); i++) {
                    if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                        tablero.player1Debe = false;
                    } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                        tablero.player2Debe = false;
                    }
                }
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Renta", getStage(), "Renta pagada exitosamente.");
                getStage().close();
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Renta", getStage(), "Saldo insuficiente para pagar la renta.");
            }
        });
        JFXButton btnEsperar = new JFXButton("Esperar");
        btnEsperar.getStyleClass().add("carta-button");
        btnEsperar.setOnAction(event -> {
            for (int i = 0; i < tablero.getJugadores().size(); i++) {
                if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                    tablero.player1Debe = true;
                } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                    tablero.player2Debe = true;
                }
            }
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Renta", getStage(), "Recuerda pagar la renta, si no seras declarado en bancarrota.");
            getStage().close();
        });
        HBox hboxOpciones = new HBox(btnPagar, btnEsperar);
        VBox.setMargin(hboxOpciones, new Insets(10, 0, 20, 0));
        hboxOpciones.setSpacing(10);
        hboxOpciones.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(cartaPropiedad, hboxOpciones);
        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);
    }

    public void rentaServicioPublicoInterfaz(JugadorDto jugador, TableroDto tablero, String nombre, int dadoTirado) {
        rootOpcionJugadorView.getChildren().clear();

        for (int i = 0; i < tablero.getJugadores().size(); i++) {
            if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                tablero.player1Debe = true;
            } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                tablero.player2Debe = true;
            }
        }

        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(200);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        VBox cartaPropiedad = new VBox();
        cartaPropiedad.getStyleClass().add("carta-contenedor");

        VBox vboxTitulo = new VBox();
        vboxTitulo.getStyleClass().add("carta-contenedorTitulo");
        VBox.setMargin(vboxTitulo, new Insets(5, 0, 5, 0));
        vboxTitulo.setAlignment(Pos.CENTER);
        Label lbTituloPropiedad = new Label("Servicio Publico");
        lbTituloPropiedad.getStyleClass().add("carta-lbTituloPropiedad");
        vboxTitulo.getChildren().addAll(lbTituloPropiedad);

        ServicioPublico propiedad = tablero.getPropiedadServicio(nombre);

        int renta = propiedad.calcularRenta(dadoTirado, tablero.cuantosServicios(propiedad.getPropietario()));

        Label lbInfo = new Label("Te encuentras en propiedad ajena debes pagar $" + renta);
        lbInfo.setWrapText(true);

        cartaPropiedad.getChildren().addAll(vboxTitulo, lbInfo);

        JFXButton btnPagar = new JFXButton("Pagar");
        btnPagar.getStyleClass().add("carta-button");
        btnPagar.setOnAction(event -> {
            if (jugador.getSaldo() >= renta) {
                jugador.pagar(renta);
                if (propiedad.isHipotecada()) {
                    System.out.println("Propiedad Hipotecada, el banco cobra");
                } else {
                    propiedad.getPropietario().recibir(renta);
                }
                for (int i = 0; i < tablero.getJugadores().size(); i++) {
                    if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                        tablero.player1Debe = false;
                    } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                        tablero.player2Debe = false;
                    }
                }
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Renta", getStage(), "Renta pagada exitosamente.");
                getStage().close();
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Renta", getStage(), "Saldo insuficiente para pagar la renta.");
            }
        });
        JFXButton btnEsperar = new JFXButton("Esperar");
        btnEsperar.getStyleClass().add("carta-button");
        btnEsperar.setOnAction(event -> {
            for (int i = 0; i < tablero.getJugadores().size(); i++) {
                if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                    tablero.player1Debe = true;
                } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                    tablero.player2Debe = true;
                }
            }
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Renta", getStage(), "Recuerda pagar la renta, si no seras declarado en bancarrota.");
            getStage().close();
        });
        HBox hboxOpciones = new HBox(btnPagar, btnEsperar);
        VBox.setMargin(hboxOpciones, new Insets(10, 0, 20, 0));
        hboxOpciones.setSpacing(10);
        hboxOpciones.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(cartaPropiedad, hboxOpciones);
        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);
    }

    public void rentaEstacionInterfaz(JugadorDto jugador, TableroDto tablero, String nombre) {
        rootOpcionJugadorView.getChildren().clear();

        for (int i = 0; i < tablero.getJugadores().size(); i++) {
            if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                tablero.player1Debe = true;
            } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                tablero.player2Debe = true;
            }
        }

        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(200);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        VBox cartaPropiedad = new VBox();
        cartaPropiedad.getStyleClass().add("carta-contenedor");

        VBox vboxTitulo = new VBox();
        vboxTitulo.getStyleClass().add("carta-contenedorTitulo");
        VBox.setMargin(vboxTitulo, new Insets(5, 0, 5, 0));
        vboxTitulo.setAlignment(Pos.CENTER);
        Label lbTituloPropiedad = new Label("Estacion");
        lbTituloPropiedad.getStyleClass().add("carta-lbTituloPropiedad");
        vboxTitulo.getChildren().addAll(lbTituloPropiedad);

        Estacion propiedad = tablero.getPropiedadEstacion(nombre);

        int renta = propiedad.calcularRenta(tablero.cuantasEstaciones(propiedad.getPropietario()));

        Label lbInfo = new Label("Te encuentras en propiedad ajena debes pagar $" + renta);
        lbInfo.setWrapText(true);

        cartaPropiedad.getChildren().addAll(vboxTitulo, lbInfo);

        JFXButton btnPagar = new JFXButton("Pagar");
        btnPagar.getStyleClass().add("carta-button");
        btnPagar.setOnAction(event -> {
            if (jugador.getSaldo() >= renta) {
                jugador.pagar(renta);
                if (propiedad.isHipotecada()) {
                    System.out.println("Propiedad Hipotecada, el banco cobra");
                } else {
                    propiedad.getPropietario().recibir(renta);
                }
                for (int i = 0; i < tablero.getJugadores().size(); i++) {
                    if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                        tablero.player1Debe = false;
                    } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                        tablero.player2Debe = false;
                    }
                }
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Renta", getStage(), "Renta pagada exitosamente.");
                getStage().close();
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Renta", getStage(), "Saldo insuficiente para pagar la renta.");
            }
        });
        JFXButton btnEsperar = new JFXButton("Esperar");
        btnEsperar.getStyleClass().add("carta-button");
        btnEsperar.setOnAction(event -> {
            for (int i = 0; i < tablero.getJugadores().size(); i++) {
                if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                    tablero.player1Debe = true;
                } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                    tablero.player2Debe = true;
                }
            }
            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Renta", getStage(), "Recuerda pagar la renta, si no seras declarado en bancarrota.");
            getStage().close();
        });
        HBox hboxOpciones = new HBox(btnPagar, btnEsperar);
        VBox.setMargin(hboxOpciones, new Insets(10, 0, 20, 0));
        hboxOpciones.setSpacing(10);
        hboxOpciones.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(cartaPropiedad, hboxOpciones);
        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);
    }

    public void tarjetaInterfaz(JugadorDto jugador, Banca banca, TableroDto tablero, Tarjeta tarjetaSuerte, Stage stageJuegoView) {
        rootOpcionJugadorView.getChildren().clear();

        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(200);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        VBox cartaTarjeta = new VBox();
        cartaTarjeta.setAlignment(Pos.CENTER);

        Label lbTituloPropiedad = new Label(tarjetaSuerte.getTipo());
        lbTituloPropiedad.getStyleClass().add("carta-lbTituloPropiedad");
        Label lbInfo = new Label(tarjetaSuerte.getDescripcion());
        lbInfo.setWrapText(true);

        cartaTarjeta.getChildren().addAll(lbTituloPropiedad, lbInfo);

        int deuda;

        if ("Pagas $500".equals(tarjetaSuerte.getTipo()) || "Pagas $200".equals(tarjetaSuerte.getTipo())) {
            switch (tarjetaSuerte.getTipo()) {
                case "Pagas $200":
                    deuda = 200;
                    break;
                case "Pagas $500":
                    deuda = 500;
                    break;
                default:
                    deuda = 0;
                    break;
            }
            for (int i = 0; i < tablero.getJugadores().size(); i++) {
                if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                    tablero.player1Debe = true;
                } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                    tablero.player2Debe = true;
                }
            }

            JFXButton btnPagar = new JFXButton("Pagar");
            btnPagar.getStyleClass().add("carta-button");
            btnPagar.setOnAction(event -> {
                if (jugador.getSaldo() >= deuda) {
                    jugador.pagar(deuda);
                    for (int i = 0; i < tablero.getJugadores().size(); i++) {
                        if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                            tablero.player1Debe = false;
                        } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                            tablero.player2Debe = false;
                        }
                    }
                    new Mensaje().showModal(Alert.AlertType.INFORMATION, "Suerte", getStage(), "Deuda pagada exitosamente.");
                    getStage().close();
                } else {
                    new Mensaje().showModal(Alert.AlertType.ERROR, "Suerte", getStage(), "Saldo insuficiente para pagar la Deuda.");
                }
            });
            JFXButton btnEsperar = new JFXButton("Esperar");
            btnEsperar.getStyleClass().add("carta-button");
            btnEsperar.setOnAction(event -> {
                for (int i = 0; i < tablero.getJugadores().size(); i++) {
                    if (i == 0 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                        tablero.player1Debe = true;
                    } else if (i == 1 && tablero.getJugadores().get(i).getNombre().equals(jugador.getNombre())) {
                        tablero.player2Debe = true;
                    }
                }
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Suerte", getStage(), "Recuerda pagar la Deuda, si no seras declarado en bancarrota.");
                getStage().close();
            });
            HBox hboxOpciones = new HBox(btnPagar, btnEsperar);
            VBox.setMargin(hboxOpciones, new Insets(10, 0, 20, 0));
            hboxOpciones.setSpacing(10);
            hboxOpciones.setAlignment(Pos.CENTER);

            vbox.getChildren().addAll(cartaTarjeta, hboxOpciones);
        } else {
            JFXButton btnAceptar = new JFXButton("Aceptar");
            btnAceptar.getStyleClass().add("carta-button");
            btnAceptar.setOnAction(event -> {
                getStage().close();
            });
            HBox hboxOpciones = new HBox(btnAceptar);
            VBox.setMargin(hboxOpciones, new Insets(10, 0, 20, 0));
            hboxOpciones.setSpacing(10);
            hboxOpciones.setAlignment(Pos.CENTER);

            vbox.getChildren().addAll(cartaTarjeta, hboxOpciones);
        }

        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);
    }

    public void goInterfaz(JugadorDto jugador, Banca banca, TableroDto tablero, Stage stageJuegoView) {
        rootOpcionJugadorView.getChildren().clear();

        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(200);
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        VBox cartaTarjeta = new VBox();
        Label lbTituloPropiedad = new Label("Go");
        lbTituloPropiedad.getStyleClass().add("carta-lbTituloPropiedad");
        Label lbInfo = new Label("Recibes $200 por pasar por acá");

        cartaTarjeta.getChildren().addAll(lbTituloPropiedad, lbInfo);

        JFXButton btnAceptar = new JFXButton("Aceptar");
        btnAceptar.getStyleClass().add("carta-button");
        btnAceptar.setOnAction(event -> {
            banca.pagar(200, jugador);
            getStage().close();
        });
        HBox hboxOpciones = new HBox(btnAceptar);
        VBox.setMargin(hboxOpciones, new Insets(10, 0, 20, 0));
        hboxOpciones.setSpacing(10);
        hboxOpciones.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(cartaTarjeta, hboxOpciones);

        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);
    }

    public void declararGanador(JugadorDto jugador, TableroDto tablero) {
        rootOpcionJugadorView.getChildren().clear();

        StackPane stackPane = new StackPane();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        VBox cartaPropiedad = new VBox();
        cartaPropiedad.setAlignment(Pos.CENTER);

        VBox vboxTitulo = new VBox();
        Label lbTituloPropiedad = new Label("Ganador");
        lbTituloPropiedad.getStyleClass().add("NuevaPartida-lbPlayer");
        vboxTitulo.getChildren().addAll(lbTituloPropiedad);
        vboxTitulo.setAlignment(Pos.CENTER);

        JugadorDto jugadorGanador = null;
        for (JugadorDto jug : tablero.getJugadores()) {
            if (!jug.getNombre().equals(jugador.getNombre())) {
                jugadorGanador = jug;
            }
        }

        Label lbInfo = new Label("!! Felicidades " + jugadorGanador.getNombre() + ", ganaste la partida");
        lbInfo.getStyleClass().add("NuevaPartida-lbPlayer");
        
        TableView tbvPropiedadesp1 = new TableView();

        tbvPropiedadesp1.getColumns().clear();
        tbvPropiedadesp1.getItems().clear();

        TableColumn<PropiedadDto, String> tbcNombre = new TableColumn<>("Nombre");
        tbcNombre.setPrefWidth(150);
        tbcNombre.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getNombre()));

        TableColumn<PropiedadDto, String> tbcRenta = new TableColumn<>("Renta");
        tbcRenta.setPrefWidth(100);
        tbcRenta.setCellValueFactory(cd -> new SimpleStringProperty("" + cd.getValue().getRenta()));

        tbvPropiedadesp1.getColumns().add(tbcNombre);
        tbvPropiedadesp1.getColumns().add(tbcRenta);
        tbvPropiedadesp1.refresh();

        tbvPropiedadesp1.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Verifica si es un solo clic
                PropiedadDto propiedadSeleccionada = (PropiedadDto) tbvPropiedadesp1.getSelectionModel().getSelectedItem();
                if (propiedadSeleccionada != null) {
                    if (propiedadSeleccionada instanceof Solar) {
                        CartaViewController cartaViewController = (CartaViewController) FlowController.getInstance().getController("CartaView");
                        cartaViewController.solarInterfaz(propiedadSeleccionada);
                        FlowController.getInstance().goViewInWindowModal("CartaView", getStage(), false);
                    } else if (propiedadSeleccionada instanceof ServicioPublico) {
                        CartaViewController cartaViewController = (CartaViewController) FlowController.getInstance().getController("CartaView");
                        cartaViewController.servicioPublicoInterfaz(propiedadSeleccionada);
                        FlowController.getInstance().goViewInWindowModal("CartaView", getStage(), false);
                    } else if (propiedadSeleccionada instanceof Estacion) {
                        CartaViewController cartaViewController = (CartaViewController) FlowController.getInstance().getController("CartaView");
                        cartaViewController.estacionInterfaz(propiedadSeleccionada);
                        FlowController.getInstance().goViewInWindowModal("CartaView", getStage(), false);
                    }
                }
            }
        });
        
        TableView tbvPropiedadesp2 = new TableView();

        tbvPropiedadesp2.getColumns().clear();
        tbvPropiedadesp2.getItems().clear();
        
        TableColumn<PropiedadDto, String> tbcNombre2 = new TableColumn<>("Nombre");
        tbcNombre2.setPrefWidth(150);
        tbcNombre2.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getNombre()));

        TableColumn<PropiedadDto, String> tbcRenta2 = new TableColumn<>("Renta");
        tbcRenta2.setPrefWidth(100);
        tbcRenta2.setCellValueFactory(cd -> new SimpleStringProperty("" + cd.getValue().getRenta()));

        tbvPropiedadesp2.getColumns().add(tbcNombre2);
        tbvPropiedadesp2.getColumns().add(tbcRenta2);
        tbvPropiedadesp2.refresh();

        tbvPropiedadesp2.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) { // Verifica si es un solo clic
                PropiedadDto propiedadSeleccionada = (PropiedadDto) tbvPropiedadesp2.getSelectionModel().getSelectedItem();
                if (propiedadSeleccionada != null) {
                    if (propiedadSeleccionada instanceof Solar) {
                        CartaViewController cartaViewController = (CartaViewController) FlowController.getInstance().getController("CartaView");
                        cartaViewController.solarInterfaz(propiedadSeleccionada);
                        FlowController.getInstance().goViewInWindowModal("CartaView", getStage(), false);
                    } else if (propiedadSeleccionada instanceof ServicioPublico) {
                        CartaViewController cartaViewController = (CartaViewController) FlowController.getInstance().getController("CartaView");
                        cartaViewController.servicioPublicoInterfaz(propiedadSeleccionada);
                        FlowController.getInstance().goViewInWindowModal("CartaView", getStage(), false);
                    } else if (propiedadSeleccionada instanceof Estacion) {
                        CartaViewController cartaViewController = (CartaViewController) FlowController.getInstance().getController("CartaView");
                        cartaViewController.estacionInterfaz(propiedadSeleccionada);
                        FlowController.getInstance().goViewInWindowModal("CartaView", getStage(), false);
                    }
                }
            }
        });
        Label lbP1 = new Label(jugador.getNombre());
        lbP1.getStyleClass().add("NuevaPartida-lbPlayer");
        VBox vboxContendorPropiP1 = new VBox(lbP1, tbvPropiedadesp1);
        vboxContendorPropiP1.setAlignment(Pos.CENTER);
        Label lbP2 = new Label(jugadorGanador.getNombre());
        lbP2.getStyleClass().add("NuevaPartida-lbPlayer");
        VBox vboxContendorPropiP2 = new VBox(lbP2, tbvPropiedadesp2);
        vboxContendorPropiP2.setAlignment(Pos.CENTER);
        lbInfo.getStyleClass().add("NuevaPartida-lbPlayer");
        HBox hboxContenedorPropiedades = new HBox(vboxContendorPropiP1, vboxContendorPropiP2);
        hboxContenedorPropiedades.setAlignment(Pos.CENTER);

        cartaPropiedad.getChildren().addAll(vboxTitulo, lbInfo, hboxContenedorPropiedades);

        JFXButton btnContinuar = new JFXButton("Continuar");
        btnContinuar.getStyleClass().add("carta-button");
        btnContinuar.setOnAction(event -> {
            getStage().close();
            FlowController.getInstance().goMain();
        });
        HBox hboxOpciones = new HBox(btnContinuar);
        hboxOpciones.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(cartaPropiedad, hboxOpciones);
        vbox.setSpacing(10);
        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);
        
        cargarPropiedades(tbvPropiedadesp1, jugador, tablero);
        cargarPropiedades(tbvPropiedadesp2, jugadorGanador, tablero);
    }

    private void cargarPropiedades(TableView tbvPropiedades, JugadorDto jugador, TableroDto tablero) {
        ObservableList<PropiedadDto> propiedades = FXCollections.observableArrayList();
        for (String prop : jugador.getPropiedades()) {
            Solar sola = tablero.getPropiedadSolar(prop);
            if (sola != null) {
                propiedades.add(sola);
            }
        }

        for (String prop : jugador.getPropiedades()) {
            ServicioPublico servi = tablero.getPropiedadServicio(prop);
            if (servi != null) {
                propiedades.add(servi);
            }
        }

        for (String prop : jugador.getPropiedades()) {
            Estacion esta = tablero.getPropiedadEstacion(prop);
            if (esta != null) {
                propiedades.add(esta);
            }
        }

        if (propiedades != null) {
            tbvPropiedades.setItems(propiedades);
            tbvPropiedades.refresh();
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Mi Capital", getStage(), "Error cargando las propiedades");
        }
    }

}

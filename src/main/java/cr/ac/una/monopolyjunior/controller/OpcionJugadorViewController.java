/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.monopolyjunior.model.JugadorDto;
import cr.ac.una.monopolyjunior.model.Propiedad;
import cr.ac.una.monopolyjunior.model.Tablero;
import cr.ac.una.tarea.util.Mensaje;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

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

    public void comprarPropiedadInterfaz(JugadorDto jugador, Propiedad propiedad) {
        rootOpcionJugadorView.getChildren().clear();

        StackPane stackPane = new StackPane();
        VBox vbox = new VBox();

        VBox cartaPropiedad = new VBox();

        VBox vboxTitulo = new VBox();
        Label lbTituloPropiedad = new Label(propiedad.getNombre());
        vboxTitulo.getChildren().add(lbTituloPropiedad);

        Label lbAlquiler = new Label("Alquiler:");

        Label lbSola = new Label("Solar sin edificar");
        HBox hboxSola1 = new HBox(lbSola);
        Label lbSolaAlquiler = new Label("$" + propiedad.getRenta());
        HBox hboxSola2 = new HBox(lbSolaAlquiler);
        HBox hboxSola = new HBox(hboxSola1, hboxSola2);

        Label lb1Casa = new Label("Con 1 casa");
        HBox hbox1Casa1 = new HBox(lb1Casa);
        Label lb1CasaAlquiler = new Label("$" + propiedad.getRenta());
        HBox hbox1Casa2 = new HBox(lb1CasaAlquiler);
        HBox hbox1Casa = new HBox(hbox1Casa1, hbox1Casa2);

        Label lb2Casa = new Label("Con 2 casas");
        HBox hbox2Casa1 = new HBox(lb2Casa);
        Label lb2CasaAlquiler = new Label("$" + propiedad.getRenta());
        HBox hbox2Casa2 = new HBox(lb2CasaAlquiler);
        HBox hbox2Casa = new HBox(hbox2Casa1, hbox2Casa2);

        Label lb3Casa = new Label("Con 3 casas");
        HBox hbox3Casa1 = new HBox(lb3Casa);
        Label lb3CasaAlquiler = new Label("$" + propiedad.getRenta());
        HBox hbox3Casa2 = new HBox(lb3CasaAlquiler);
        HBox hbox3Casa = new HBox(hbox3Casa1, hbox3Casa2);

        Label lb4Casa = new Label("Con 4 casas");
        HBox hbox4Casa1 = new HBox(lb4Casa);
        Label lb4CasaAlquiler = new Label("$" + propiedad.getRenta());
        HBox hbox4Casa2 = new HBox(lb4CasaAlquiler);
        HBox hbox4Casa = new HBox(hbox4Casa1, hbox4Casa2);

        Label lbHotel = new Label("Con Hotel");
        HBox hboxHotel1 = new HBox(lbHotel);
        Label lbHotelAlquiler = new Label("$" + propiedad.getRenta());
        HBox hboxHotel2 = new HBox(lbHotelAlquiler);
        HBox hboxHotel = new HBox(hboxHotel1, hboxHotel2);

        VBox vboxAlquiler = new VBox(hboxSola, hbox1Casa, hbox2Casa, hbox3Casa, hbox4Casa, hboxHotel);

        Label lbInfo = new Label("Si un jugador posee todas las propiedades de un mismo color el precio de alquiler se duplica");

        Label lbPrecioConstruc = new Label("Precio de construcción:");

        Label lbCostoXCasa = new Label("Costo X casa");
        HBox hboxCostoXCasa1 = new HBox(lbCostoXCasa);
        Label lbCostoXCasaAlquiler = new Label("$100 c/u");
        HBox hboxCostoXCasa2 = new HBox(lbCostoXCasaAlquiler);
        HBox hboxCostoXCasa = new HBox(hboxCostoXCasa1, hboxCostoXCasa2);

        Label lbCostoXHotel = new Label("Con Hotel");
        HBox hboxCostoXHotel1 = new HBox(lbCostoXHotel);
        Label lbCostoXHotelAlquiler = new Label("$400 c/u");
        HBox hboxCostoXHotel2 = new HBox(lbCostoXHotelAlquiler);
        HBox hboxCostoXHotel = new HBox(hboxCostoXHotel1, hboxCostoXHotel2);

        VBox vboxPrecioConstruc = new VBox(hboxCostoXCasa, hboxCostoXHotel);

        Label lbValorHipo = new Label("Valor Hipotecario   $" + propiedad.getValorHipoteca());

        cartaPropiedad.getChildren().addAll(vboxTitulo, lbAlquiler, vboxAlquiler, lbInfo, lbPrecioConstruc, vboxPrecioConstruc, lbValorHipo);

        JFXButton btnComprar = new JFXButton("Comprar");
        btnComprar.setOnAction(event -> {
            if (jugador.getSaldo() >= propiedad.getPrecioCompra()) {
                comprarPropiedad(jugador, propiedad);
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Comprar Propiedad", getStage(), "Compra realizada exitosamente.");
                getStage().close();
            } else {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Comprar Propiedad", getStage(), "Saldo insuficiente para realizar la compra.");
            }
        });
        JFXButton btnNoComprar = new JFXButton("No Comprar");
        btnNoComprar.setOnAction(event -> {
            getStage().close();
        });
        HBox hboxOpciones = new HBox(btnComprar, btnNoComprar);

        vbox.getChildren().addAll(cartaPropiedad, hboxOpciones);
        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);
    }

    public void comprarPropiedad(JugadorDto jugador, Propiedad propiedad) {
        jugador.pagar(propiedad.getPrecioCompra());
        jugador.agregarPropiedad(propiedad.getNombre());
        propiedad.setPropietario(jugador);
    }

    public void miCapitalInterfaz(JugadorDto jugador, Tablero tablero) {
        rootOpcionJugadorView.getChildren().clear();

        StackPane stackPane = new StackPane();
        VBox vbox = new VBox();
        TableView tbvPropiedades = new TableView();

        tbvPropiedades.getColumns().clear();
        tbvPropiedades.getItems().clear();

        TableColumn<Propiedad, String> tbcNombre = new TableColumn<>("Nombre");
        tbcNombre.setPrefWidth(150);
        tbcNombre.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getNombre()));

        TableColumn<Propiedad, String> tbcRenta = new TableColumn<>("Renta");
        tbcRenta.setPrefWidth(100);
        tbcRenta.setCellValueFactory(cd -> new SimpleStringProperty("" + cd.getValue().getRenta()));

        tbvPropiedades.getColumns().add(tbcNombre);
        tbvPropiedades.getColumns().add(tbcRenta);
        tbvPropiedades.refresh();
        
        vbox.getChildren().add(tbvPropiedades);
        stackPane.getChildren().add(vbox);
        rootOpcionJugadorView.getChildren().add(stackPane);

        cargarPropiedades(tbvPropiedades, jugador, tablero);
    }
    
    private void cargarPropiedades(TableView tbvPropiedades, JugadorDto jugador, Tablero tablero) {
        ObservableList<Propiedad> propiedades = FXCollections.observableArrayList();
        for(String prop : jugador.getPropiedades()) {
            propiedades.add(tablero.getPropiedad(prop));
        }
        if (propiedades != null) {
            tbvPropiedades.setItems(propiedades);
            tbvPropiedades.refresh();
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Mi Capital", getStage(), "Error cargando las propiedades");
        }
    }

}

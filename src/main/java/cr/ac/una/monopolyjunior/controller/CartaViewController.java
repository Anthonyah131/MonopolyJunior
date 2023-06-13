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
import cr.ac.una.monopolyjunior.model.Solar;
import cr.ac.una.tarea.util.Mensaje;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class CartaViewController extends Controller implements Initializable {

    @FXML
    private AnchorPane rootCartaView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  // Esta clase muestra las cartas de cada propiedad
        // TODO
    }

    @Override
    public void initialize() {
    }

    public void solarInterfaz(PropiedadDto propiedad) {
        rootCartaView.getChildren().clear();

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
        vbox.getChildren().addAll(cartaPropiedad);
        stackPane.getChildren().add(vbox);
        rootCartaView.getChildren().add(stackPane);
    }

    public void servicioPublicoInterfaz(PropiedadDto propiedad) {
        rootCartaView.getChildren().clear();

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

        vbox.getChildren().addAll(cartaPropiedad);
        stackPane.getChildren().add(vbox);
        rootCartaView.getChildren().add(stackPane);
    }

    public void estacionInterfaz(PropiedadDto propiedad) {
        rootCartaView.getChildren().clear();

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

        vbox.getChildren().addAll(cartaPropiedad);
        stackPane.getChildren().add(vbox);
        rootCartaView.getChildren().add(stackPane);
    }
}

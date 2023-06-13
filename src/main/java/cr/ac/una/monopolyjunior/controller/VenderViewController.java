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
import cr.ac.una.monopolyjunior.util.FlowController;
import cr.ac.una.tarea.util.Mensaje;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class VenderViewController extends Controller implements Initializable {

    @FXML
    private StackPane root;
    @FXML
    private TableView tbvPropiedades;
    @FXML
    private JFXButton btnListo;

    ObservableList<PropiedadDto> propiedades = FXCollections.observableArrayList();
    TableroDto tablero;
    JugadorDto jugador;
    Banca banca;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  // Permite ver la interfaz de vender, Hipotecar o pagar Hipotecas 
        // TODO
    }

    @Override
    public void initialize() {
    }

    @FXML
    private void onActionBtnListo(ActionEvent event) {
        getStage().close();
    }

    public void VenderPropiedades(TableroDto tablero, JugadorDto jugador, Banca banca) {
        try {
            this.jugador = jugador;
            this.banca = banca;
            this.tablero = tablero;
            
            tablero.getPropiedadesSolar().stream().forEach(prop -> {
                if (prop.tienePropietario()) {
                    System.out.println("Entra con la propiedad " + prop.getNombre() + " : El propietario es " + prop.getPropietario().getNombre());
                    System.out.println("Entra con la propiedad " + prop.getNombre() + " : " + prop.isHipotecada());
                }
            });

            tbvPropiedades.getColumns().clear();
            tbvPropiedades.getItems().clear();

            TableColumn<PropiedadDto, String> tbcNombre = new TableColumn<>("Nombre");
            tbcNombre.setPrefWidth(150);
            tbcNombre.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getNombre()));

            TableColumn<PropiedadDto, Boolean> tbcVender = new TableColumn<>("Vender");
            tbcVender.setPrefWidth(100);
            tbcVender.setCellValueFactory(cd -> new SimpleObjectProperty(cd.getValue() != null));
            tbcVender.setCellFactory(cd -> new ButtonCell("Vender"));

            tbvPropiedades.getColumns().add(tbcNombre);
            tbvPropiedades.getColumns().add(tbcVender);
            tbvPropiedades.refresh();

            tbvPropiedades.getItems().clear();
            getPropiedades();
            tbvPropiedades.setItems(propiedades);
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

        } catch (Exception ex) {
            Logger.getLogger(VenderViewController.class.getName()).log(Level.SEVERE, "Error consultando las propiedades", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Vernder Propiedad", getStage(), "Ocurrio un error consultando las propiedades");
        }
    }

    public void hipotecarPropiedades(TableroDto tablero, JugadorDto jugador, Banca banca) {
        try {
            this.jugador = jugador;
            this.banca = banca;
            this.tablero = tablero;

            tbvPropiedades.getColumns().clear();
            tbvPropiedades.getItems().clear();

            TableColumn<PropiedadDto, String> tbcNombre = new TableColumn<>("Nombre");
            tbcNombre.setPrefWidth(150);
            tbcNombre.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getNombre()));
            
            TableColumn<PropiedadDto, String> tbcHipoteca = new TableColumn<>("Valor Hipoteca");
            tbcHipoteca.setPrefWidth(100);
            tbcHipoteca.setCellValueFactory(cd -> new SimpleStringProperty("" + cd.getValue().getValorHipoteca()));

            TableColumn<PropiedadDto, Boolean> tbcVender = new TableColumn<>("Hipotecar");
            tbcVender.setPrefWidth(100);
            tbcVender.setCellValueFactory(cd -> new SimpleObjectProperty(cd.getValue() != null));
            tbcVender.setCellFactory(cd -> new ButtonCell("Hipotecar"));

            tbvPropiedades.getColumns().add(tbcNombre);
            tbvPropiedades.getColumns().add(tbcHipoteca);
            tbvPropiedades.getColumns().add(tbcVender);
            tbvPropiedades.refresh();

            tbvPropiedades.getItems().clear();
            getPropiedades();
            tbvPropiedades.setItems(propiedades);
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

        } catch (Exception ex) {
            Logger.getLogger(VenderViewController.class.getName()).log(Level.SEVERE, "Error consultando las propiedades", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Hipotecar Propiedades", getStage(), "Ocurrio un error consultando las propiedades");
        }
    }

    public void pagarHipotecaPropiedades(TableroDto tablero, JugadorDto jugador, Banca banca) {
        try {
            this.jugador = jugador;
            this.banca = banca;
            this.tablero = tablero;

            tbvPropiedades.getColumns().clear();
            tbvPropiedades.getItems().clear();

            TableColumn<PropiedadDto, String> tbcNombre = new TableColumn<>("Nombre");
            tbcNombre.setPrefWidth(150);
            tbcNombre.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getNombre()));
            
            TableColumn<PropiedadDto, String> tbcHipoteca = new TableColumn<>("Valor Pagar");
            tbcHipoteca.setPrefWidth(100);
            tbcHipoteca.setCellValueFactory(cd -> new SimpleStringProperty("" + (int)(cd.getValue().getValorHipoteca() + cd.getValue().getValorHipoteca() * 0.20)));

            TableColumn<PropiedadDto, Boolean> tbcVender = new TableColumn<>("Pagar Hipoteca");
            tbcVender.setPrefWidth(100);
            tbcVender.setCellValueFactory(cd -> new SimpleObjectProperty(cd.getValue() != null));
            tbcVender.setCellFactory(cd -> new ButtonCell("Pagar Hipoteca"));

            tbvPropiedades.getColumns().add(tbcNombre);
            tbvPropiedades.getColumns().add(tbcHipoteca);
            tbvPropiedades.getColumns().add(tbcVender);
            tbvPropiedades.refresh();

            tbvPropiedades.getItems().clear();
            getPropiedadesHipotecadas();
            tbvPropiedades.setItems(propiedades);
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

        } catch (Exception ex) {
            Logger.getLogger(VenderViewController.class.getName()).log(Level.SEVERE, "Error consultando las propiedades", ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Pagar Hipoteca", getStage(), "Ocurrio un error consultando las propiedades");
        }
    }

    public void getPropiedades() {
        propiedades.clear();

        propiedades.addAll(tablero.getPropiedadesSolar().stream().filter(p -> p.getPropietario() != null && jugador.getNombre().equals(p.getPropietario().getNombre()) && !p.isHipotecada())
                .map(p -> p)
                .collect(Collectors.toList()));

        propiedades.addAll(tablero.getPropiedadesEstacion().stream().filter(p -> p.getPropietario() != null && jugador.getNombre().equals(p.getPropietario().getNombre()) && !p.isHipotecada())
                .map(p -> p)
                .collect(Collectors.toList()));

        propiedades.addAll(tablero.getPropiedadesServicios().stream().filter(p -> p.getPropietario() != null && jugador.getNombre().equals(p.getPropietario().getNombre()) && !p.isHipotecada())
                .map(p -> p)
                .collect(Collectors.toList()));
    }

    public void getPropiedadesHipotecadas() {
        propiedades.clear();

        propiedades.addAll(tablero.getPropiedadesSolar().stream().filter(p -> p.getPropietario() != null && jugador.getNombre().equals(p.getPropietario().getNombre()) && p.isHipotecada())
                .map(p -> p)
                .collect(Collectors.toList()));

        propiedades.addAll(tablero.getPropiedadesEstacion().stream().filter(p -> p.getPropietario() != null && jugador.getNombre().equals(p.getPropietario().getNombre()) && p.isHipotecada())
                .map(p -> p)
                .collect(Collectors.toList()));

        propiedades.addAll(tablero.getPropiedadesServicios().stream().filter(p -> p.getPropietario() != null && jugador.getNombre().equals(p.getPropietario().getNombre()) && p.isHipotecada())
                .map(p -> p)
                .collect(Collectors.toList()));
    }

    private class ButtonCell extends TableCell<PropiedadDto, Boolean> {

        final Button cellButton = new Button();

        ButtonCell(String nombre) {
            if ("Vender".equals(nombre)) {
                cellButton.setText(nombre);
                cellButton.setPrefWidth(500);
//            cellButton.getStyleClass().add("jfx-btnimg-tbveliminar");

                cellButton.setOnAction((ActionEvent t) -> {
                    PropiedadDto prop = (PropiedadDto) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                    if (new Mensaje().showConfirmation("Vender Propiedad", getStage(), "¿Esta seguro que desea vender " + prop.getNombre() + " por un valor de $" + (int) (prop.getPrecioCompra() * 0.75) + "?")) {
                        if (prop != null && prop instanceof Solar) {
                            Solar propSolar = (Solar) prop;
                            for (Solar pro : tablero.getPropiedadesSolar()) {
                                if (pro.getColor().equals(propSolar.getColor())) {
                                    if (pro.getHotel() == 1) {
                                        pro.demolerHotel(banca);
                                    }
                                    for (int i = pro.getCasas(); i > 0; i--) {
                                        pro.demolerCasa(banca);
                                    }
                                    if (propSolar.getNombre().equals(pro.getNombre())) {
                                        banca.comprarPropiedad(prop, jugador);
                                    }
                                }
                            }
                        } else if (prop != null && prop instanceof ServicioPublico) {
                            ServicioPublico propServicio = (ServicioPublico) prop;
                            for (ServicioPublico pro : tablero.getPropiedadesServicios()) {
                                if (propServicio.getNombre().equals(pro.getNombre())) {
                                    banca.comprarPropiedad(prop, jugador);
                                }
                            }
                        } else if (prop != null && prop instanceof Estacion) {
                            Estacion propEstacion = (Estacion) prop;
                            for (Estacion pro : tablero.getPropiedadesEstacion()) {
                                if (propEstacion.getNombre().equals(pro.getNombre())) {
                                    banca.comprarPropiedad(prop, jugador);
                                }
                            }
                        }
                        tbvPropiedades.getItems().remove(prop);
                        tbvPropiedades.refresh();

                        JuegoViewController juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
                        juegoViewController.actualizarDatosInterfaz(jugador);
                    }
                });
            } else if ("Hipotecar".equals(nombre)) {
                cellButton.setText(nombre);
                cellButton.setPrefWidth(500);
//            cellButton.getStyleClass().add("jfx-btnimg-tbveliminar");

                cellButton.setOnAction((ActionEvent t) -> {
                    PropiedadDto prop = (PropiedadDto) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                    if (new Mensaje().showConfirmation("Hipotecar Propiedad", getStage(), "¿Esta seguro que desea Hipotecar " + prop.getNombre() + " por un valor de $" + prop.getValorHipoteca() + "?")) {
                        banca.hipotecarPropiedad(prop, tablero, jugador);

                        tbvPropiedades.getItems().remove(prop);
                        tbvPropiedades.refresh();

                        JuegoViewController juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
                        juegoViewController.actualizarDatosInterfaz(jugador);
                    }
                });
            } else if ("Pagar Hipoteca".equals(nombre)) {
                cellButton.setText(nombre);
                cellButton.setPrefWidth(500);
//            cellButton.getStyleClass().add("jfx-btnimg-tbveliminar");

                cellButton.setOnAction((ActionEvent t) -> {
                    PropiedadDto prop = (PropiedadDto) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                    if (jugador.getSaldo() >= prop.getValorHipoteca() + prop.getValorHipoteca() * 0.20) {
                        if (new Mensaje().showConfirmation("Pagar Hipoteca", getStage(), "¿Esta seguro que desea pagar la hipoteca de " + prop.getNombre() + " con un monto de $" + (int)(prop.getValorHipoteca() + prop.getValorHipoteca() * 0.20) + "?")) {
                            banca.CobrarHipotecarPropiedad(prop, tablero, jugador);

                            tbvPropiedades.getItems().remove(prop);
                            tbvPropiedades.refresh();

                            JuegoViewController juegoViewController = (JuegoViewController) FlowController.getInstance().getController("JuegoView");
                            juegoViewController.actualizarDatosInterfaz(jugador);
                        }
                    } else {
                        new Mensaje().showModal(Alert.AlertType.ERROR, "Pagar Hipoteca", getStage(), "Saldo insuficiente para pagar hipoteca.");
                    }
                });
            }
        }

        @Override

        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(cellButton);
            }
        }
    }

}

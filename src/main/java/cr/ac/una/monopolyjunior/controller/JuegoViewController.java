/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopolyjunior.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class JuegoViewController extends Controller implements Initializable {
    
    @FXML
    private AnchorPane rootJuegoView;
    
    private static final int ROWS = 9;
    private static final int COLUMNS = 9;
    private static final int TILE_SIZE = 60;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearTablero();
    }    
    
    @Override
    public void initialize() {
    }
    
    public void crearTablero() {
        GridPane board = new GridPane();

        // Crear las casillas del tablero
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                StackPane tile = new StackPane();
                tile.setPrefSize(TILE_SIZE, TILE_SIZE);
                
                Rectangle border = new Rectangle(TILE_SIZE, TILE_SIZE);
                border.setFill(null);
                border.setStroke(Color.BLACK);
                tile.getChildren().add(border);

                // Asignar un color diferente a las casillas especiales
                if (row == 0 || row == ROWS - 1 || col == 0 || col == COLUMNS - 1) {
                    tile.setStyle("-fx-background-color: #f8f8ff;");
                    Label label = new Label("Hola Mundo");
                    tile.getChildren().add(label);
                } else if (row % 2 == 0) {
                    tile.setStyle("-fx-background-color: #ffe4b5;");
                } else {
                    tile.setStyle("-fx-background-color: #add8e6;");
                }
                
                board.add(tile, col, row);
            }
        }
        rootJuegoView.getChildren().add(board);
    }
    
}

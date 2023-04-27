package cr.ac.una.monopolyjunior;

import cr.ac.una.monopolyjunior.util.FlowController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowController.getInstance().InitializeFlow(primaryStage, null);
        FlowController.getInstance().goMain();
        
        /*GridPane board = new GridPane();

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

// Obtener el StackPane existente en la posición (0, 0)
        StackPane stackPane = (StackPane) board.getChildren().get(0);
        Label labelAntiguo = (Label) stackPane.getChildren().get(1);
        System.out.println(stackPane.getChildren().size());
        stackPane.getChildren().remove(labelAntiguo);
        System.out.println(stackPane.getChildren().size());

// Crear un nuevo Label para reemplazar el StackPane existente
        Label label = new Label("Nuevo Label");

// Reemplazar el StackPane existente con el nuevo Label en la posición (0, 0)
        stackPane.getChildren().add(label);

// Obtener el Label en la posición (0, 0)
        Label newLabel = (Label) stackPane.getChildren().get(1);

// Imprimir el texto del Label
        StackPane stackPanee = (StackPane) board.getChildren().get(0);
        Label labelAntiguoo = (Label) stackPanee.getChildren().get(1);
        
        System.out.println(stackPanee.getChildren().size());
        System.out.println(labelAntiguoo.getText());

        Scene scene = new Scene(board);
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }

    public static void main(String[] args) {
        launch();
    }

}

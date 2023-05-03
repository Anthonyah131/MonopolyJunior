package cr.ac.una.monopolyjunior;

import cr.ac.una.monopolyjunior.util.FlowController;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    private static final int ROWS = 9;
    private static final int COLUMNS = 9;
    private static final int TILE_SIZE = 50;

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

        board.getChildren().remove(stackPane);

// Crear un nuevo Label para reemplazar el StackPane existente
        Label label = new Label("Nuevo Label");

        board.add(label, 0, 0);

// Imprimir el texto del Label
        Node node = (Node) board.getChildren().get(0);

        System.out.println(node);

        Scene scene = new Scene(board);
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }

    public static void main(String[] args) {
        launch();
    }

}

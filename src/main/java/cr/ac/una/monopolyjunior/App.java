package cr.ac.una.monopolyjunior;

import cr.ac.una.monopolyjunior.util.FlowController;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowController.getInstance().InitializeFlow(primaryStage, null);
        FlowController.getInstance().goMain();
    }

    public static void main(String[] args) {
        launch();
    }

}

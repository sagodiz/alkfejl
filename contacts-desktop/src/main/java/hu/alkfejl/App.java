package hu.alkfejl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Stage stage;
    @Override
    public void start(Stage stage) {
        App.stage = stage;
        App.loadFXML("/fxml/main_window.fxml");

        stage.show();
    }

    public static FXMLLoader loadFXML(String fxml){
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
        Scene scene = null;
        try {
           Parent root = loader.load();
           scene = new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        return loader;
    }

    public static void main(String[] args) {
        launch();
    }

}

package pepessenger.code.Client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Adilzhan_Slyamgazy_220103151_Client extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Adilzhan_Slyamgazy_220103151_Client.class.getResource("/pepessenger/views/client-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 475, 557);
        scene.getStylesheets().add(getClass().getResource("/css/stylesheet.css").toExternalForm());
        stage.getIcons().add(new Image(Adilzhan_Slyamgazy_220103151_Client.class.getResourceAsStream("/img/logo.png")));
        stage.setTitle("Pepessenger Client");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

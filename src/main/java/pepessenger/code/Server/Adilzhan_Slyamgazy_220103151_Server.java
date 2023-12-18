package pepessenger.code.Server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Adilzhan_Slyamgazy_220103151_Server extends Application {

    private Scene scene;
    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(Adilzhan_Slyamgazy_220103151_Server.class.getResource("/pepessenger/views/server-view.fxml"));
        try {
            System.out.println(1);
            scene = new Scene(fxmlLoader.load(), 475, 557);
            System.out.println(1);
        } catch (IOException e){
            System.out.println(0);
            e.printStackTrace();
        }
        scene.getStylesheets().add(getClass().getResource("/css/stylesheet.css").toExternalForm());
        stage.getIcons().add(new Image(Adilzhan_Slyamgazy_220103151_Server.class.getResourceAsStream("/img/logo.png")));
        stage.setTitle("Pepessenger Server");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

package pepessenger.code.Client;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private Button sentbt;
    @FXML
    private TextField messagetf;
    @FXML
    private VBox messagesVBox;
    @FXML
    private ScrollPane messageScroll;



    private TCPPacketClient client;

    @FXML
    public void onEnter(ActionEvent event) {
        String messageToSend = messagetf.getText();
        if (!messageToSend.isEmpty()) {
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_RIGHT);

            hBox.setPadding(new Insets(5, 5, 5, 5));
            Text text = new Text(messageToSend);
            TextFlow textFlow = new TextFlow(text);

            textFlow.setStyle("-fx-color: rgb(239, 242, 255); " +
                    "-fx-background-color: rgb(15,125,242); " +
                    "-fx-background-radius: 20px");

            textFlow.setPadding(new Insets(5, 10, 5, 10));
            text.setFill(Color.color(1, 1, 1));

            hBox.getChildren().add(textFlow);
            messagesVBox.getChildren().add(hBox);

            client.sendMessageToServer(messageToSend);

            messagetf.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            client = new TCPPacketClient(new Socket("localhost", 1234));
            System.out.println("Connected to server");
        } catch (IOException e) {
            e.printStackTrace();
        }

        messagesVBox.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                messageScroll.setVvalue((Double) t1);
            }
        });

        client.receiveMessageFromServer(messagesVBox);


        sentbt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String messageToSend = messagetf.getText();
                if (!messageToSend.isEmpty()){
                    HBox hBox = new HBox();
                    hBox.setAlignment(Pos.CENTER_RIGHT);

                    hBox.setPadding(new Insets(5,5,5,10));
                    Text text = new Text(messageToSend);
                    TextFlow textFlow = new TextFlow(text);

                    textFlow.setStyle("-fx-color: rgb(239, 242, 255); " +
                            "-fx-background-color: rgb(15,125,242); " +
                            "-fx-background-radius: 20px");

                    textFlow.setPadding(new Insets(5,10,5,10));
                    text.setFill(Color.color(1,1,1));

                    hBox.getChildren().add(textFlow);
                    messagesVBox.getChildren().add(hBox);

                    client.sendMessageToServer(messageToSend);

                    messagetf.clear();
                }
            }
        });
    }

    public static void addLabel(String messageFromServer, VBox vBox){
        HBox hBox= new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(5,5,5,10));
        Text text = new Text(messageFromServer);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-color: black; " +
                "-fx-background-color: rgb(233, 233, 235); " +
                "-fx-background-radius: 20px");

        textFlow.setPadding(new Insets(5, 5, 5, 10));
        hBox.getChildren().add(textFlow);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vBox.getChildren().add(hBox);
            }
        });
    }
}

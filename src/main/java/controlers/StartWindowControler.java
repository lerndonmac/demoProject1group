package controlers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class StartWindowControler {
    @FXML
    public Button buttonToClients;

    @FXML
    public void initialize(){
        buttonToClients.setOnAction(ActionEvent->{
            buttonToClients.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/view/ClientsTable.fxml"));
                primaryStage.setTitle("Clients table");
                primaryStage.setScene(new Scene(root));
                primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/service_logo.png")));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}

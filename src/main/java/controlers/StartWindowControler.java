package controlers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class StartWindowControler {
    @FXML
    public Button buttonToClients;

    @FXML
    public void initialize() throws IOException{
        buttonToClients.setOnAction(ActionEvent->{
            buttonToClients.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            URL url = null;
            try {
                url = new File("C:\\JavaProjects\\demoProject1group\\src\\main\\java\\view\\ClientsTable.fxml").toURI().toURL();
                root = FXMLLoader.load(url);
                primaryStage.setTitle("Clients table");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Program extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        URL url = new File("C:\\JavaProjects\\demoProject1group\\src\\main\\java\\view\\StartWindow.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Start Window");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/service_logo.png")));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

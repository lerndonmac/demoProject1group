package controlers;

import DAO.DAO;
import DAO.Service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginWinControl {
    private List<User> usersList;

    @FXML
    private ImageView iconImageView;
    @FXML
    private Button signInButton;
    @FXML
    private PasswordField passwordText;
    @FXML
    private TextField loginText;
    @FXML
    private TextArea descriptionText;
    public static Boolean rouleCheker;
    @FXML
    public void initialize() throws FileNotFoundException {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<User, Integer> daoUser = new UserService(factory);
        usersList = daoUser.readAll();
        iconImageView.setImage(new Image(new FileInputStream(getClass().getResource("/service_logo.png").getFile())));
        signInButton.setOnAction(actionEvent -> {
            signInButton.getScene().getWindow().hide();
            for (User user:usersList) {
                if (loginText.getText().equals(user.getLogin())) {
                    if (passwordText.getText().equals(user.getPassword())){
                        if (user.getRule().equals("1")){
                            rouleCheker = true;
                        }else {rouleCheker = false;}
                            Stage primaryStage = new Stage();
                            Parent root = null;
                            try {
                                root = FXMLLoader.load(getClass().getResource("/view/ClientsTable.fxml"));
                                primaryStage.setTitle("Start Window");
                                primaryStage.setScene(new Scene(root));
                                primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/service_logo.png")));
                                primaryStage.show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                    }
                }
            }
        });
    }
}

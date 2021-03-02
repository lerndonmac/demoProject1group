package controlers;

import DAO.DAO;
import DAO.Service.ClientsService;
import DAO.Service.GenderService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import model.Clients;
import model.Gender;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class CreateClientWindowController {

    private static final ObservableList<Gender> genderObservableList = FXCollections.observableArrayList();

    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @FXML
    public TextField firstNameTxt;@FXML
    public TextField lastNameTxt;@FXML
    public TextField patronymicTxt;@FXML
    public DatePicker birthdayDatePicker;@FXML
    public DatePicker registrationDatePicker;@FXML
    public TextField PhoneTxt;@FXML
    public TextField photoPathTxt;@FXML
    public Button photoChooseButton;@FXML
    public Button createButton;
    public ChoiceBox<Gender> genderChoiceBox;
    public TextField emailTxt;
    public Label statusId;

    @FXML
    public void initialize(){
        initList();
        genderChoiceBox.setItems(genderObservableList);
        createButton.setOnAction(ActionEvent->createClient());
    }

    public void initList(){
        DAO<Gender,Integer> genderDAO = new GenderService(factory);
        List<Gender> genders = genderDAO.readAll();
        genderObservableList.addAll(genders);

    }
    public void createClient(){
        Date birthDate = null;
        Date registrationDate = null;
        if (birthdayDatePicker.getValue()!=null) {
            birthDate = Date.from(birthdayDatePicker.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        }else {statusId.setTextFill(Color.RED);statusId.setText("ошибка: не заполнены необходимые данные*");}
        if (registrationDatePicker.getValue()!=null) {
            registrationDate = Date.from(registrationDatePicker.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        }else {statusId.setTextFill(Color.RED);statusId.setText("ошибка: не заполнены необходимые данные*");}
        Clients client;
        client = new Clients(firstNameTxt.getText(), lastNameTxt.getText(), patronymicTxt.getText(), birthDate,
                registrationDate, emailTxt.getText(),photoPathTxt.getText(), photoPathTxt.getText(), genderChoiceBox.getValue());
        DAO<Clients, Integer> clientsDAO = new ClientsService(factory);
        if (!(client.getFirstName().equals(""))&client.getGender()!=null) {
            clientsDAO.create(client);
        }else {statusId.setTextFill(Color.RED);statusId.setText("ошибка: не заполнены необходимые данные*");}

    }
}

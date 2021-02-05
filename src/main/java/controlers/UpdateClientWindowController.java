package controlers;

import DAO.DAO;
import DAO.Service.GenderService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Clients;
import model.Gender;
import net.bytebuddy.asm.Advice;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class UpdateClientWindowController {
    private ObservableList<Gender> genderObservableList = FXCollections.observableArrayList();
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    public Gender gender;
    private static Clients client;

    @FXML
    public TextField firstNameTxt;@FXML
    public TextField lastNameTxt;@FXML
    public TextField patronymicTxt;@FXML
    public DatePicker birthdayDatePicker;@FXML
    public DatePicker registrationDatePicker;@FXML
    public TextField PhoneTxt;@FXML
    public TextField photoPathTxt;@FXML
    public Button photoChooseButton;@FXML
    public Button updateButton;@FXML
    public ChoiceBox<Gender> genderChoiceBox;@FXML
    public TextField emailTxt;@FXML
    public Label statusId;@FXML

    public void initialize(){
        DAO<Gender,Integer> genderIntegerDAO = new GenderService(factory);
        genderObservableList.addAll(genderIntegerDAO.readAll());
        genderChoiceBox.setItems(genderObservableList);
        firstNameTxt.setText(client.getFirstName());
        lastNameTxt.setText(client.getLastName());
        patronymicTxt.setText(client.getPatronymic());
        LocalDate birthdayLD = client.getDateBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate registrationLD = client.getRegistrationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        birthdayDatePicker.setValue(birthdayLD);
        registrationDatePicker.setValue(registrationLD);
        PhoneTxt.setText(client.getPhone());
        photoPathTxt.setText(client.getPhotoPath());
        emailTxt.setText(client.getEmail());
        Gender gender = null;
        for (Gender genre:genderObservableList){
            if (genre.equals(client.getGender())){
                gender = genre;
            }
        }
        genderChoiceBox.setValue(gender);
    }
    public static void setClient(Clients clients){
        client = clients;
    }
}

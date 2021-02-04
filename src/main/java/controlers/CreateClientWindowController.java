package controlers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CreateClientWindowController {

    @FXML
    public TextField firstNameTxt;@FXML
    public TextField lastNameTxt;@FXML
    public TextField patronymicTxt;@FXML
    public DatePicker birthdayDatePicker;@FXML
    public DatePicker registrationDatePicker;@FXML
    public TextField PhoneTxt;@FXML
    public TextField photoPathTxt;@FXML
    public Button photoChooseButton;@FXML
    public ComboBox genderChoiceBox;@FXML
    public Button createButton;
    @FXML
    public void initialize(){
        genderChoiceBox.setItems();
    }
}

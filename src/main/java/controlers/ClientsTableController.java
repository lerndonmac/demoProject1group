package controlers;

import DAO.DAO;
import DAO.Service.ClientsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Clients;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

public class ClientsTableController {
    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    public ObservableList<Clients> clientsObservableList = FXCollections.observableArrayList();
    @FXML
    public TableView<Clients> clientsTableView;@FXML
    public TableColumn<Clients,Integer> idColumn;@FXML
    public TableColumn<Clients,String> firstNameColumn;@FXML
    public TableColumn<Clients,String> lastNameColumn;@FXML
    public TableColumn<Clients,String> patronymicColumn;@FXML
    public TableColumn<Clients,String> birthdayColumn;@FXML
    public TableColumn<Clients,Date> registrationDateColumn;@FXML
    public TableColumn<Clients,String> emailColumn;@FXML
    public TableColumn<Clients,String> phoneColumn;@FXML
    public TableColumn<Clients, Character> genderCodeColumn;@FXML
    public TableColumn<Clients,String> photoPathColumn;@FXML
    public TextField countOfRows;@FXML
    public Button countOfRowsSubmit;@FXML
    public Button createButton;@FXML
    public Button updateButton;@FXML
    public Button deleteButton;

    private int idData = 0;
    private String firstNameData = "";
    private String lastNameData = "";
    private String patronymicData= "";
    private Date birthdayData = new Date();
    private Date registrationDateData = new Date();
    private String emailData = "";
    private String phoneData = "";
    private char genderData = 'e';
    private String photoPathData = "";
    @FXML
    public void initialize() {
        createButton.setOnAction(ActionEvent ->{
            Stage stage = new Stage();
            try {
                Parent parent = FXMLLoader.load(new File("C:\\JavaProjects\\demoProject1group\\src\\main\\java\\view\\CreateWindow.fxml").toURI().toURL());



            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        initData();

        idColumn.setCellValueFactory(new PropertyValueFactory<Clients, Integer>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("lastName"));
        patronymicColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("patronymic"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("birthDay"));
        registrationDateColumn.setCellValueFactory(new PropertyValueFactory<Clients, Date>("registrationDate"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("phone"));
        genderCodeColumn.setCellValueFactory(new PropertyValueFactory<Clients, Character>("gender"));
        photoPathColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("photoPath"));
        clientsTableView.setItems(clientsObservableList);
    }

    public void initData(){
        DAO<Clients, Integer> DAOCients = new ClientsService(factory);


        List<Clients> clientsList =  DAOCients.readAll();

        for (Clients clients: clientsList){
            idData = clients.getId();
            firstNameData = clients.getFirstName();
            lastNameData = clients.getLastName();
            patronymicData = clients.getPatronymic();
//            birthdayData = clients.getBirthDay();
            registrationDateData = clients.getRegistrationDate();
            emailData = clients.getEmail();
            phoneData = clients.getPhone();
//            genderData = clients.getGender();
            photoPathData = clients.getPhotoPath();


            clientsObservableList.add(clients);

            System.out.println(clients.toString());
        }

    }

    @FXML
    public void firstNameOnEditCommit(TableColumn.CellEditEvent<Clients, String> clientsStringCellEditEvent) {
        Clients client =clientsStringCellEditEvent.getRowValue();

        System.out.println(client.toString());

        deleteButton.setOnAction(ActionEvent ->{
            DAO<Clients,Integer> clientsDAO = new ClientsService(factory);
            clientsDAO.delete(client);
            deleteButton.getScene().getWindow().hide();
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
            factory.close();
        });

    }
}

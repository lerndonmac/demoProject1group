package controlers;

import DAO.DAO;
import DAO.Service.ClientsService;
import DAO.Service.GenderService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.ClientServicePOJO;
import model.Clients;
import model.Gender;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ClientsTableController {
    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    public ObservableList<Clients> clientsObservableList = FXCollections.observableArrayList();
    private ObservableList<Gender> genderObservableList = FXCollections.observableArrayList();

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
    public TableColumn<Clients, Gender> genderCodeColumn;@FXML
    public TextField countOfRows;@FXML
    public Button countOfRowsSubmit;@FXML
    public Button createButton;@FXML
    public Button updateButton;@FXML
    public Button deleteButton;@FXML
    public TableColumn<Clients, Integer> CountOfEntering;
    public TableColumn<Clients, Date> lastDateOfEnteringColumn;
    public ComboBox<Gender> genderFilterCombo;

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
        Gender gender = new Gender("All");
        genderObservableList.add(gender);
        genderFilterCombo.setItems(genderObservableList);
        genderFilterCombo.setOnAction(actionEvent -> {
                    ObservableList<Clients> products = FXCollections.observableArrayList();
                    if (genderFilterCombo.getValue().equals(gender)){clientsTableView.setItems(clientsObservableList);}else {
                        for (int i = 0; i < clientsObservableList.size() - 1; i++) {
                            Clients p = clientsObservableList.get(i);
                            if (p.getGender().getGenderName().equals(genderFilterCombo.getValue().getGenderName())) {
                                products.add(p);
                            }
                        }


                        clientsTableView.setItems(products);


                    }
                    });
        countOfRowsSubmit.setOnAction(ActionEvent->{
            KostilClass.cont = Integer.parseInt(countOfRows.getText());
            countOfRowsSubmit.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            try {
                URL url = new File("C:\\JavaProjects\\demoProject1group\\src\\main\\java\\view\\ClientsTable.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                primaryStage.setTitle("Clients");
                primaryStage.setScene(new Scene(root));
                primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/service_logo.png")));
                primaryStage.initModality(Modality.APPLICATION_MODAL);
                primaryStage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        updateButton.setOnAction(ActionEvent ->{
            Stage primaryStage = new Stage();
            try {
                URL url = new File("C:\\JavaProjects\\demoProject1group\\src\\main\\java\\view\\UpdateClientWindow.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                primaryStage.setTitle("Update Client");
                primaryStage.setScene(new Scene(root));
                primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/service_logo.png")));
                primaryStage.initModality(Modality.APPLICATION_MODAL);
                primaryStage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        createButton.setOnAction(ActionEvent ->{
            Stage primaryStage = new Stage();
            try {
                URL url = new File("C:\\JavaProjects\\demoProject1group\\src\\main\\java\\view\\CreateWindow.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                primaryStage.setTitle("Create Client");
                primaryStage.setScene(new Scene(root));
                primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/service_logo.png")));
                primaryStage.initModality(Modality.APPLICATION_MODAL);
                primaryStage.showAndWait();



            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        initData(KostilClass.cont);

        idColumn.setCellValueFactory(new PropertyValueFactory<Clients, Integer>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("lastName"));
        patronymicColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("patronymic"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("birthDay"));
        registrationDateColumn.setCellValueFactory(new PropertyValueFactory<Clients, Date>("registrationDate"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Clients, String>("phone"));
        genderCodeColumn.setCellValueFactory(new PropertyValueFactory<Clients, Gender>("gender"));
        CountOfEntering.setCellValueFactory(new PropertyValueFactory<Clients, Integer>("countOfEntering"));
        lastDateOfEnteringColumn.setCellValueFactory(u ->{if (
                u.getValue().getClientServiceS().stream().max(Comparator.comparing(ClientServicePOJO::getStartTime)).isPresent())
        {
         return new SimpleObjectProperty<Date>(
                u.getValue().getClientServiceS().stream().max(Comparator.comparing(ClientServicePOJO::getStartTime))
                        .get().getStartTime());
        }else {
            return null;
        }
        });





        clientsTableView.getSelectionModel().selectedItemProperty().addListener(((observable,oldUser,product)-> {UpdateClientWindowController.setClient(product);}));
        clientsTableView.setItems(clientsObservableList);
    }

    public void initData(Integer count) {
        DAO<Clients, Integer> DAOCients = new ClientsService(factory);
        DAO<Gender, Integer> DAOGender = new GenderService(factory);
        genderObservableList.addAll(DAOGender.readAll());


        List<Clients> clientsList = DAOCients.readAll();

        for (int i = 0; i < count; i++) {
            Clients clients = clientsList.get(i);
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

        UpdateClientWindowController.setClient(client);
        System.out.println(client.toString());

        deleteButton.setOnAction(ActionEvent ->{
            DAO<Clients,Integer> clientsDAO = new ClientsService(factory);
            clientsDAO.delete(client);
            deleteButton.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/view\\ClientsTable.fxml"));
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

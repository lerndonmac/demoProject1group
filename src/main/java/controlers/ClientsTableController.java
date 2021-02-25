package controlers;

import DAO.DAO;
import DAO.Service.ClientsService;
import DAO.Service.GenderService;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.css.Style;
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
import javafx.util.Callback;
import model.ClientServicePOJO;
import model.Clients;
import model.Gender;
import model.TagsPOJO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ClientsTableController {
    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    public ObservableList<Clients> clientsObservableList = FXCollections.observableArrayList();

    private final ObservableList<Gender> genderObservableList = FXCollections.observableArrayList();

    private Clients choosenClient;
    private static final Gender gender = new Gender("All");

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
    public TableColumn<Clients, String> tagColumn;
    public ComboBox<Integer> countOfRows;@FXML
    public Button serviceButton;@FXML
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

        DAO<Clients , Integer> DAOClient = new ClientsService(new Configuration().configure().buildSessionFactory());
        countOfRows.setItems(FXCollections.observableArrayList(Arrays.asList(10, 20, 30, 40, 50, DAOClient.readAll().size())));
        countOfRows.getSelectionModel().selectedItemProperty().addListener((old, neo, real)->{
            KostilClass.cont = countOfRows.getValue();
            initData(KostilClass.cont);

        });
        serviceButton.setOnAction(actionEvent -> {
            ServiceListController.clients = choosenClient;
            Stage primaryStage = new Stage();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/ServicesWindow.fxml"));
                primaryStage.setTitle("Services of "+choosenClient.getFirstName());
                primaryStage.setScene(new Scene(root));
                primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/service_logo.png")));
                primaryStage.initModality(Modality.APPLICATION_MODAL);
                primaryStage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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
        updateButton.setOnAction(ActionEvent ->{
            Stage primaryStage = new Stage();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/UpdateClientWindow.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("/view/CreateWindow.fxml"));
                primaryStage.setTitle("Create Client");
                primaryStage.setScene(new Scene(root));
                primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/service_logo.png")));
                primaryStage.initModality(Modality.APPLICATION_MODAL);
                primaryStage.showAndWait();



            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        deleteButton.setOnAction(actionEvent -> {

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
        lastDateOfEnteringColumn.setCellValueFactory(clientsDateCellDataFeatures -> {
            if (clientsDateCellDataFeatures.getValue().getClientServiceS().stream().max(Comparator.comparing(ClientServicePOJO::getStartTime)).isPresent())//Present check if have not clientService
            {
            return new SimpleObjectProperty<>(
            clientsDateCellDataFeatures.getValue()
                    .getClientServiceS()
                    .stream()
                    .max(Comparator.comparing(ClientServicePOJO::getStartTime))
                    .get()
                    .getStartTime());}
            else return new SimpleObjectProperty<>();
        });
        clientsTableView.getSelectionModel().selectedItemProperty().addListener(((observable,oldUser,product)-> {
            UpdateClientWindowController.setClient(product);
            choosenClient = product;
            System.out.println(choosenClient);
        }));
        tagColumn.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getTags().iterator().next().getColor() ));
       tagColumn.setCellFactory(column -> new TableCell<>() {
           @Override
           protected void updateItem(String item, boolean empty) {
               if(item != null || !empty){
                   if(item.equalsIgnoreCase("green"))
                       setStyle("-fx-background-color: #80ee80");
                   if(item.equalsIgnoreCase("red"))
                       setStyle("-fx-background-color: #db9898");
                   if(item.equalsIgnoreCase("GRAY"))
                       setStyle("-fx-background-color: #555555");

               }
           }
       });
        clientsTableView.setItems(clientsObservableList);

    }

    public void initData(Integer count) {
        DAO<Clients, Integer> DAOCients = new ClientsService(factory);
        DAO<Gender, Integer> DAOGender = new GenderService(factory);
        genderObservableList.clear();
        genderObservableList.add(gender);
        genderObservableList.addAll(DAOGender.readAll());


        List<Clients> clientsList = DAOCients.readAll();
        clientsObservableList.clear();


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
    public static List<TagsPOJO> setToList (Set<TagsPOJO> set){
        return new ArrayList<TagsPOJO>(new ArrayList<>(set));
    }

}
//
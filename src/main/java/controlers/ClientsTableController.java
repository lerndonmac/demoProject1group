package controlers;

import DAO.DAO;
import DAO.Service.ClientsService;
import DAO.Service.GenderService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.io.IOException;
import java.util.*;

public class ClientsTableController {
    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    public ObservableList<Clients> clientsObservableList = FXCollections.observableArrayList();

    private List<Clients> clientsList;
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
    public TableColumn<Clients, Integer> CountOfEntering;@FXML
    public TableColumn<Clients, Date> lastDateOfEnteringColumn;@FXML
    public ComboBox<Gender> genderFilterCombo;@FXML
    public Pagination paginationId;@FXML
    public Label countText;
    @FXML
    public ComboBox<String> filterSeekerCombo;
    @FXML
    public TextField seekerField;
    @FXML

    public void initialize() {
        createButton.setVisible(false);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);

        DAO<Clients , Integer> DAOClient = new ClientsService(new Configuration().configure().buildSessionFactory());
        countOfRows.setItems(FXCollections.observableArrayList(Arrays.asList(10, 50,200, DAOClient.readAll().size())));
        countOfRows.setValue(countOfRows.getItems().get(countOfRows.getItems().size()-1));
        countOfRows.valueProperty().addListener((old, neo, real)-> {
            countOfRows.setValue(real);
            countText.setText("Колличество записей: "+ countOfRows.getValue());
            initData();
            paginationId.setPageCount((int) Math.ceil(clientsObservableList.size() * 1.0 / countOfRows.getValue()));

            clientsTableView.setItems(
                    FXCollections.observableArrayList(clientsList.subList(paginationId.getCurrentPageIndex(), real))
            );

            paginationId.currentPageIndexProperty().addListener(
                    (observable1, oldValue1, newValue1) -> {
                        if (countOfRows.getValue() * (newValue1.intValue() + 1) < clientsList.size() ) {
                            clientsTableView.setItems(
                                    FXCollections.observableArrayList(
                                            clientsObservableList.subList(
                                                    (countOfRows.getValue() * (newValue1.intValue() + 1)
                                                            - countOfRows.getValue()),
                                                    countOfRows.getValue() * (newValue1.intValue() + 1)
                                            )
                                    )
                            );
                        }else {
                            clientsTableView.setItems(
                                    FXCollections.observableArrayList(
                                            clientsObservableList.subList(
                                                    (countOfRows.getValue() * (newValue1.intValue() + 1)
                                                            - countOfRows.getValue()), clientsObservableList.size()
                                            )
                                    )
                            );
                        }
                    }

            );
        });
        initData();
        paginationId.setPageCount(1);
        paginationId.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
        countText.setText(countText.getText() + countOfRows.getValue());

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
                    if (genderFilterCombo.getValue().equals(gender)){clientsTableView.setItems(clientsObservableList);}
                    else {
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

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        patronymicColumn.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthDay"));
        registrationDateColumn.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        genderCodeColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        CountOfEntering.setCellValueFactory(new PropertyValueFactory<>("countOfEntering"));
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
            deleteButton.setOnAction(actionEvent -> {
                DAO<Clients, Integer> clientsDAO = new ClientsService(factory);
                if (product.getClientServiceS().isEmpty()) {
                    clientsDAO.delete(product);
                }else {countText.setText(" запрещенно удаление клиента с данными о посещении");}
                initialize();
            });
            UpdateClientWindowController.setClient(product);
            choosenClient = product;
            System.out.println(choosenClient);
        }));
        tagColumn.setCellValueFactory(c-> new SimpleObjectProperty<>(c.getValue().getTags().iterator().next().getColor() ));
       tagColumn.setCellFactory(column -> new TableCell<>() {
           @Override
           protected void updateItem(String item, boolean empty) {
               if(item != null || !empty){
                   assert item != null;
                   if(item.equalsIgnoreCase("green"))
                       setStyle("-fx-background-color: #80ee80");
                   if(item.equalsIgnoreCase("red"))
                       setStyle("-fx-background-color: #db9898");
                   if(item.equalsIgnoreCase("GRAY"))
                       setStyle("-fx-background-color: #555555");

               }
           }
       });
        clientsTableView.setItems(FXCollections.observableArrayList(clientsList));
        if (LoginWinControl.rouleCheker){
            createButton.setVisible(true);
            updateButton.setVisible(true);
            deleteButton.setVisible(true);
        }
        filterSeekerCombo.setItems(FXCollections.observableArrayList("FIO", "Phone", "Email"));
        filterSeekerCombo.setValue(filterSeekerCombo.getItems().get(0));

            seekerField.setOnKeyPressed(actionEvent -> {
                ObservableList<Clients> clients = FXCollections.observableArrayList();
                if (filterSeekerCombo.getValue().equals("Phone")){
                    for (Clients client: clientsObservableList){

                        if (client.getPhone().contains(seekerField.getText())){
                            clients.add(client);

                        }
                    }
                    clientsTableView.setItems(clients);
                }
                if (filterSeekerCombo.getValue().equals("FIO")){
                    for (Clients client: clientsObservableList){
                        if (client.getFirstName().contains(seekerField.getText())
                                ||client.getLastName().contains(seekerField.getText())
                                ||client.getPatronymic().contains(seekerField.getText())){

                            clients.add(client);
                        }
                    }
                    clientsTableView.setItems(clients);
                }
                if (filterSeekerCombo.getValue().equals("Email")){
                    for (Clients client: clientsObservableList){
                        if (client.getEmail().contains(seekerField.getText())){
                            clients.add(client);
                        }
                    }
                    clientsTableView.setItems(clients);
                }
            });
        }

    public void initData() {
        int count = countOfRows.getValue();
        DAO<Clients, Integer> DAOCients = new ClientsService(factory);
        DAO<Gender, Integer> DAOGender = new GenderService(factory);
        genderObservableList.clear();
        clientsObservableList.clear();
        genderObservableList.add(gender);
        genderObservableList.addAll(DAOGender.readAll());


        clientsList = new ArrayList<>();
        clientsObservableList.addAll(DAOCients.readAll());
        clientsList.clear();

        if (countOfRows.getValue() < clientsObservableList.size()) {
            for (int i = 0; i < count; i++) {
                Clients clients = clientsObservableList.get(i);
                clientsList.add(clients);
                System.out.println(clients.toString());
            }
        }else clientsList = clientsObservableList;
    }
}
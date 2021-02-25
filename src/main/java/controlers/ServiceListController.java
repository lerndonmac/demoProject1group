package controlers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.ClientServicePOJO;
import model.Clients;

import java.util.Date;
import java.util.stream.Collector;

public class ServiceListController {
    ObservableList<Date> dateObservableList = FXCollections.observableArrayList();
    public static Clients clients;
    public ListView filesListView;
    public ListView<Date> DatelistView;

    @FXML
    public void initialize(){
        clients.getClientServiceS().forEach(date -> dateObservableList.add(date.getStartTime()));
        DatelistView.setItems(dateObservableList);
    }
}

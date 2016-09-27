package ContactList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    TextField nameTextF;
    @FXML
    TextField phoneTextF;
    @FXML
    TextField emailTextF;
    @FXML
    ListView contactListView;

   ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void addContact(){
        if(nameTextF != null){
            if(phoneTextF != null){
                if(emailTextF != null){
                    String n = nameTextF.getText();
                    String p = phoneTextF.getText();
                    String e = emailTextF.getText();
                    Contact contact = new Contact(n, p, e);
                    contacts.add(contact);
                    nameTextF.clear();
                    phoneTextF.clear();
                    emailTextF.clear();
                }
            }
        }
    }

    public void removeContact(){
        Contact contact = (Contact) contactListView.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contactListView.setItems(contacts);
    }
}

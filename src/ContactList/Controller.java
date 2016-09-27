package ContactList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
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
                    saveContactList(contact, FILE_NAME);
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
       // contacts.addAll(<Collection>);
        contactListView.setItems(contacts);
    }

    static String FILE_NAME = "ContactList.json";

    public ArrayList<Contact> loadContactList(String fileName) {
        File f = new File(fileName);
        try{
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] contents = new char[fileSize];
            fr.read(contents, 0, fileSize);
            JsonParser parser = new JsonParser();
            return parser.parse(contents, Contact.class);
        } catch (Exception e) {
            System.out.println("Couldn't load file!");
            return null;
        }
    }

    public void saveContactList(Contact contact, String fileName)  {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(contact);
        File f = new File(fileName);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        }catch (Exception e) {
            System.out.println("Couldn't save to file!");
        }
    }
}
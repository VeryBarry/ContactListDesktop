package ContactList;

import java.util.ArrayList;

/**
 * Created by VeryBarry on 9/28/16.
 */
public class ContactWrapper {
    new ArrayList<Contact> contactWrapper;

    public ContactWrapper(ArrayList<Contact> contactWrapper) {
        this.contactWrapper = contactWrapper;
    }

    public ArrayList<Contact> getContactWrapper() {
        return contactWrapper;
    }

    public void setContactWrapper(ArrayList<Contact> contactWrapper) {
        this.contactWrapper = contactWrapper;
    }
}

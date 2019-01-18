package buddies.ui.button;

import buddies.AddressBook;
import buddies.ui.model.AddressBookTableModel;

import java.awt.event.ActionListener;

public abstract class TableActionListener implements ActionListener {
    private AddressBookTableModel addressBookTableModel;

    public TableActionListener(AddressBookTableModel addressBookTableModel)
    {
        this.addressBookTableModel = addressBookTableModel;
    }

    protected AddressBook getAddressBook() {
        return addressBookTableModel.getAddressBook();
    }

    protected void update() {
        this.addressBookTableModel.fireTableDataChanged();
    }

}

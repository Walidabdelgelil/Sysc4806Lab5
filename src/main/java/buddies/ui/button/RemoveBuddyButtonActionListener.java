package buddies.ui.button;

import buddies.ui.model.AddressBookTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveBuddyButtonActionListener extends TableActionListener {

    private JTable addressBookTable;

    public RemoveBuddyButtonActionListener(JTable addressBookTable)
    {
        super((AddressBookTableModel) addressBookTable.getModel());
        this.addressBookTable = addressBookTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = addressBookTable.getSelectedRow();

        if (selectedRow == -1 || addressBookTable.isEditing()) {
            return;
        }

        super.getAddressBook().removeBuddy(selectedRow);
        super.update();
    }
}

package application.ui.button;

import application.model.BuddyInfo;
import application.ui.model.AddressBookTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddBuddyButtonActionListener extends TableActionListener {

    public AddBuddyButtonActionListener(AddressBookTableModel addressBookTableModel)
    {
        super(addressBookTableModel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog("Please enter the name of a buddy:");

        // A null value means that the user pressed 'Cancel'. Return and do not continue
        if(name == null)
            return;

        String address = JOptionPane.showInputDialog("Please enter the address of a buddy:");

        // A null value means that the user pressed 'Cancel'. Return and do not continue
        if(address == null)
            return;

        String phoneNumber = JOptionPane.showInputDialog("Please enter the phone number of a buddy:");

        // A null value means that the user pressed 'Cancel'. Return and do not continue
        if(phoneNumber == null)
            return;

        BuddyInfo buddyInfo = new BuddyInfo(name, address, phoneNumber);
        super.getAddressBook().addBuddy(buddyInfo);
        super.update();
    }
}

package application.ui.model;

import application.model.AddressBook;
import application.model.BuddyInfo;

import javax.swing.table.AbstractTableModel;


public class AddressBookTableModel extends AbstractTableModel {
    private final static int NAME_COLUMN_INDEX = 0;
    private final static int ADDRESS_COLUMN_INDEX = 1;
    private final static int PHONE_COLUMN_INDEX = 2;
    private final static String[] columnNames = {"Name", "Address", "Phone Number"};

    private AddressBook addressBook;

    public AddressBookTableModel(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getRowCount() {
        return addressBook.size();
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        BuddyInfo info = addressBook.getBuddyInfoList().get(rowIndex);
        String newVal = value.toString();

        switch (columnIndex) {
            case NAME_COLUMN_INDEX:
                info.setName(newVal);
                break;
            case ADDRESS_COLUMN_INDEX:
                info.setAddress(newVal);
                break;
            case PHONE_COLUMN_INDEX:
                info.setPhoneNumber(newVal);
                break;
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        BuddyInfo buddy = addressBook.getBuddyInfoList().get(rowIndex);
        switch (columnIndex) {
            case NAME_COLUMN_INDEX:
                return buddy.getName();
            case ADDRESS_COLUMN_INDEX:
                return buddy.getAddress();
            case PHONE_COLUMN_INDEX:
                return buddy.getPhoneNumber();
        }

        return "";
    }
}
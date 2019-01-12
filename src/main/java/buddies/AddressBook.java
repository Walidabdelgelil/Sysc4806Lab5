package buddies;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    private Integer id = null;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddyInfoList;

    /**
     * Creates a new address book
     */
    public AddressBook() {
        this.buddyInfoList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    /**
     * @param id Set the ID for database persistence
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The buddy info list
     */
    protected List<BuddyInfo> getBuddyInfoList() {
        return buddyInfoList;
    }

    /**
     * Set the buddy info list
     *
     * @param buddyInfoList
     */
    protected void setBuddyInfoList(List<BuddyInfo> buddyInfoList) {
        this.buddyInfoList = buddyInfoList;
    }

    /**
     * Add a buddy to the address book
     *
     * @param buddyInfo The buddy info to add. If this is null, nothing is added to the address book.
     */
    public void addBuddy(BuddyInfo buddyInfo) {
        if (buddyInfo == null)
            return;

        this.buddyInfoList.add(buddyInfo);
    }

    /**
     * Remove a buddy at a given index
     *
     * @param buddyInfo The buddy info object to be removed. Does nothing if the object does not exist.
     */
    public void removeBuddy(BuddyInfo buddyInfo) {
        this.buddyInfoList.remove(buddyInfo);
    }

    /**
     * Remove a buddy at a given index
     *
     * @param index The index of the buddy to be removed
     */
    public void removeBuddy(int index) {
        this.buddyInfoList.remove(index);
    }

    /**
     * @return The size of the buddy list
     */
    public int size() {
        return this.buddyInfoList.size();
    }

    /**
     * @return The string representation of the address book
     */
    public String toString() {
        return buddyInfoList.toString();
    }

    /**
     * Checks two address books for equivalence
     *
     * @param o The other address book
     * @return True if both address books are equivalent
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof AddressBook))
            return false;

        AddressBook otherBook = (AddressBook) o;

        if (otherBook.id != null && this.id != null)
            return otherBook.id.equals(this.id);

        // Delegate equals to the array list if the object has no ID
        return this.buddyInfoList.equals(otherBook.buddyInfoList);
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        // Create our buddies
        BuddyInfo michaelInfo = new BuddyInfo("Michael", "School", "555-1234");
        BuddyInfo babakInfo = new BuddyInfo("Babak", "Home", "555-1244");

        // Add buddies to our address book
        addressBook.addBuddy(michaelInfo);
        addressBook.addBuddy(babakInfo);

        System.out.println(addressBook);
    }
}

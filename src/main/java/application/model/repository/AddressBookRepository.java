package application.model.repository;

import application.model.AddressBook;
import application.model.BuddyInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    List<AddressBook> findByBuddyInfoListContaining(BuddyInfo buddyInfo);
}

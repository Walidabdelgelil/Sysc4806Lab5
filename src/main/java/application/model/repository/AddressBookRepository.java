package application.model.repository;

import application.model.AddressBook;
import application.model.BuddyInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    List<AddressBook> findByBuddyInfoListContaining(BuddyInfo buddyInfo);
}

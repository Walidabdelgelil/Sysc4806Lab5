package persistence;

import buddies.AddressBook;
import buddies.BuddyInfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersistenceTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private BuddyInfo buddyOne;
    private BuddyInfo buddyTwo;
    private AddressBook addressBook;


    @Before
    public void setUp()
    {
        // Connecting to the database through EntityManagerFactory
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa-test");

        // Create the entity manager and the transaction
        this.entityManager = entityManagerFactory.createEntityManager();

        this.transaction = entityManager.getTransaction();

        // Creating two buddies
        buddyOne = new BuddyInfo("Buddy One", "", "");

        buddyTwo = new BuddyInfo("Buddy Two", "", "");

        // Create the address book
        addressBook = new AddressBook();
    }

    @After
    public void tearDown()
    {
        // Close connection before asserting
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void testAddressBookCascadePersistence() {
        addressBook.addBuddy(buddyOne);
        addressBook.addBuddy(buddyTwo);

        // Persist the address book without persisting the buddy info objects (cascading persistence)
        transaction.begin();
        entityManager.persist(addressBook);
        transaction.commit();

        // Query the entities
        Query q = entityManager.createQuery("SELECT a FROM AddressBook a");

        // Only one address book should exist
        List<AddressBook> results = q.getResultList();
        assertEquals(1, results.size());

        AddressBook addressBookResult = results.get(0);

        // Address book should be equivalent to the initial address book object
        // (This will only end up comparing IDs, so lets compare the buddy list size below)
        assertEquals(addressBook, addressBookResult);
        assertEquals(addressBook.size(), addressBookResult.size());


    }

    @Test
    public void testBuddyPersistence() {
        transaction.begin();

        // Persisting the buddy info entity objects
        entityManager.persist(buddyOne);
        entityManager.persist(buddyTwo);

        transaction.commit();

        // Get the buddy info entities
        Query q = entityManager.createQuery("SELECT b FROM BuddyInfo b");

        List<BuddyInfo> results = q.getResultList();

        assertEquals(2, results.size());
        assertTrue(results.contains(buddyOne));
        assertTrue(results.contains(buddyTwo));

    }
}

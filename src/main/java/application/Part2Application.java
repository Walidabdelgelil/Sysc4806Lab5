package application;

import application.model.AddressBook;
import application.model.BuddyInfo;
import application.model.repository.AddressBookRepository;
import application.model.repository.BuddyInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Part2Application {

    private static final Logger log = LoggerFactory.getLogger(Part2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Part2Application.class, args);
    }

    @Bean
    public CommandLineRunner testRepositories(BuddyInfoRepository buddyInfoRepository, AddressBookRepository addressBookRepository) {
        return (args) -> {

            // Create buddies
            BuddyInfo michaelBuddyInfo = new BuddyInfo("Michael", "Carleton", "555-1234");
            BuddyInfo babakBuddyInfo = new BuddyInfo("Babak", "Carleton", "555-1235");

            // Create address book
            AddressBook addressBook = new AddressBook();
            addressBook.addBuddy(michaelBuddyInfo);
            addressBook.addBuddy(babakBuddyInfo);

            addressBookRepository.save(addressBook);

            // Query all buddies
            log.info("");
            log.info("BuddyInfo objects found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddyInfo : buddyInfoRepository.findAll()) {
                log.info(buddyInfo.toString());
            }
            log.info("");



            log.info("");
            log.info("AddressBook objects found with Michael's buddy info:");
            log.info("-------------------------------");
            for (AddressBook a : addressBookRepository.findByBuddyInfoListContaining(michaelBuddyInfo)) {
                log.info(a.toString());
            }
            log.info("");
        };
    }

}
package application.model.repository;

import application.model.BuddyInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(String name);
    List<BuddyInfo> findByAddress(String address);
    List<BuddyInfo> findByPhoneNumber(String phoneNumber);
}

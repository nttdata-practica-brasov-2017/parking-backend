package ro.nttdata.bv.parking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.nttdata.bv.parking.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository <User, Long>{

    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    List<User> findAll();

}

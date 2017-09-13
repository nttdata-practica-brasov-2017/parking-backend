package ro.nttdata.bv.parking.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ro.nttdata.bv.parking.entity.User;
import ro.nttdata.bv.parking.repository.UserRepository;

import java.util.Arrays;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean isUserValid(User user) {
        userRepository.deleteAll();

        User ana = new User();
        ana.setUsername("ana");
        ana.setPassword("ana123");

        User bogdan = new User();
        bogdan.setUsername("bogdan");
        bogdan.setPassword("bogdan123");

        userRepository.save(Arrays.asList(ana, bogdan));

        User result = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return result != null;
    }
}

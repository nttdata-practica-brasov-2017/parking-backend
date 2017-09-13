package ro.nttdata.bv.parking.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.nttdata.bv.parking.entity.Assignment;
import ro.nttdata.bv.parking.entity.Spot;
import ro.nttdata.bv.parking.entity.User;
import ro.nttdata.bv.parking.repository.AssignmentRepository;
import ro.nttdata.bv.parking.repository.SpotRepository;
import ro.nttdata.bv.parking.repository.UserRepository;

import java.util.Arrays;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpotRepository spotRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Transactional
    public boolean isUserValid(User user) {
        userRepository.deleteAll();

        User ana = new User();
        ana.setUsername("ana");
        ana.setPassword("ana123");

        User bogdan = new User();
        bogdan.setUsername("bogdan");
        bogdan.setPassword("bogdan123");

        userRepository.save(Arrays.asList(ana, bogdan));

        Spot spot = new Spot();
        spot.setNumber(1);
        spotRepository.save(spot);

        Assignment assignment = new Assignment();
        assignment.setUser(ana);
        assignment.setSpot(spot);
        assignmentRepository.save(assignment);

        User result = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return result != null;
    }
}

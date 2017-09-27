package ro.nttdata.bv.parking.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.nttdata.bv.parking.entity.Assignment;
import ro.nttdata.bv.parking.entity.Spot;
import ro.nttdata.bv.parking.entity.User;
import ro.nttdata.bv.parking.error.ParkingException;
import ro.nttdata.bv.parking.repository.AssignmentRepository;
import ro.nttdata.bv.parking.repository.SpotRepository;
import ro.nttdata.bv.parking.repository.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpotRepository spotRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    public void createUser(User user) {

        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new ParkingException("User already exist");
        }
        userRepository.save(user);
    }

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new ParkingException("User does not exist");
        }
        userRepository.delete(user);
    }

    public void createSpot(Spot spot) {

        if (spotRepository.findByNumberAndFloor(spot.getNumber(), spot.getFloor()) != null) {
            throw new ParkingException("Spot already exist");
        }

        spotRepository.save(spot);
    }

    public void deleteSpot(int number, int floor) {
        Spot spot = spotRepository.findByNumberAndFloor(number, floor);

        if (spot == null) {
            throw new ParkingException("Spot does not exist");
        }
        spotRepository.delete(spot);
    }

    public void createAssignment(String username, int number, int floor) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new ParkingException("User does not exist");
        }

        if (assignmentRepository.findByUser(user) != null) {
            throw new ParkingException("User already has an Assignment");
        }

        Spot spot = spotRepository.findByNumberAndFloor(number, floor);

        if (spot == null) {
            throw new ParkingException("Spot does not exist");
        }

        if(assignmentRepository.findBySpot(spot) != null){
            throw new ParkingException("Spot is already taken");
        }

        Assignment assignment = new Assignment();
        assignment.setSpot(spot);
        assignment.setUser(user);

        assignmentRepository.save(assignment);
    }

    public void deleteAssignment(String username) {
        Assignment assignment = assignmentRepository.findByUserName(username);

        if (assignment == null) {
            throw new ParkingException("Assignment does not exist");
        }
        assignmentRepository.delete(assignment);
    }
}

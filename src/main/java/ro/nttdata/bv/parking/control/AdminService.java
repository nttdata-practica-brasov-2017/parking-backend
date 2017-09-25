package ro.nttdata.bv.parking.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.nttdata.bv.parking.entity.Assignment;
import ro.nttdata.bv.parking.entity.Spot;
import ro.nttdata.bv.parking.entity.User;
import ro.nttdata.bv.parking.repository.AssignmentRepository;
import ro.nttdata.bv.parking.repository.SpotRepository;
import ro.nttdata.bv.parking.repository.UserRepository;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private SpotRepository spotRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public List<Spot> getAllSpots() {
        return spotRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void addSpot(Spot spot) {
        spotRepository.save(spot);
    }

    public void addAssigment(Long userId, Long spotId) {
        Assignment assignment = new Assignment();
        assignment.setUser(userRepository.findOne(userId));
        assignment.setSpot(spotRepository.findOne(spotId));
        assignmentRepository.save(assignment);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.delete(id);
    }

    public void deleteSpot(Long id) {
        spotRepository.delete(id);
    }


}

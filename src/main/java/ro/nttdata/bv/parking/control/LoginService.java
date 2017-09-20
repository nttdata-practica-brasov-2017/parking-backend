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
import ro.nttdata.bv.parking.repository.VacancyRepository;

import java.util.Arrays;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpotRepository spotRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private VacancyRepository vacancyRepository;

    @Transactional
    public UserInfo getUser(User credentials) {
        User user = userRepository.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
        if (user != null) {
            UserInfo response = new UserInfo();
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setUsername(user.getUsername());
            response.setType(assignmentRepository.findByUser(user) != null
                    ? UserInfo.UserType.PERMANENT : UserInfo.UserType.TEMPORARY);
            return response;
        } else {
            throw new ParkingException("Failed login!");
        }
    }

    public static class UserInfo {

        public enum UserType{
            PERMANENT,
            TEMPORARY
        }

        private String username;
        private String firstName;
        private String lastName;
        private UserType type;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public UserType getType() {
            return type;
        }

        public void setType(UserType type) {
            this.type = type;
        }
    }
}

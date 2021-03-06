package ro.nttdata.bv.parking.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.nttdata.bv.parking.entity.User;
import ro.nttdata.bv.parking.entity.Vacancy;
import ro.nttdata.bv.parking.error.ParkingException;
import ro.nttdata.bv.parking.repository.AssignmentRepository;
import ro.nttdata.bv.parking.repository.UserRepository;
import ro.nttdata.bv.parking.repository.VacancyRepository;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Transactional
    public void createBookings(String username, Integer number, Integer floor, Date date) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new ParkingException("User does not exist");
        }

        Vacancy vacancy = vacancyRepository.findByDateAndFloorAndNumber(date, floor, number);

        if (vacancy == null || vacancy.getBookedBy() != null) {
            throw new ParkingException("Spot is not free for the requested date");
        }

        if (assignmentRepository.findByUser(user) != null) {
            throw new ParkingException("User with permanent spot can not book a vacancy");
        }

        if (vacancyRepository.findByUsernameAndDate(username, date) != null) {
            throw new ParkingException("User has a spot previously booked for that day");
        }

        vacancy.setBookedBy(user);
    }

    public List<Vacancy> getBookings(String username, Date date) {
        return vacancyRepository.findByUsernameAfterDate(username, date);
    }
}

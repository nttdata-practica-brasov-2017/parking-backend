package ro.nttdata.bv.parking.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.nttdata.bv.parking.entity.User;
import ro.nttdata.bv.parking.entity.Vacancy;
import ro.nttdata.bv.parking.error.ParkingException;
import ro.nttdata.bv.parking.repository.UserRepository;
import ro.nttdata.bv.parking.repository.VacancyRepository;

import java.util.Date;

@Service
public class BookingService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void createBookings(String username, Integer number, Integer floor, Date date){
       User user = userRepository.findByUsername(username);
       Vacancy vacancy = vacancyRepository.findByDateAndFloorAndNumber(date, floor, number);
       
       if(vacancy.getBookedBy() == null) {
           vacancy.setBookedBy(user);
       } else {
           throw new ParkingException("Requested spot is not free");
       }

    }
}

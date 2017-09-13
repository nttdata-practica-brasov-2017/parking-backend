package ro.nttdata.bv.parking.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.nttdata.bv.parking.entity.Spot;
import ro.nttdata.bv.parking.entity.Vacancy;
import ro.nttdata.bv.parking.repository.SpotRepository;
import ro.nttdata.bv.parking.repository.VacancyRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private SpotRepository spotRepository;

    public List<Vacancy> getVacancies(Date date) {

        return vacancyRepository.findVacanciesByDateAndBookedByNotNull(date);
    }

    @Transactional
    public void createVacancies(String username, Date from, Date to) {
        Spot spot = spotRepository.findByUsername(username);

        List<Date> dates = getDateBetween(from, to);
        for (Date date : dates){
           Vacancy vacancy =  createVacancy(spot,date);
           vacancyRepository.save(vacancy);
        }
    }

    private Vacancy createVacancy(Spot spot, Date date) {
        Vacancy vacancy = new Vacancy();
        vacancy.setSpot(spot);
        vacancy.setDate(date);
        vacancy.setVacatedAt(new Date());
        return vacancy;
    }

    private List<Date> getDateBetween(Date from, Date to) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(from);

        List<Date> dates = new ArrayList<>();
        while (!calendar.getTime().after(to)) {
            dates.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dates;
    }
}

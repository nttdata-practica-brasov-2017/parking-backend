package ro.nttdata.bv.parking.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.nttdata.bv.parking.entity.Spot;
import ro.nttdata.bv.parking.entity.Vacancy;
import ro.nttdata.bv.parking.error.ParkingException;
import ro.nttdata.bv.parking.repository.SpotRepository;
import ro.nttdata.bv.parking.repository.VacancyRepository;

import java.util.*;

@Service
public class VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private SpotRepository spotRepository;

    public List<Vacancy> getVacancies(Date date) {
        return vacancyRepository.findVacanciesByDateAndBookedByNull(date);
    }

    @Transactional
    public void createVacancies(String username, Date from, Date to) {
        Spot spot = spotRepository.findByUsername(username);

        if (spot == null) {
            throw new ParkingException("User does not have a spot assigned");
        }

        validateDatesAreAvailable(spot, from, to);

        List<Date> dates = getDateBetween(from, to);
        for (Date date : dates) {
            Vacancy vacancy = createVacancy(spot, date);
            vacancyRepository.save(vacancy);
        }
    }

    private void validateDatesAreAvailable(Spot spot, Date from, Date to) {
        List<Vacancy> vacancies = vacancyRepository.findVacanciesBySpotAndDateBetween(spot, from, to);
        if (vacancies != null && vacancies.size() > 0) {
            throw new ParkingException("Spot is already vacated for some of the dates in the interval");
        }
    }

    public List<Vacancy> getUserVacancies(String username, Date date) {
        return vacancyRepository.findByAssigneeAndDateAfter(username, date);
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

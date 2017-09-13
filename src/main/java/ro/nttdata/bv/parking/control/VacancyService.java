package ro.nttdata.bv.parking.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ro.nttdata.bv.parking.entity.Vacancy;
import ro.nttdata.bv.parking.repository.VacancyRepository;

import java.util.Date;
import java.util.List;

@Service
public class VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    public List<Vacancy> getVacancies(Date date) {

        return vacancyRepository.findVacanciesByDate(date);
    }
}

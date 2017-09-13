package ro.nttdata.bv.parking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.nttdata.bv.parking.entity.Vacancy;

import java.util.Date;
import java.util.List;

@Repository
public interface VacancyRepository extends CrudRepository <Vacancy, Long> {

    List<Vacancy> findVacanciesByDate(Date date);
}


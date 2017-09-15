package ro.nttdata.bv.parking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.nttdata.bv.parking.entity.Vacancy;

import java.util.Date;
import java.util.List;

@Repository
public interface VacancyRepository extends CrudRepository <Vacancy, Long> {

    List<Vacancy> findVacanciesByDateAndBookedByNull(Date date);

    @Query("select v from Vacancy v where v.date = :date and v.spot.floor = :floor and v.spot.number = :number")
    Vacancy findByDateAndFloorAndNumber(@Param("date") Date date, @Param("floor") Integer floor, @Param("number") Integer number);

}


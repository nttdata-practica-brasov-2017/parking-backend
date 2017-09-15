package ro.nttdata.bv.parking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.nttdata.bv.parking.entity.Spot;
import ro.nttdata.bv.parking.entity.Vacancy;
import ro.nttdata.bv.parking.entity.Assignment;

import java.util.Date;
import java.util.List;

@Repository
public interface VacancyRepository extends CrudRepository<Vacancy, Long> {

    List<Vacancy> findVacanciesByDateAndBookedByNull(Date date);

    @Query("select v from Vacancy v where v.date = :date and v.spot.floor = :floor and v.spot.number = :number")
    Vacancy findByDateAndFloorAndNumber(@Param("date") Date date,
                                        @Param("floor") Integer floor,
                                        @Param("number") Integer number);

    @Query("select v from Vacancy v where v.spot = :spot and v.date >= :startDate and v.date <= :endDate ")
    List<Vacancy> findVacanciesBySpotAndDateBetween(@Param("spot") Spot spot,
                                                    @Param("startDate") Date from,
                                                    @Param("endDate") Date to);
    @Query("select v from Vacancy v where v.bookedBy.username = :username and v.date >= :date")
    List<Vacancy> findByUsernameAfterDate(@Param("username") String username, @Param("date") Date date);

    @Query("select v From Vacancy v join Assignment a where a.spot = v.spot and a.user.username = :username and v.date >= :date")
    List<Vacancy> findByAssigneeAndDateAfter(@Param("username") String username, @Param("date") Date date);
}


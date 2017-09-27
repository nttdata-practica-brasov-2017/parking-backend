package ro.nttdata.bv.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.nttdata.bv.parking.entity.Assignment;
import ro.nttdata.bv.parking.entity.Spot;
import ro.nttdata.bv.parking.entity.User;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    Assignment findByUser(User user);
    Assignment findBySpot(Spot spot);

    @Query("select a from Assignment a where a.user.username = :username")
    Assignment findByUserName(@Param("username") String username);

}

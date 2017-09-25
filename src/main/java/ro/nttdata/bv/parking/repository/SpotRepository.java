package ro.nttdata.bv.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.nttdata.bv.parking.entity.Spot;

import java.util.List;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {

    @Query("select a.spot from Assignment a where a.user.username = :username")
    Spot findByUsername(@Param("username") String username);

    List<Spot> findAll();
}

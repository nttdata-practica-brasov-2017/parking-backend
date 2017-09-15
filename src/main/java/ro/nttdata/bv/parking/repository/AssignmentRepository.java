package ro.nttdata.bv.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.nttdata.bv.parking.entity.Assignment;
import ro.nttdata.bv.parking.entity.User;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long>{

    Assignment findByUser(User user);

}

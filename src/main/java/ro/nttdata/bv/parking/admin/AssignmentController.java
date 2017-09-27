package ro.nttdata.bv.parking.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.nttdata.bv.parking.boundary.VacancyController;
import ro.nttdata.bv.parking.control.AdminService;
import ro.nttdata.bv.parking.entity.Assignment;
import ro.nttdata.bv.parking.repository.AssignmentRepository;

import java.util.List;

@RestController
public class AssignmentController {

    private static final Logger LOG = LoggerFactory.getLogger(VacancyController.class);

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AdminService adminService;

    @GetMapping("admin/view/assignments")
    public List<Assignment> postAssignments() {
        return assignmentRepository.findAll();
    }

    @GetMapping("admin/create/assignments")
    public void createAssignment(@RequestParam(name = "username") String username,
                                 @RequestParam(name = "number") int number,
                                 @RequestParam(name = "floor") int floor) {
        adminService.createAssignment(username, number, floor);
        LOG.info("Assignment between user {} and spot with number {} and floor {} created", username, number, floor);
    }

    @DeleteMapping("admin/delete/assignments")
    public void deleteAssignment(@RequestParam(name = "username") String username) {
        adminService.deleteAssignment(username);
        LOG.info("User {} assignment deleted", username);
    }
}

package ro.nttdata.bv.parking.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.nttdata.bv.parking.control.AdminService;
import ro.nttdata.bv.parking.entity.Assignment;
import ro.nttdata.bv.parking.entity.AssignmentRequest;
import ro.nttdata.bv.parking.entity.Spot;
import ro.nttdata.bv.parking.entity.User;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/users")
    public List<User> getUsers() {
        return adminService.getAllUsers();
    }

    @GetMapping("/admin/assign")
    public List<Assignment> getAssignments() {
        return adminService.getAllAssignments();
    }

    @GetMapping("/admin/spots")
    public List<Spot> getSpots() {
        return adminService.getAllSpots();
    }

    @PostMapping("/admin/user")
    public void postUser(@RequestBody User user) {
        adminService.addUser(user);
    }

    @PostMapping("/admin/spots")
    public void postSpot(@RequestBody Spot spot) {
        adminService.addSpot(spot);
    }

    @PostMapping("/admin/assignments")
    public void postAssignments(@RequestBody AssignmentRequest request) {
        adminService.addAssigment(request.getUserId(), request.getSpotId());
    }

    @DeleteMapping("/admin/users/{id}")
    public void eraseUser(@PathVariable Long id) {
        adminService.deleteUser(id);
    }

    @DeleteMapping("/admin/spots/{id}")
    public void eraseSpot(@PathVariable Long id) {
        adminService.deleteSpot(id);
    }

    @DeleteMapping("/admin/assignment/{id}")
    public void eraseAssign(@PathVariable Long id) {
        adminService.deleteAssignment(id);
    }
}

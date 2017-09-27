package ro.nttdata.bv.parking.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.nttdata.bv.parking.boundary.VacancyController;
import ro.nttdata.bv.parking.control.AdminService;
import ro.nttdata.bv.parking.entity.User;
import ro.nttdata.bv.parking.repository.UserRepository;

@RestController
public class AccountController {

    private static final Logger LOG = LoggerFactory.getLogger(VacancyController.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("admin/view/accounts")
    public Iterable<User> postAccounts() {
        return userRepository.findAll();
    }

    @PostMapping("admin/create/accounts")
    public void createAccount(@RequestBody User user) {
        adminService.createUser(user);
        LOG.info("User {} created", user.getUsername());
    }

    @DeleteMapping("admin/delete/accounts")
    public void deleteAccounts(@RequestParam(value = "username") String username) {
        adminService.deleteUser(username);
        LOG.info("User {} deleted", username);
    }
}

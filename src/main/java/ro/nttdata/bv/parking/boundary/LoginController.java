package ro.nttdata.bv.parking.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.nttdata.bv.parking.control.LoginService;
import ro.nttdata.bv.parking.entity.User;
import ro.nttdata.bv.parking.validation.UserValidator;

import javax.validation.Valid;

@RestController
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(VacancyController.class);

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public LoginService.UserInfo login(@RequestBody @Valid User user) {
        LOG.info("User {} signed in", user.getUsername());
        return loginService.getUser(user);
    }


}

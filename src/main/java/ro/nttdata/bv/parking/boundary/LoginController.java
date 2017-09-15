package ro.nttdata.bv.parking.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.nttdata.bv.parking.control.LoginService;
import ro.nttdata.bv.parking.entity.User;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public LoginService.UserInfo login(@RequestBody @Valid User user) {
        return loginService.getUser(user);
    }

}

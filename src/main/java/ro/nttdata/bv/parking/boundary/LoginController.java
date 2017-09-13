package ro.nttdata.bv.parking.boundary;

import com.sun.deploy.xml.XMLNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.nttdata.bv.parking.control.LoginService;
import ro.nttdata.bv.parking.entity.User;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return String.valueOf(loginService.isUserValid(user));
    }

}

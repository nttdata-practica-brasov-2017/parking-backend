package ro.nttdata.bv.parking.boundary;

import com.sun.deploy.xml.XMLNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.nttdata.bv.parking.entity.User;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return isUserValid(user).toString();
    }

    private Boolean isUserValid(User user) {
        return false;
    }


}

package ro.nttdata.bv.parking.boundary;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/helloWorld")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format("Hello, %s!", name);
    }

}

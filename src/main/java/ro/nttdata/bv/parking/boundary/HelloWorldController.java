package ro.nttdata.bv.parking.boundary;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping("/helloWorld")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format("Hello, %s!", name);
    }

    @PostMapping("/hello/{age}")
    public String postExample(@PathVariable(value = "age") int age,
                              @RequestBody Name fullName) {
        return String.format("Hello, %s! You are %d years old.", fullName, age);
    }

}

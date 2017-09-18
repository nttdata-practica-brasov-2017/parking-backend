package ro.nttdata.bv.parking.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.nttdata.bv.parking.control.VacancyService;
import ro.nttdata.bv.parking.entity.Vacancy;
import ro.nttdata.bv.parking.validation.FutureDate;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;

@RestController
@Validated
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @PostMapping("{username}/vacancies/assigned")
    @ResponseStatus(HttpStatus.CREATED)
    public void postVacancy(@PathVariable String username,
                            @RequestParam(value = "from", required = false)
                            @FutureDate @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
                            @RequestParam(value = "to", required = false)
                            @FutureDate @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
        from = from != null ? from : new Date();
        to = to != null ? to : new Date();
        vacancyService.createVacancies(username, from, to);
    }

    @GetMapping("/vacancies")
    public List<Vacancy> getVacancies(
            @RequestParam(name = "date", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @FutureDate Date date) {
        return vacancyService.getVacancies(date != null ? date : new Date());
    }

    @GetMapping("/{username}/vacancies/assigned")
    public List<Vacancy> getUserVacancies(@PathVariable String username,
                                          @RequestParam(value = "date", required = false)
                                          @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        date = date != null ? date : new Date();
        return vacancyService.getUserVacancies(username, date);
    }
}

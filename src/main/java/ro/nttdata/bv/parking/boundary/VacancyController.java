package ro.nttdata.bv.parking.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.nttdata.bv.parking.control.VacancyService;
import ro.nttdata.bv.parking.entity.Vacancy;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @PostMapping("/vacancies/assigned/{username}")
    public void postVacancy(@PathVariable String username,
                              @RequestParam(value = "from", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
                              @RequestParam(value = "to", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
        vacancyService.createVacancies(username, from, to);
    }

    @GetMapping("/vacancies")
    public List<Vacancy> getVacancies(
            @RequestParam(name = "date", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return vacancyService.getVacancies(date != null ? date : new Date());
    }
}

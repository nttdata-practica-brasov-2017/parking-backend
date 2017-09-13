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

@RestController
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @GetMapping("/vacancies")
    public List<Vacancy> getVacancies(
            @RequestParam(name = "date", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return vacancyService.getVacancies(date != null ? date : new Date());
    }
}

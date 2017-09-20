package ro.nttdata.bv.parking.boundary;

import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.nttdata.bv.parking.control.BookingService;
import ro.nttdata.bv.parking.entity.Vacancy;

import java.util.Date;
import java.util.List;

@RestController
public class BookingController {

    private static final Logger LOG = LoggerFactory.getLogger(VacancyController.class);

    @Autowired
    private BookingService bookingService;

    @PostMapping("{username}/bookings/spots/{number}")
    @ResponseStatus(HttpStatus.CREATED)
    public void postBooking(@PathVariable String username,
                            @PathVariable Integer number,
                            @RequestParam(value = "floor", required = false) Integer floor,
                            @RequestParam(value = "date", required = false)
                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        date = date != null ? date : new Date();
        LOG.info("User {} booked spot {} on {}", username, number, date);
        bookingService.createBookings(username, number, floor, date);
    }

    @JsonView(Views.Public.class)
    @GetMapping("{username}/bookings")
    public List<Vacancy> getUserBookings(@PathVariable String username,
                                    @RequestParam(value = "date", required = false)
                                    @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        date = date != null ? date : new Date();
        LOG.info("Listed bookings for user {} after {}", username, date);
        return bookingService.getBookings(username, date);
    }

}

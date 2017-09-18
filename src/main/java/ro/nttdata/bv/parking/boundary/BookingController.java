package ro.nttdata.bv.parking.boundary;

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
        bookingService.createBookings(username, number, floor, date);
    }

    @GetMapping("{username}/bookings")
    public List<Vacancy> getUserBookings(@PathVariable String username,
                                    @RequestParam(value = "date", required = false)
                                    @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        date = date != null ? date : new Date();
        return bookingService.getBookings(username, date);
    }

}

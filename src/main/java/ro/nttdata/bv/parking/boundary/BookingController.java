package ro.nttdata.bv.parking.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.nttdata.bv.parking.control.BookingService;

import java.util.Date;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookings/users/{username}/spots/{number}")
    @ResponseStatus(HttpStatus.CREATED)
    public void postBooking(@PathVariable String username,
                            @PathVariable Integer number,
                            @RequestParam(value = "floor", required = false) Integer floor,
                            @RequestParam(value = "date", required = false)
                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        date = date != null ? date : new Date();
        bookingService.createBookings(username, number, floor, date);
    }


}

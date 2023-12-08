package bakabakayow.restApi.controller;

import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Bookings;
import bakabakayow.restApi.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/bookings")
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;

    @GetMapping("/")
    public Response<List<Bookings>> listOfBooked() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Response<Bookings> getBookingId(@PathVariable Long id) {
        return bookingService.getBookingID(id);
    }
}

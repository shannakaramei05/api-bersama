package bakabakayow.restApi.controller;

import bakabakayow.restApi.dto.BookingsDTO;
import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Bookings;
import bakabakayow.restApi.model.Venues;
import bakabakayow.restApi.services.BookingService;
import bakabakayow.restApi.services.VenueService;
import bakabakayow.restApi.utils.SetResponse;
import bakabakayow.restApi.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
@AllArgsConstructor
public class VenuesController {

    private VenueService venueService;
    private BookingService bookingService;

    @GetMapping("/")
    public ResponseEntity<Response<List<Venues>>> getAllVenues () {
        Utils.setLogging("/api/v1/venues" , "request" , null , "");
        Response<List<Venues>> response = venueService.getAllVenues();
        Utils.setLogging("/api/v1/venues", "response", "response", response.toString());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Venues>> getVenue(@PathVariable Long id) {
        return ResponseEntity.ok(venueService.getVenuesId(id));
    }

    @PostMapping("/bookings")
    public ResponseEntity<Response<Bookings>> createBooking (@RequestBody BookingsDTO booking) {
        return ResponseEntity.ok(bookingService.addSchedule(booking));
    }

    @GetMapping("/bookings/{venueId}")
    public Response<List<Bookings>> getVenueDetailsAndBookings(
            @PathVariable Long venueId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam (required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        if(start == null) {
            start = LocalDateTime.now();
        }
        if (endDate == null) {
            endDate = LocalDateTime.now().plusDays(1).minusSeconds(1);
        }
        return bookingService.getBookDetailsBetween(venueId,start,endDate);
    }
}

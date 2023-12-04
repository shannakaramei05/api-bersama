package bakabakayow.restApi.controller;

import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Bookings;
import bakabakayow.restApi.model.Venues;
import bakabakayow.restApi.services.BookingService;
import bakabakayow.restApi.services.VenueService;
import bakabakayow.restApi.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{id}/bookings")
    public ResponseEntity<Response<Bookings>> bookVenue(@PathVariable Long id , @RequestBody Bookings booking) {
        if(!venueService.isExist(id)) {
        }
        return ResponseEntity.ok(bookingService.addScheduleById(booking));
    }
}

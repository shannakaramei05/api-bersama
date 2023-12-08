package bakabakayow.restApi.controller;

import bakabakayow.restApi.dto.BookingsDTO;
import bakabakayow.restApi.dto.VenuesDTO;
import bakabakayow.restApi.model.Bookings;
import bakabakayow.restApi.model.Venues;
import bakabakayow.restApi.services.VenueService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/venues")
@AllArgsConstructor
public class VenuesController {

    private VenueService venueService;

    @GetMapping("/")
    public ResponseEntity<List<Venues>> getAllVenues() {
        List<Venues> venues = venueService.getAllVenues();
        return ResponseEntity.ok(venues);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venues> getVenueById(@PathVariable Long id) {
        Optional<Venues> venue= venueService.getVenueById(id);
        return venue.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Venues> registerVenue(@RequestBody VenuesDTO venuesDTO) {
        Venues newVenue = venueService.registerVenue(venuesDTO);
        return new ResponseEntity<>(newVenue, HttpStatus.CREATED);
    }

    @PostMapping("/{venueId}/bookings")
    public ResponseEntity<Bookings> createBookingVenue(
            @PathVariable Long venueId,
            @RequestBody BookingsDTO bookingsDTO
            ) {

        Bookings booking = venueService.createBooking(venueId,bookingsDTO);
        return new ResponseEntity<>(booking,HttpStatus.CREATED);
    }

    @PutMapping("/{venueId}")
    public ResponseEntity<Venues> updateVenue(@PathVariable Long venueId, @RequestBody VenuesDTO venuesDTO) {
        Venues venue = venueService.updateDetailVenue(venueId,venuesDTO);
        return new ResponseEntity<>(venue,HttpStatus.ACCEPTED);

    }
}

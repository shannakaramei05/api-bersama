package bakabakayow.restApi.services;

import bakabakayow.restApi.dto.BookingsDTO;
import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.dto.VenuesDTO;
import bakabakayow.restApi.model.Bookings;
import bakabakayow.restApi.model.Fields;
import bakabakayow.restApi.model.Users;
import bakabakayow.restApi.model.Venues;
import bakabakayow.restApi.repository.BookingRepository;
import bakabakayow.restApi.repository.FieldRepository;
import bakabakayow.restApi.repository.UserRepository;
import bakabakayow.restApi.repository.VenueRepository;
import bakabakayow.restApi.utils.SetResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class VenueService {

    private VenueRepository venueRepository;

    private UserRepository userRepository;

    private BookingRepository bookingRepository;


    public List<Venues> getAllVenues() {
        return venueRepository.findAll();
    }

    public Optional<Venues> getVenueById(Long id) {
        return venueRepository.findById(id);
    }

    public Venues registerVenue(VenuesDTO venuesDTO) {
        Users user = userRepository.findById(venuesDTO.getUserId()).orElseThrow(()-> new EntityNotFoundException("User Not Found"));
        Venues reqVenue = new Venues();
        reqVenue.setUser(user);
        reqVenue.setName(venuesDTO.getName());
        reqVenue.setAddress(venuesDTO.getAddress());
        reqVenue.setPhone(venuesDTO.getPhone());
        venueRepository.save(reqVenue);
        return reqVenue;
    }

    public Bookings createBooking(Long venueId, BookingsDTO bookingsDTO) {
        Optional<Venues> venue = getVenueById(venueId);
        if (venue.isPresent()) {
            List<Fields> fields = venue.get().getFields();
            Fields bookedField = fields.stream().filter(field -> field.getName().equals(bookingsDTO.getFieldName())).findFirst().orElseThrow(() -> new EntityNotFoundException("Field Name Doens't Exist"));

            Bookings booking = new Bookings();
            booking.setField(bookedField);
            booking.setPlayDateStart(bookingsDTO.getPlayDateStart());
            booking.setPlayDateEnd(bookingsDTO.getPlayDateEnd());

            bookingRepository.save(booking);
            return booking;
        } else {
            throw new EntityNotFoundException("Venue Not Found");
        }
    }
}

package bakabakayow.restApi.services;

import bakabakayow.restApi.dto.BookingsDTO;
import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Bookings;
import bakabakayow.restApi.model.Fields;
import bakabakayow.restApi.model.Users;
import bakabakayow.restApi.model.Venues;
import bakabakayow.restApi.repository.BookingRepository;
import bakabakayow.restApi.repository.FieldRepository;
import bakabakayow.restApi.repository.UserRepository;
import bakabakayow.restApi.repository.VenueRepository;
import bakabakayow.restApi.utils.SetResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private FieldRepository fieldRepository;

    private VenueRepository venueRepository;

    public Response<List<Bookings>> getAllBookings() {
        return SetResponse.setStatusMessageSuccess(bookingRepository.findAll());
    }

    public Response<Bookings> getBookingID(Long id) {
        Optional<Bookings> bookedId = bookingRepository.findById(id);
        return SetResponse.setStatusMessageSuccess(bookedId.get());
    }

    public Response<Bookings> addSchedule(BookingsDTO bookingsDTO) {
        Users user = userRepository.findById(bookingsDTO.getUserId()).get();
        Fields fields= fieldRepository.findByName(bookingsDTO.getFieldName());

        Bookings booked = new Bookings();
        booked.setUser(user);
        booked.setPlayDateStart(bookingsDTO.getPlayDateStart());
        booked.setPlayDateEnd(bookingsDTO.getPlayDateEnd());

        List<Bookings> fieldBookings = fields.getBookings();
        fieldBookings.add(booked);
        fields.setBookings(fieldBookings);

        booked.setField(fields);

        bookingRepository.save(booked);
        return SetResponse.setStatusMessageSuccess(booked);
    }

    public Response<List<Bookings>> getBookDetailsBetween(Long id, LocalDateTime date) {
        Optional<Venues> venue = venueRepository.findById(id);
        if(venue.isPresent()) {
            List<Bookings> data = bookingRepository.findByField_Venue_VenueIdAndPlayDateStartBetween(id,date,date.plusDays(1));
            return SetResponse.setStatusMessageSuccess(data);
        }
        return SetResponse.setErrorResponse("404", "Not Found");
    }
}

package bakabakayow.restApi.services;

import bakabakayow.restApi.dto.BookingsDTO;
import bakabakayow.restApi.dto.RequestJoinBooking;
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
import jakarta.persistence.EntityNotFoundException;
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

    public Response<List<Bookings>> getAllBookings() {
        return SetResponse.setStatusMessageSuccess(bookingRepository.findAll());
    }

    public Response<Bookings> getBookingID(Long id) {
        Bookings booking = bookingRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Booking Not Found"));
        return SetResponse.setStatusMessageSuccess(booking);
    }

    public Response<Bookings> addUserToBooking(Long bookingId,RequestJoinBooking userRequest) {
        Optional<Bookings> booking = bookingRepository.findById(bookingId);
        if(booking.isPresent()) {
            Users newUser = userRepository.findById(userRequest.getUserId()).orElseThrow(()-> new EntityNotFoundException("User Not Found"));

            booking.get().getRegisteredUser().add(newUser);
            newUser.getBookings().add(booking.get());
            bookingRepository.save(booking.get());
            userRepository.save(newUser);
            return SetResponse.setStatusMessageSuccess(booking.get());
        }
        return SetResponse.setErrorResponse("404", "Booking Not Found");
    }

//    public Response<Bookings> addSchedule(BookingsDTO bookingsDTO) {
//        Users user = userRepository.findById(bookingsDTO.getUserId()).get();
//        Fields fields= fieldRepository.findByName(bookingsDTO.getFieldName());
//
//        Bookings booked = new Bookings();
//        booked.setUser(user);
//        booked.setPlayDateStart(bookingsDTO.getPlayDateStart());
//        booked.setPlayDateEnd(bookingsDTO.getPlayDateEnd());
//
//        List<Bookings> fieldBookings = fields.getBookings();
//        fieldBookings.add(booked);
//        fields.setBookings(fieldBookings);
//
//        booked.setField(fields);
//
//        bookingRepository.save(booked);
//        return SetResponse.setStatusMessageSuccess(booked);
//    }

//    public Response<List<Bookings>> getBookDetailsBetween(Long id, LocalDateTime start, LocalDateTime end) {
//        Venues venue = venueRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Venue Not Found with Id " + id));;
////        Optional<Fields> field = fieldRepository.findById(id);
//
//        Fields field = venue.getFields().stream().findFirst()
//                .orElseThrow(() -> new EntityNotFoundException("No fields found for Venue with Id " + id));
//
//        List<Bookings> bookings = bookingRepository.findByFieldAndPlayDateStartBetween(field,start,end);
//
//        return SetResponse.setStatusMessageSuccess(bookings);
//    }
}

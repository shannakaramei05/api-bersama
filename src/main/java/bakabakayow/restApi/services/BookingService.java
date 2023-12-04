package bakabakayow.restApi.services;

import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Bookings;
import bakabakayow.restApi.repository.BookingRepository;
import bakabakayow.restApi.utils.SetResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;

    public Response<List<Bookings>> getAllBookings() {
        return SetResponse.setStatusMessageSuccess(bookingRepository.findAll());
    }

    public Response<Bookings> getBookingID(Long id) {
        Optional<Bookings> bookedId = bookingRepository.findById(id);
        return SetResponse.setStatusMessageSuccess(bookedId.get());
    }

    public Response<Bookings> addScheduleById(Bookings booking) {
        Bookings booked = new Bookings();
        booked.setUser(booking.getUser());
        booked.setField(booking.getField());
        booked.setPlayDateStart(booking.getPlayDateStart());
        booked.setPlayDateEnd(booking.getPlayDateEnd());
        bookingRepository.save(booked);
        return SetResponse.setStatusMessageSuccess(booked);
    }
}

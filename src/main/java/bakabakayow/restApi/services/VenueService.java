package bakabakayow.restApi.services;

import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Bookings;
import bakabakayow.restApi.model.Fields;
import bakabakayow.restApi.model.Venues;
import bakabakayow.restApi.repository.VenueRepository;
import bakabakayow.restApi.utils.SetResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class VenueService {

    private VenueRepository venueRepository;

    public boolean isExist(Long id) {
        return venueRepository.existsById(id);
    }

    public Response<List<Venues>> getAllVenues() {
        List<Venues> listOfVenues= venueRepository.findAll();
        return SetResponse.setStatusMessageSuccess(listOfVenues);
    }

    public Response<Venues> getVenuesId(Long id) {
        Optional<Venues> venue = venueRepository.findById(id);
        return SetResponse.setStatusMessageSuccess(venue.get());
    }
}

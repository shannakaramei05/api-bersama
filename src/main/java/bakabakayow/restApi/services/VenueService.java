package bakabakayow.restApi.services;

import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Venues;
import bakabakayow.restApi.repository.VenueRepository;
import bakabakayow.restApi.utils.SetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public Response<List<Venues>> getAllVenues() {
        return SetResponse.setStatusMessageSuccess(venueRepository.findAll());
    }
}

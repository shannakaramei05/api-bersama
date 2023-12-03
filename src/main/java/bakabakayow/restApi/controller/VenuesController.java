package bakabakayow.restApi.controller;

import bakabakayow.restApi.dto.Response;
import bakabakayow.restApi.model.Venues;
import bakabakayow.restApi.services.VenueService;
import bakabakayow.restApi.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
@AllArgsConstructor
public class VenuesController {

    private VenueService venueService;
    @GetMapping("/")
    public ResponseEntity<Response<List<Venues>>> getAllVenues () {
        Utils.setLogging("/api/v1/venues" , "request" , null , "");
        Response<List<Venues>> response = venueService.getAllVenues();
        Utils.setLogging("/api/v1/venues", "response", "response", response.toString());
        return ResponseEntity.ok(response);
    }
}

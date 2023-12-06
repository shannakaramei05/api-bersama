package bakabakayow.restApi.controller;

import bakabakayow.restApi.model.Fields;
import bakabakayow.restApi.services.FieldService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fields")
@AllArgsConstructor
public class FieldController {

    private FieldService fieldService;
    @GetMapping("/")
    public List<Fields> getAllField() {
        return fieldService.getAllFields();
    }
}

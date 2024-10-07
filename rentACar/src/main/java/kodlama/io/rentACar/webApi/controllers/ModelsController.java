package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService; // ModelService'i import edin
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private final ModelService modelService; // ModelService küçük harfle olmalı

    @GetMapping() // Tüm modelleri listelemek için kullanılır
    public List<GetAllModelsResponse> getAll() {
        return this.modelService.getAll(); // modelService ile getAll() metodunu çağırın
    }
    @PostMapping() // Yeni bir marka eklemek için kullanılır
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest) {
        this.modelService.add(createModelRequest);
    }

}

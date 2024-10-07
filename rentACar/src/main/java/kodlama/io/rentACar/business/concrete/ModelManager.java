package kodlama.io.rentACar.business.concrete;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService; // modelMapperService alanı eklendi

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll(); // ModelRepository kullanılıyor
        return models.stream()
                .map(model -> modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);

        this.modelRepository .save(model); // Veriyi veritabanına kaydetmek için modelRepository kullanılıyor
    }
}

package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdataBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private final BrandService brandService;

    @GetMapping() // Tüm markaları listelemek için kullanılır
    public List<GetAllBrandsResponse> getAll() {
        return this.brandService.getAll();
    }

    @GetMapping("/{id}") // Belirli bir markayı ID'sine göre getirmek için kullanılır
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PostMapping() // Yeni bir marka eklemek için kullanılır
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid () CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @PutMapping() // Mevcut bir markayı güncellemek için kullanılır
    public void update(@RequestBody UpdataBrandRequest updataBrandRequest) {
        this.brandService.update(updataBrandRequest);
    }

    @DeleteMapping("/{id}") // Belirli bir markayı ID'sine göre silmek için kullanılır
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }
}

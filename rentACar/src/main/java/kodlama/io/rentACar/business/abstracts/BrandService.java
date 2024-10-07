package kodlama.io.rentACar.business.abstracts;

import java.util.List;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdataBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);//kendim ekledim
    void add(UpdataBrandRequest updataBrandRequest);//kendim ekledim
    void delete(int id);

    void update(UpdataBrandRequest updataBrandRequest);
}
   //iş kuralları bu dosyada yazılır
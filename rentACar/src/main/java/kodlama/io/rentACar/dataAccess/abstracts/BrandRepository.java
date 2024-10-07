package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name);//spring jpa keywords
}
//jpa bir standarttır hipernate implementasyonu sql yani veri işlemlerini kullanmak için efektif kullanıyoruz
//birçok veri tabanı işlemini basit bir şekilde yapmamızı sağlar
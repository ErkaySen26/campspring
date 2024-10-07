package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "brands")
@Getter
@Setter
@AllArgsConstructor //int ve string construcotr yapmış
@NoArgsConstructor
@Entity
public class Brand {

    @Id //sen bu nesnenin primary key alanısın tekrar edemessin .
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Verinin ototmatik üretilmesini sağlar 1 2 3 4
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand" )
    List<Model> models;
}

//Brand ---->id,name,quantity
//GetAllBrandsResponse--->id,name
//mapping

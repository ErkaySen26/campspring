package kodlama.io.rentACar.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor //int ve string construcotr yapmış
@NoArgsConstructor
@Entity
public class Car {
    @Id //sen bu nesnenin primary key alanısın tekrar edemessin .
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Verinin ototmatik üretilmesini sağlar 1 2 3 4
    @Column(name = "id")
    private int id;
    @Column(name="plate",unique = true)
    private String plate;
    @Column(name ="dailyPrice")
    private double dailyPrice;
    @Column(name ="modelYear")
    private int modelYear;
    @Column(name ="state")
    private int state;//1 - Available -Rented 3 Maintenance

    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;
}

package kodlama.io.rentACar.business.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdataBrandRequest {
    private String name;
    private int id ;
}

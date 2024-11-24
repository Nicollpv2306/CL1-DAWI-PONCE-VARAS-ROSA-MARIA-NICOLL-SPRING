package pe.edu.i202210933.cl1_jpa_data_ponce_rosa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountryLanguage {
    @Id
    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", nullable = false)
    private Country country;
    @Id
    private String Language;
    private double Percentage;
    private String isOfficial;
}

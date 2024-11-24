package pe.edu.i202210933.cl1_jpa_data_ponce_rosa.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202210933.cl1_jpa_data_ponce_rosa.entity.Country;

public interface CountryRepository extends CrudRepository<Country, String> {
}

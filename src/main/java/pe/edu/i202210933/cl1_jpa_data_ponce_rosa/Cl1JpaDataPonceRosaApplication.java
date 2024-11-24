package pe.edu.i202210933.cl1_jpa_data_ponce_rosa;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202210933.cl1_jpa_data_ponce_rosa.entity.Country;
import pe.edu.i202210933.cl1_jpa_data_ponce_rosa.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataPonceRosaApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataPonceRosaApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Optional<Country> countryArgentina = countryRepository.findById("ARG");
		countryArgentina.ifPresentOrElse(
				arg -> arg.getCountryLanguages()
						.forEach(language -> System.out.println("Lenguajes de ARG -> " + language.getLanguage())),
				() -> {
					Optional<Country> countryPeru = countryRepository.findById("PER");
					countryPeru.ifPresent(peru -> peru.getCountryLanguages()
							.forEach(language -> System.out.println("Lenguajes de PER -> " + language.getLanguage())));
				}
		);

		/*List<String> codePaises = List.of("COL", "ARG");

		countryRepository.deleteAllById(codePaises);
		System.out.println("Codigos COL y ARG fueron eliminados");
		*/

		//Luego de la eliminacion, se comenta este bloque y se vuelve a ejecutar el la primera consulta
		//para que realice el flujo alterno

	}
}

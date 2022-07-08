package br.dev.thinkers.msclients;

import br.dev.thinkers.msclients.domain.Client;
import br.dev.thinkers.msclients.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MsclientsApplication {

	private final ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(MsclientsApplication.class, args);
	}

	@Bean
	public void initialClientDb () {
		System.out.println("************** load base");
		Client client =  new Client("Enrico Heitor Cavalcanti", "65206106585", LocalDate.of(1985, 07, 01));
		Client client2 = new Client("Felipe César Oliver Aparício", "57035762531", LocalDate.of(1967, 03, 27));
		Client client3 = new Client("Fátima Natália Evelyn da Cruz", "35304357248", LocalDate.of(1945, 01, 26));
		Client client4 = new Client("Helena Elza Pinto", "27780116417", LocalDate.of(1962, 05, 14));
		clientRepository.saveAll(Arrays.asList(client, client2, client3, client4));
		System.out.println("************** end");
	}

}

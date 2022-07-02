package br.dev.thinkers.msclients.domain;

import br.dev.thinkers.msclients.dto.ClientDTO;
import br.dev.thinkers.msclients.utils.Convert;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cpf;

    @Column(length = 150)
    private String name;

    @Column(name = "born_in", columnDefinition = "DATE")
    private LocalDate bornIn;

    public Client() {}

    public Client(String cpf, String name, LocalDate bornIn) {
        this.cpf = cpf;
        this.name = name;
        this.bornIn = bornIn;
    }

    public static Client toModel(ClientDTO dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setCpf(dto.getCpf());
        client.setName(dto.getName());
        client.setBornIn(Convert.convertStringToLocalDate(dto.getBornIn()));
        return client;
    }
}

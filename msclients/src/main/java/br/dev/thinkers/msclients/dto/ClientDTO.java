package br.dev.thinkers.msclients.dto;

import br.dev.thinkers.msclients.domain.Client;
import br.dev.thinkers.msclients.utils.Convert;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClientDTO {
    private Long id;
    private String cpf;
    private String name;
    private String bornIn;
    
    public static ClientDTO toDto(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setCpf(client.getCpf());
        dto.setName(client.getName());
        dto.setBornIn(client.getBornIn().toString());
        return dto;
    }
}

package br.dev.thinkers.msclients.resources;

import br.dev.thinkers.msclients.domain.Client;
import br.dev.thinkers.msclients.dto.ClientDTO;
import br.dev.thinkers.msclients.services.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("clients")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ClientResource {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<?> saveClient(@RequestBody ClientDTO dto) {
        Client client = clientService.saveClient(Client.toModel(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().query("cpf={cpf}").buildAndExpand(client.getCpf()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClientDTO> getClientByCpf(String cpf) throws ChangeSetPersister.NotFoundException {
        Client client = clientService.findByCpf(cpf);
        return ResponseEntity.ok(ClientDTO.toDto(client));
    }

    @GetMapping
    public ResponseEntity<List<Client>> list() {
        log.info("Obtendo o status do microservice de cliente");
        return ResponseEntity.ok(clientService.loadAll());
    }
}

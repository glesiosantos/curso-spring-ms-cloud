package br.dev.thinkers.msclients.services;

import br.dev.thinkers.msclients.domain.Client;
import br.dev.thinkers.msclients.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private final ClientRepository clientRepository;

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public Client findByCpf(String cpf) throws ChangeSetPersister.NotFoundException {
        return clientRepository.findByCpf(cpf).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    @Transactional(readOnly = true)
    public List<Client> loadAll() {
        return clientRepository.findAll();
    }
}

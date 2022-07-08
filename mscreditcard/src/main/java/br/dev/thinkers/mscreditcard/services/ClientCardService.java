package br.dev.thinkers.mscreditcard.services;

import br.dev.thinkers.mscreditcard.dto.ClientCardDTO;
import br.dev.thinkers.mscreditcard.repositories.ClientCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientCardService {

    private final ClientCardRepository clientCardRepository;

    @Transactional
    public List<ClientCardDTO> loadCardByCpf(String cpf) {
        return clientCardRepository.findByCpf(cpf).stream().map(ClientCardDTO::toDTO).collect(Collectors.toList());
    }
}

package br.dev.thinkers.mscreditappraiser.services;

import br.dev.thinkers.mscreditappraiser.clients.ClientResourceClient;
import br.dev.thinkers.mscreditappraiser.domain.ClientData;
import br.dev.thinkers.mscreditappraiser.domain.ClientStatus;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CreditAppraiserService {

    private final ClientResourceClient clientResourceClient;

    public ClientStatus getClientStatusByCpf(String cpf) {
        ResponseEntity<ClientData> clientDataResponse = clientResourceClient.getClientByCpf(cpf);
        return ClientStatus.builder().client(clientDataResponse.getBody()).build();
    }
}

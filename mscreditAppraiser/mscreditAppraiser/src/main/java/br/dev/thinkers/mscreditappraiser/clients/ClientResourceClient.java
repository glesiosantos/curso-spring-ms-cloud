package br.dev.thinkers.mscreditappraiser.clients;

import br.dev.thinkers.mscreditappraiser.domain.ClientStatus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclients", path = "/clients")
public interface ClientResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity getClientByCpf(String cpf);
}

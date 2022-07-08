package br.dev.thinkers.mscreditappraiser.resources;

import br.dev.thinkers.mscreditappraiser.domain.ClientData;
import br.dev.thinkers.mscreditappraiser.domain.ClientStatus;
import br.dev.thinkers.mscreditappraiser.services.CreditAppraiserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credits")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CreditAppraiserResource {

    private final CreditAppraiserService creditAppraiserService;

    @GetMapping(value = "client-status", params = "cpf")
    public ResponseEntity<ClientStatus> status(@RequestParam("cpf") String cpf) {
        ClientStatus clientStatus = creditAppraiserService.getClientStatusByCpf(cpf);
        return ResponseEntity.ok(clientStatus);
    }
}

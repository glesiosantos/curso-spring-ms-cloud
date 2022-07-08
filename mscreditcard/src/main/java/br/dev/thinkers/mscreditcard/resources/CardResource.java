package br.dev.thinkers.mscreditcard.resources;

import br.dev.thinkers.mscreditcard.domain.Card;
import br.dev.thinkers.mscreditcard.dto.CardDTO;
import br.dev.thinkers.mscreditcard.dto.ClientCardDTO;
import br.dev.thinkers.mscreditcard.services.CardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cards")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CardResource {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardDTO> saveNewCard(@RequestBody  CardDTO dto) {
        cardService.saveCard(Card.toModel(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<CardDTO>> loadCards() {
        return ResponseEntity.ok(cardService.loadAllCards());
    }

    // /cards?income=5000
    @GetMapping(params = "income")
    public ResponseEntity<List<CardDTO>> getCardIncomeAt(@RequestParam("income") Long income) {
        return ResponseEntity.ok(cardService.getCardEqualLowerIncome(income));
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClientCardDTO>> loadCardByClient(@RequestParam("cpf") String cpf) {
       return ResponseEntity.ok(cardService.loardCardByCliente(cpf));
    }
}

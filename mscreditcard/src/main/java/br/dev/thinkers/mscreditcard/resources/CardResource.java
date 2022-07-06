package br.dev.thinkers.mscreditcard.resources;

import br.dev.thinkers.mscreditcard.dto.CardDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cards")
public class CardResource {

    @PostMapping
    public ResponseEntity<String> saveNewCard(CardDTO dto) {
        return null;
    }
}

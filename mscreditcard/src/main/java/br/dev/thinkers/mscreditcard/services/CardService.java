package br.dev.thinkers.mscreditcard.services;

import br.dev.thinkers.mscreditcard.domain.Card;
import br.dev.thinkers.mscreditcard.domain.ClientCard;
import br.dev.thinkers.mscreditcard.dto.CardDTO;
import br.dev.thinkers.mscreditcard.dto.ClientCardDTO;
import br.dev.thinkers.mscreditcard.repositories.CardRepository;
import br.dev.thinkers.mscreditcard.repositories.ClientCardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CardService {

    private final CardRepository cardRepository;
    private final ClientCardRepository clientCardRepository;

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    @Transactional(readOnly = true)
    public List<CardDTO> getCardEqualLowerIncome(Long value) {
        BigDecimal income = BigDecimal.valueOf(value);
        return cardRepository.findByIncomeLessThanEqual(income).stream().map(CardDTO::toDTO).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<CardDTO> loadAllCards() {
        return cardRepository.findAll().stream().map(CardDTO::toDTO).collect(Collectors.toList());
    }

    public List<ClientCardDTO> loardCardByCliente(String cpf) {
        return clientCardRepository.findByCpf(cpf).stream().map(ClientCardDTO::toDTO).collect(Collectors.toList());
    }
}

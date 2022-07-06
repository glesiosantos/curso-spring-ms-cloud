package br.dev.thinkers.mscreditcard.services;

import br.dev.thinkers.mscreditcard.domain.Card;
import br.dev.thinkers.mscreditcard.repositories.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CardService {

    private final CardRepository cardRepository;

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    @Transactional(readOnly = true)
    public List<Card> getCardEqualLowerIncome(Long value) {
        BigDecimal income = BigDecimal.valueOf(value);
        return cardRepository.findByIncomeLessThanEqual(income);
    }
}

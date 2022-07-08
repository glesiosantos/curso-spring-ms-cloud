package br.dev.thinkers.mscreditcard.dto;

import br.dev.thinkers.mscreditcard.domain.Card;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CardDTO {

    private Long id;
    private String name;
    private String flag;
    private BigDecimal income;
    private BigDecimal limit;

    public CardDTO() {}

    public CardDTO (Card card) {
        this.id = card.getId() == null ? null : card.getId();
        this.name = card.getName();
        this.flag = card.getFlag().toString();
        this.income = card.getIncome();
        this.limit = card.getBaseLimit();
    }

    public static CardDTO toDTO(Card card) {
        return new CardDTO(card);
    }
}

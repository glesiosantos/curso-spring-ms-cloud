package br.dev.thinkers.mscreditcard.domain;

import br.dev.thinkers.mscreditcard.dto.CardDTO;
import br.dev.thinkers.mscreditcard.dto.ClientCardDTO;
import br.dev.thinkers.mscreditcard.enuns.CardFlag;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "client_card")
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
    private BigDecimal limite;

    public static ClientCard toDTO(ClientCardDTO dto) {

        Card card = new Card();
        card.setFlag(CardFlag.valueOf(dto.getFlag()));
        card.setBaseLimit(dto.getLimit());

        ClientCard cc = new ClientCard();
        cc.setCpf(dto.getCpf());
        cc.setCard(card);
        return cc;
    }
}

package br.dev.thinkers.mscreditcard.domain;

import br.dev.thinkers.mscreditcard.enuns.CardFlag;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CardFlag flag;

    @Column(length = 150, nullable = false)
    private BigDecimal income; // Renda do cartão

    @Column(name = "base_list")
    private BigDecimal baseLimit;
}

package br.dev.thinkers.mscreditcard.dto;

import br.dev.thinkers.mscreditcard.enuns.CardFlag;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

public class CardDTO {

    private Long id;
    private String name;
    private String flag;
    private BigDecimal income;
    private BigDecimal limit;
}

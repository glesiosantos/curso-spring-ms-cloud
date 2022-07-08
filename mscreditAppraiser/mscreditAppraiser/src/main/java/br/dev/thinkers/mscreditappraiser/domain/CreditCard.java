package br.dev.thinkers.mscreditappraiser.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class CreditCard {
    private String nameCard;
    private String flag;
    private BigDecimal limit;
}

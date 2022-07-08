package br.dev.thinkers.mscreditappraiser.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ClientStatus {
    private ClientData client;
    private List<CreditCard> cards;
}

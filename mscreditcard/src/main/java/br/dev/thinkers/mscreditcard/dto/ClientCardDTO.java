package br.dev.thinkers.mscreditcard.dto;

import br.dev.thinkers.mscreditcard.domain.ClientCard;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ClientCardDTO {
    private String cpf;
    private String cardName;
    private String flag;
    private BigDecimal limit;

    public static ClientCardDTO toDTO(ClientCard clientCard) {
        ClientCardDTO dto = new ClientCardDTO();
        dto.setCpf(clientCard.getCpf());
        dto.setCardName(clientCard.getCard().getName());
        dto.setFlag(clientCard.getCard().getFlag().toString());
        dto.setLimit(clientCard.getLimite());
        return dto;
    }
}

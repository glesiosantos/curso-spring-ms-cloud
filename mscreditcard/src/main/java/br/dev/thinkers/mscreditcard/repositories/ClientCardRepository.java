package br.dev.thinkers.mscreditcard.repositories;

import br.dev.thinkers.mscreditcard.domain.ClientCard;
import br.dev.thinkers.mscreditcard.dto.ClientCardDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {

    List<ClientCard> findByCpf(String cpf);
}

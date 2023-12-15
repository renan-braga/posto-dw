package br.edu.ifsp.ar.postodw.repository;

import br.edu.ifsp.ar.postodw.model.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {

    List<Abastecimento> findByAtivoTrue();

}

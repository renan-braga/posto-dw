package br.edu.ifsp.ar.postodw.repository;

import br.edu.ifsp.ar.postodw.model.VendaConveniencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaConvenienciaRepository extends JpaRepository<VendaConveniencia, Long> {
    List<VendaConveniencia> findByAtivoTrue();
}

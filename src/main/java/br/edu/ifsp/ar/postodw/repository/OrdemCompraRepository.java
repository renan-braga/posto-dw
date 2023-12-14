package br.edu.ifsp.ar.postodw.repository;

import br.edu.ifsp.ar.postodw.model.OrdemCompra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdemCompraRepository extends JpaRepository<OrdemCompra, Long> {
    List<OrdemCompra> findByAtivoTrue();
}

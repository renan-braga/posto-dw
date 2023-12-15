package br.edu.ifsp.ar.postodw.repository;

import br.edu.ifsp.ar.postodw.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    List<Fornecedor> findByAtivoTrue();

}

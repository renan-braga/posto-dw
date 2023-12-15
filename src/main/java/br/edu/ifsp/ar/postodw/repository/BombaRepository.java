package br.edu.ifsp.ar.postodw.repository;

import br.edu.ifsp.ar.postodw.model.Bomba;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BombaRepository extends JpaRepository<Bomba, Long> {
    List<Bomba> findByAtivoTrue();

}
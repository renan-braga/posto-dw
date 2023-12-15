package br.edu.ifsp.ar.postodw.service;

import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.Fornecedor;
import br.edu.ifsp.ar.postodw.repository.BombaRepository;
import br.edu.ifsp.ar.postodw.repository.FornecedorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> list(){
        return fornecedorRepository.findByAtivoTrue();
    }
    public Optional<Fornecedor> findById(Long id){return fornecedorRepository.findById(id);}
    public Fornecedor save(Fornecedor fornecedor){return fornecedorRepository.save(fornecedor);}
    public void deleteById(Long id){fornecedorRepository.deleteById(id);}

    public Fornecedor update(Long id, Fornecedor fornecedor) {
        Fornecedor fornecedorSaved = fornecedorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        BeanUtils.copyProperties(fornecedor, fornecedorSaved, "id");
        return fornecedorRepository.save(fornecedorSaved);
    }
}

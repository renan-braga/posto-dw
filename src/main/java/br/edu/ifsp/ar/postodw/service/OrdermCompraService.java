package br.edu.ifsp.ar.postodw.service;

import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.OrdemCompra;
import br.edu.ifsp.ar.postodw.repository.BombaRepository;
import br.edu.ifsp.ar.postodw.repository.OrdemCompraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdermCompraService {

    @Autowired
    private OrdemCompraRepository ordemCompraRepository;

    public List<OrdemCompra> list(){
        return ordemCompraRepository.findByAtivoTrue();
    }
    public Optional<OrdemCompra> findById(Long id){return ordemCompraRepository.findById(id);}
    public OrdemCompra save(OrdemCompra ordemCompra){return ordemCompraRepository.save(ordemCompra);}
    public void deleteById(Long id){ordemCompraRepository.deleteById(id);}

    public OrdemCompra update(Long id, OrdemCompra ordemCompra) {
        OrdemCompra ordemCompraSaved = ordemCompraRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        BeanUtils.copyProperties(ordemCompra, ordemCompraSaved, "id");
        return ordemCompraRepository.save(ordemCompraSaved);
    }

}

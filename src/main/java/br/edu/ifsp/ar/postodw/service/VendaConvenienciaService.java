package br.edu.ifsp.ar.postodw.service;

import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.VendaConveniencia;
import br.edu.ifsp.ar.postodw.repository.BombaRepository;
import br.edu.ifsp.ar.postodw.repository.VendaConvenienciaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaConvenienciaService {

    @Autowired
    private VendaConvenienciaRepository vendaConvenienciaRepository;

    public List<VendaConveniencia> list(){
        return vendaConvenienciaRepository.findByAtivoTrue();
    }
    public Optional<VendaConveniencia> findById(Long id){return vendaConvenienciaRepository.findById(id);}
    public VendaConveniencia save(VendaConveniencia vendaConveniencia){return vendaConvenienciaRepository.save(vendaConveniencia);}
    public void deleteById(Long id){vendaConvenienciaRepository.deleteById(id);}

    public VendaConveniencia update(Long id, VendaConveniencia vendaConveniencia) {
        VendaConveniencia vendaConvenienciaSaved = vendaConvenienciaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        BeanUtils.copyProperties(vendaConveniencia, vendaConvenienciaSaved, "id");
        return vendaConvenienciaRepository.save(vendaConvenienciaSaved);
    }
}

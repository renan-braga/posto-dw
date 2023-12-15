package br.edu.ifsp.ar.postodw.service;

import br.edu.ifsp.ar.postodw.model.Abastecimento;
import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.OrdemCompra;
import br.edu.ifsp.ar.postodw.repository.BombaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BombaService {

    @Autowired
    private BombaRepository bombaRepository;
    @Autowired
    private OrdermCompraService ordermCompraService;

    public List<Bomba> list(){
        return bombaRepository.findAll();
    }
    public Optional<Bomba> findById(Long id){return bombaRepository.findById(id);}
    public Bomba save(Bomba bomba){return bombaRepository.save(bomba);}
    public void deleteById(Long id){bombaRepository.deleteById(id);}

    public Bomba update(Long id, Bomba bomba) {
        return findById(id).map(bomba1 -> {
            bomba1.setCapacidade(bomba.getCapacidade());
            bomba1.setCombustivel(bomba.getCombustivel());
            bomba1.setQuantidadeAtual(bomba.getQuantidadeAtual());
            return save(bomba1);
        }).orElseThrow(() -> new RuntimeException("Bomba não encontrada"));
    }

    public Bomba recarregar(Long bombaId, Long ordemCompraId, int quantidadeLitros){
        Bomba bomba = findById(bombaId)
                .orElseThrow(() -> new RuntimeException("Bomba não encontrada"));

        ordermCompraService
                .findById(ordemCompraId)
                .filter(ordemCompra -> ordemCompra.getTipo() == OrdemCompra.TipoOrdem.COMBUSTIVEL)
                .orElseThrow(() -> new RuntimeException("Ordem de compra não encontrada"));

        BigDecimal novaQuantidade = BigDecimal.valueOf(bomba.getQuantidadeAtual().intValue() + quantidadeLitros);
        if(novaQuantidade.compareTo(bomba.getCapacidade()) > 0){
            throw new RuntimeException("Quantidade de litros maior que a capacidade da bomba");
        }

        bomba.setQuantidadeAtual(novaQuantidade);
        return update(bombaId, bomba);
    }
}

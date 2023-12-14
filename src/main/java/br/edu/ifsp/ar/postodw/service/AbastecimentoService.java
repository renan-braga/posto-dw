package br.edu.ifsp.ar.postodw.service;

import br.edu.ifsp.ar.postodw.model.Abastecimento;
import br.edu.ifsp.ar.postodw.repository.AbastecimentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AbastecimentoService {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;
    @Autowired
    private BombaService bombaService;

    public List<Abastecimento> list(){
        return abastecimentoRepository.findByAtivoTrue();
    }
    public Optional<Abastecimento> findById(Long id){return abastecimentoRepository.findById(id);}
    public Abastecimento save(Abastecimento abastecimento){
        BigDecimal quantidadeAtualBomba = abastecimento.getBomba().getQuantidadeAtual();
        BigDecimal quantidadeAbastecida = abastecimento.getQuantidade();
        if(quantidadeAbastecida.compareTo(quantidadeAtualBomba) > 0) {
            throw new RuntimeException("Quantidade abastecida maior que a quantidade atual da bomba");
        } else {
            BigDecimal novaQuantidade = quantidadeAtualBomba.subtract(quantidadeAbastecida);
            abastecimento.getBomba().setQuantidadeAtual(novaQuantidade);
            bombaService.update(abastecimento.getBomba().getId(), abastecimento.getBomba());
        }
        return abastecimentoRepository.save(abastecimento);
    }
    public void deleteById(Long id){abastecimentoRepository.deleteById(id);}

    public Abastecimento update(Long id, Abastecimento abastecimento) {
        Abastecimento abastecimentoSaved = abastecimentoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Abastecimento não encontrado"));

        BeanUtils.copyProperties(abastecimento, abastecimentoSaved, "id");
        return abastecimentoRepository.save(abastecimentoSaved);
    }
}

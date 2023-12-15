package br.edu.ifsp.ar.postodw.controler;

import br.edu.ifsp.ar.postodw.model.Abastecimento;
import br.edu.ifsp.ar.postodw.service.AbastecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/abastecimento")
public class AbastecimentoControler {

    @Autowired
    private AbastecimentoService abastecimentoService;

    @GetMapping
    public List<Abastecimento> list(){
        return abastecimentoService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Abastecimento> findById(@PathVariable Long id){
        return abastecimentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Abastecimento create(@Valid @RequestBody Abastecimento abastecimento){
        return abastecimentoService.save(abastecimento);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Abastecimento update(@PathVariable Long id, @Valid @RequestBody Abastecimento abastecimento){
        return abastecimentoService.update(id, abastecimento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        abastecimentoService.findById(id).map(abastecimento -> {
            abastecimento.setAtivo(false);
            return abastecimentoService.update(id, abastecimento);
        });
    }

}

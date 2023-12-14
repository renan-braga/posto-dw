package br.edu.ifsp.ar.postodw.controler;

import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.Fornecedor;
import br.edu.ifsp.ar.postodw.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorControler {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> list(){
        return fornecedorService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id){
        return fornecedorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor create(@Valid @RequestBody Fornecedor fornecedor){
        return fornecedorService.save(fornecedor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        fornecedorService.findById(id).map(fornecedor -> {
            fornecedor.setAtivo(false);
            return fornecedorService.update(id, fornecedor);
        });
    }
}

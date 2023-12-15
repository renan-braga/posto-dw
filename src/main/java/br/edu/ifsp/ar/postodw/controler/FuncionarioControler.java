package br.edu.ifsp.ar.postodw.controler;

import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.Funcionario;
import br.edu.ifsp.ar.postodw.service.BombaService;
import br.edu.ifsp.ar.postodw.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioControler {

    @Autowired
    private FuncionarioService funcionarioService;


    @GetMapping
    public List<Funcionario> list(){
        return funcionarioService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id){
        return funcionarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario create(@Valid @RequestBody Funcionario funcionario){
        return funcionarioService.save(funcionario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        funcionarioService.deleteById(id);
    }


}

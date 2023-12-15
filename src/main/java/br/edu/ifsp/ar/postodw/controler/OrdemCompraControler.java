package br.edu.ifsp.ar.postodw.controler;

import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.OrdemCompra;
import br.edu.ifsp.ar.postodw.service.OrdermCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ordemcompra")
public class OrdemCompraControler {

    @Autowired
    private OrdermCompraService ordermCompraService;


    @GetMapping
    public List<OrdemCompra> list(){
        return ordermCompraService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemCompra> findById(@PathVariable Long id){
        return ordermCompraService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemCompra create(@Valid @RequestBody OrdemCompra ordemCompra){
        return ordermCompraService.save(ordemCompra);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        ordermCompraService.deleteById(id);
    }


}

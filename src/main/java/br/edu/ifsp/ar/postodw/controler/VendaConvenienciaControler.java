package br.edu.ifsp.ar.postodw.controler;

import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.VendaConveniencia;
import br.edu.ifsp.ar.postodw.service.BombaService;
import br.edu.ifsp.ar.postodw.service.VendaConvenienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vendaconveniencia")
public class VendaConvenienciaControler {

    @Autowired
    private VendaConvenienciaService vendaConvenienciaService;

    @GetMapping
    public List<VendaConveniencia> list(){
        return vendaConvenienciaService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaConveniencia> findById(@PathVariable Long id){
        return vendaConvenienciaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendaConveniencia create(@Valid @RequestBody VendaConveniencia vendaConveniencia){
        return vendaConvenienciaService.save(vendaConveniencia);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        vendaConvenienciaService.findById(id).map(vendaConveniencia -> {
            vendaConveniencia.setAtivo(false);
            return vendaConvenienciaService.update(id, vendaConveniencia);
        });
    }
}

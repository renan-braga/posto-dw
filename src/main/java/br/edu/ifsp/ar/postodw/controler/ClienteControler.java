package br.edu.ifsp.ar.postodw.controler;

import br.edu.ifsp.ar.postodw.model.Cliente;
import br.edu.ifsp.ar.postodw.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteControler {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> list(){
        return clienteService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        return clienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@Valid @RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        Cliente updatedCliente = clienteService.findClienteById(id);
        updatedCliente.setAtivo(true);
        clienteService.update(id, updatedCliente);
    }
    
    @PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_GERENCIA') and #oauth2.hasScope('write')")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
    	Cliente clienteSaved = clienteService.update(id, cliente);
		return ResponseEntity.ok(clienteSaved);
	}




}

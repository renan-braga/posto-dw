package br.edu.ifsp.ar.postodw.repository.cliente;

import java.util.List;

import br.edu.ifsp.ar.postodw.model.Cliente;
import br.edu.ifsp.ar.postodw.repository.fliter.ClienteFilter;

public interface ClienteRepositoryQuery {

	public List<Cliente> filter(ClienteFilter clienteFilter);
	
	}

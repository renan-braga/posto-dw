package br.edu.ifsp.ar.postodw.repository.fliter;

import javax.validation.constraints.Pattern;

import br.edu.ifsp.ar.postodw.model.User;

public class ClienteFilter {

	private User user;
	
	private String nome;

    @Pattern(regexp = "\\d{11}|\\d{14}")
    private String documento;

    
    
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}

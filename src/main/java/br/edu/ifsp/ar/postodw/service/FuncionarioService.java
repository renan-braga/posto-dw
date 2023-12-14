package br.edu.ifsp.ar.postodw.service;

import br.edu.ifsp.ar.postodw.model.Funcionario;
import br.edu.ifsp.ar.postodw.repository.FuncionarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> list(){
        return funcionarioRepository.findByAtivoTrue();
    }
    public Optional<Funcionario> findById(Long id){return funcionarioRepository.findById(id);}
    public Funcionario save(Funcionario funcionario){return funcionarioRepository.save(funcionario);}
    public void deleteById(Long id){funcionarioRepository.deleteById(id);}

    public Funcionario update(Long id, Funcionario funcionario) {
        Funcionario funcionarioSaved = findfuncionarioById(id);
        BeanUtils.copyProperties(funcionario, funcionarioSaved, "id");
        return funcionarioRepository.save(funcionarioSaved );
    }

    public Funcionario findfuncionarioById(Long id) {
        Funcionario funcionarioSaved = funcionarioRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return funcionarioSaved;
    }
}

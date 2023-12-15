package br.edu.ifsp.ar.postodw.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
@Getter @Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    private String cpf;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    private Boolean ativo = true;}

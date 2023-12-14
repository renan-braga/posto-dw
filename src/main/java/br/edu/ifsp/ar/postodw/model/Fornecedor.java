package br.edu.ifsp.ar.postodw.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fornecedor")
@Getter @Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 255, message = "O nome deve ter entre 3 e 255 caracteres")
    private String nome;

    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve ter 14 dígitos")
    private String cnpj;

    private Boolean ativo = true;}

package br.fatec.sp.gov.atividade1.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import br.fatec.sp.gov.atividade1.controller.View;


@Entity
@Table(name = "hab_habilidade",
        uniqueConstraints = @UniqueConstraint(columnNames = {"hab_nome"})
        )
public class Habilidade {

    @Id
    @Column(name="hab_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.PersonagemCompleto.class)
    private Long id;

    @Column(name="hab_nome")
    @NotNull
    @JsonView(View.PersonagemSimplificado.class)
    private String nome;

    @Column(name="hab_descricao")
    @JsonView(View.PersonagemSimplificado.class)
    private String descricao;

    @Column(name="hab_origem")
    @JsonView(View.PersonagemCompleto.class)
    private String origem;

    @JsonIgnore
    @ManyToMany(mappedBy = "habilidades", fetch = FetchType.LAZY)
    private Set<Personagem> personagens;

    public Set<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(Set<Personagem> personagens) {
        this.personagens = personagens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    
    
}
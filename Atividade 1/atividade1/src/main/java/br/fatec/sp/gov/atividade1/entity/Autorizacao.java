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



@Entity
@Table(name = "aut_autorizacao",
        uniqueConstraints = 
        @UniqueConstraint(columnNames = {"aut_nome"})
)
public class Autorizacao {
    
    @Id
    @Column(name = "aut_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="aut_nome")
    @NotNull
    private String nome;

    @ManyToMany(mappedBy = "autorizacoes", fetch = FetchType.LAZY)
    private Set<Usuario> usuarios;

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

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
}

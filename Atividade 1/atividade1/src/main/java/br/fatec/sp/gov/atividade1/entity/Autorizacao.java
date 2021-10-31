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

import com.fasterxml.jackson.annotation.JsonView;

import br.fatec.sp.gov.atividade1.controller.ViewUsuario;

@Entity
@Table(name = "aut_autorizacao")
public class Autorizacao {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "aut_id")
    @JsonView(ViewUsuario.UsuarioCompleto.class)
    private Long id;

    @Column(name = "aut_nome")
    @JsonView(ViewUsuario.UsuarioSimplificado.class)
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "autorizacoes")
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

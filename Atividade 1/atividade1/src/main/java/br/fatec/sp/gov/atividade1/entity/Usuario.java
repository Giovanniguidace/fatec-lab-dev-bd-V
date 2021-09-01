package br.fatec.sp.gov.atividade1.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usr_usuario",
        uniqueConstraints = 
        @UniqueConstraint(columnNames = {"usr_nome", "usr_email"})        
)
public class Usuario {
    
    @Id
    @Column(name="usr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usr_id;
    
    @Column(name = "usr_nome")
    @NotNull
    private String nome;

    @Column(name="usr_email")
    @NotNull
    private String email;
    
    @Column(name = "usr_senha")
    @NotNull
    private String senha;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "uau_usuario_autorizacao",
        joinColumns = { @JoinColumn(name = "usr_id")},
        inverseJoinColumns = { @JoinColumn(name = "aut_id")})
    private Set<Autorizacao> autorizacoes;

    public Long getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(Long usr_id) {
        this.usr_id = usr_id;
    }

    public Set<Autorizacao> getAutorizacoes() {
        return autorizacoes;
    }

    public void setAutorizacoes(Set<Autorizacao> autorizacoes) {
        this.autorizacoes = autorizacoes;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

}

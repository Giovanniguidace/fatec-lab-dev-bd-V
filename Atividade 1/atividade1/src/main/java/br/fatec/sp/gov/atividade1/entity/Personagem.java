package br.fatec.sp.gov.atividade1.entity;

import java.time.LocalDateTime;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;



@Entity
@Table(
    name="per_personagem",
    uniqueConstraints= 
        @UniqueConstraint(columnNames = {"per_nome"})
    )
public class Personagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="per_id")
    private Long id;

    @Column(name="per_nome")
    @NotNull
    private String nome;

    @Column(name="per_data_nascimento")
    @NotNull
    private LocalDateTime dataNascimento;

    @Column(name="per_titulo")
    @NotNull
    private String titulo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pha_personagem_habilidade",
        joinColumns = { @JoinColumn(name = "per_id")},
        inverseJoinColumns = { @JoinColumn(name = "hab_id")})
    private Set<Habilidade> habilidades;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personagem")
    private Set<Biografia> biografias;

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

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Set<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public Set<Biografia> getBiografias() {
        return biografias;
    }

    public void setBiografias(Set<Biografia> biografias) {
        this.biografias = biografias;
    }


    
}

package br.fatec.sp.gov.atividade1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.sp.gov.atividade1.entity.Habilidade;


public interface HabilidadeRepository extends JpaRepository<Habilidade, Long>{
    
    public Habilidade findByNome(String nome);

    public List<Habilidade> findByNomeContainsOrDescricaoContains(String nome, String descricao);
    
}

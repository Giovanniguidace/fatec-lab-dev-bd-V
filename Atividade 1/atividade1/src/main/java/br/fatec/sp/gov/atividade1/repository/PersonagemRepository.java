package br.fatec.sp.gov.atividade1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.sp.gov.atividade1.entity.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long>{
    
    public Personagem findByNome(String nome);

    public List<Personagem> findByNomeContainsOrTituloContains(String nome, String Titulo);


}

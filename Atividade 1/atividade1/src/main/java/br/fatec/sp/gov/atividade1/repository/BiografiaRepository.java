package br.fatec.sp.gov.atividade1.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.sp.gov.atividade1.entity.Biografia;
import br.fatec.sp.gov.atividade1.entity.Personagem;

public interface BiografiaRepository extends JpaRepository<Biografia, Long>{

    public List<Biografia> findByPersonagemNome(String nome);

}

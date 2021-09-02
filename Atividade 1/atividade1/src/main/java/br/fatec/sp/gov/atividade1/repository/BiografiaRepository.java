package br.fatec.sp.gov.atividade1.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.sp.gov.atividade1.entity.Biografia;

public interface BiografiaRepository extends JpaRepository<Biografia, Long>{
    
    public Biografia findByData(LocalDateTime data);
    
    public List<Biografia> findByDataContainsOrEntradaContains(LocalDateTime data, String entrada);
    

    
}

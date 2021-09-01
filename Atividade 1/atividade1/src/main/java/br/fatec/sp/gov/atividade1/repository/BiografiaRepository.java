package br.fatec.sp.gov.atividade1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.sp.gov.atividade1.entity.Biografia;

public interface BiografiaRepository extends JpaRepository<Biografia, Long>{
    
    public Biografia findByData(String data);
    
}

package br.fatec.sp.gov.atividade1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.sp.gov.atividade1.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {
    
    public Autorizacao findByNome(String nome);

    
}

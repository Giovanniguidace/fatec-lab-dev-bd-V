package br.fatec.sp.gov.atividade1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.sp.gov.atividade1.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Usuario findByNome(String nome);
}

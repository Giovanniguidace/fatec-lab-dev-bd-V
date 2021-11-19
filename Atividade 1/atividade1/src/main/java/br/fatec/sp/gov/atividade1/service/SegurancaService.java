package br.fatec.sp.gov.atividade1.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.fatec.sp.gov.atividade1.entity.Usuario;

public interface SegurancaService extends UserDetailsService {

    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();
    
}

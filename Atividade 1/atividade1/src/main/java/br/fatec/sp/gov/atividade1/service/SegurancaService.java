package br.fatec.sp.gov.atividade1.service;

import java.util.List;

import br.fatec.sp.gov.atividade1.entity.Usuario;

public interface SegurancaService {

    public Usuario novoUsuario(String nome, String email, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();
    
}

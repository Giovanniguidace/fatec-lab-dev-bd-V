package br.fatec.sp.gov.atividade1.service;

import java.time.LocalDateTime;
import java.util.List;

import br.fatec.sp.gov.atividade1.entity.Personagem;

public interface PersonagemService {

    public Personagem novoPersonagem(String nome, LocalDateTime dataNascimento, String titulo,
    String habilidade,String nomeHabilidade,String descricao, String origem);

    public List<Personagem> buscarTodosPersonagens();
    
}

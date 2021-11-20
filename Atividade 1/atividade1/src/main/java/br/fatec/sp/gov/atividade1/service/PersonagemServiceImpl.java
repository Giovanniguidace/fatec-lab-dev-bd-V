package br.fatec.sp.gov.atividade1.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.sp.gov.atividade1.entity.Habilidade;
import br.fatec.sp.gov.atividade1.entity.Personagem;
import br.fatec.sp.gov.atividade1.repository.HabilidadeRepository;
import br.fatec.sp.gov.atividade1.repository.PersonagemRepository;

import org.springframework.security.access.prepost.PreAuthorize;

@Service
public class PersonagemServiceImpl implements PersonagemService {
    
    @Autowired
    PersonagemRepository personagemRepo;

    @Autowired
    HabilidadeRepository habilidadeRepo;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public Personagem novoPersonagem(String nome, LocalDateTime dataNascimento, String titulo,
    String habilidade,String nomeHabilidade, String descricao, String origem){
        
        Habilidade hab = habilidadeRepo.findByNome(habilidade);

        if(hab == null){
            hab = new Habilidade();
            hab.setNome(nomeHabilidade);
            hab.setDescricao(descricao);
            hab.setOrigem(origem);
            habilidadeRepo.save(hab);
        }

        Personagem personagem = new Personagem();
        personagem.setNome(nome);
        personagem.setDataNascimento(dataNascimento);
        personagem.setTitulo(titulo);
        personagem.setHabilidades(new HashSet<Habilidade>());
        personagem.getHabilidades().add(hab);
        personagemRepo.save(personagem);

        return personagem;

    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN', 'USUARIO')")
    public List<Personagem> buscarTodosPersonagens(){
        return personagemRepo.findAll();
    }
}

package br.fatec.sp.gov.atividade1.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.sp.gov.atividade1.entity.Personagem;
import br.fatec.sp.gov.atividade1.service.PersonagemService;

@RestController
@CrossOrigin
@RequestMapping(value = "/personagem")
public class PersonagemController {
    
    @Autowired
    private PersonagemService personagemService;

    @GetMapping
    @JsonView(View.PersonagemSimplificado.class)
    public List<Personagem> buscarTodosPersonagens(){
        return personagemService.buscarTodosPersonagens();
    }


    @PostMapping
    @JsonView(View.PersonagemCompleto.class)
    public Personagem novoPersonagem(@RequestBody Personagem personagem){
        return personagemService.novoPersonagem(personagem.getNome(), personagem.getDataNascimento(), personagem.getTitulo(), "ROLE_HABILIDADE", "ROLE_HABILIDADE", "ROLE_HABILIDADE", "ROLE_HABILIDADE");
    }
    


}

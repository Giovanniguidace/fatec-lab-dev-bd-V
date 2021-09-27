package br.fatec.sp.gov.atividade1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.fatec.sp.gov.atividade1.entity.Autorizacao;
import br.fatec.sp.gov.atividade1.entity.Biografia;
import br.fatec.sp.gov.atividade1.entity.Habilidade;
import br.fatec.sp.gov.atividade1.entity.Personagem;
import br.fatec.sp.gov.atividade1.entity.Usuario;
import br.fatec.sp.gov.atividade1.repository.AutorizacaoRepository;
import br.fatec.sp.gov.atividade1.repository.BiografiaRepository;
import br.fatec.sp.gov.atividade1.repository.HabilidadeRepository;
import br.fatec.sp.gov.atividade1.repository.PersonagemRepository;
import br.fatec.sp.gov.atividade1.repository.UsuarioRepository;
import br.fatec.sp.gov.atividade1.service.PersonagemService;

@SpringBootTest
@Transactional
@Rollback
class Atividade1ApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private PersonagemRepository personagemRepo;

	@Autowired
	private HabilidadeRepository habilidadeRepo;

	@Autowired
	private AutorizacaoRepository autorizacaoRepo;

	@Autowired
	private BiografiaRepository biografiaRepo;

	@Autowired
	private PersonagemService personagemService;


	@Test
	void contextLoads() {
	}

	/* TEST'S ENTITY PERSONAGEM */ 

	@Test
	void findByNomeTest_personagem() {
		Personagem personagem = new Personagem();
		personagem.setNome("Homem Aranha");
		personagem.setDataNascimento(LocalDateTime.now());
		personagem.setTitulo("As aventuras do homem aranha");
		personagemRepo.save(personagem);

		assertNotNull(personagemRepo.findByNome("Homem Aranha"));
	}

	@Test
	void findByNomeContainsOrTituloContainsTest_personagem() {
		Personagem personagem = new Personagem();
		personagem.setNome("Homem Aranha");
		personagem.setDataNascimento(LocalDateTime.now());
		personagem.setTitulo("As aventuras do homem aranha");
		personagemRepo.save(personagem);
		

		assertFalse(personagemRepo.findByNomeContainsOrTituloContains("em", "nha").isEmpty());
	}

	@Test
	void  findByHabilidadeDescricaoTest_personagem(){
		Habilidade habilidade = new Habilidade();
		habilidade.setNome("Teste");
		habilidade.setDescricao("Teste");
		habilidade.setOrigem("Teste");
		habilidadeRepo.save(habilidade);

		Personagem personagem = new Personagem();
		personagem.setNome("Teste");
		personagem.setTitulo("Teste");
		personagem.setDataNascimento(LocalDateTime.now());
		personagem.setHabilidades(new HashSet<Habilidade>());
		personagem.getHabilidades().add(habilidade);
		personagemRepo.save(personagem);


		assertFalse(personagemRepo.findByHabilidadesDescricao("Teste").isEmpty());
	}

	@Test
	void findByBiografiasEntradaTest_personagem() {
		Personagem personagem = new Personagem();
		personagem.setNome("Homem Aranha");
		personagem.setDataNascimento(LocalDateTime.now());
		personagem.setTitulo("As aventuras do homem aranha");
		personagemRepo.save(personagem);

		Biografia biografia = new Biografia();
		biografia.setEntrada("Teste");
		biografia.setData(LocalDateTime.now());
		biografia.setPersonagem(personagem);

		biografiaRepo.save(biografia);

		assertFalse(personagemRepo.findByBiografiasEntrada("Teste").isEmpty());
	}

	


	/* TEST'S ENTITY USUARIO */ 

	@Test
	void findByNomeTest_usuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("João");
		usuario.setSenha("123");
		usuario.setEmail("joao@email.com");
		usuarioRepo.save(usuario);
		
		assertNotNull(usuarioRepo.findByNome("João"));
	}

	@Test
	void findByNomeContainsOrEmailContainsTest_usuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("João");
		usuario.setSenha("123");
		usuario.setEmail("joao@email.com");
		usuarioRepo.save(usuario);

		assertFalse(usuarioRepo.findByNomeContainsOrEmailContains("ão", "email").isEmpty());
	}

	@Test
	void  findByAutorizacoesNomeTest_usuario(){
		Autorizacao autorizacao = new Autorizacao();
		autorizacao.setNome("Teste");
		autorizacaoRepo.save(autorizacao);

		Usuario usuario = new Usuario();
		usuario.setNome("João");
		usuario.setSenha("123");
		usuario.setEmail("joao@email.com");
		usuario.setAutorizacoes(new HashSet<Autorizacao>());
		usuario.getAutorizacoes().add(autorizacao);
		usuarioRepo.save(usuario);

		assertFalse(usuarioRepo.findByAutorizacoesNome("Teste").isEmpty());
	}


	/* TEST'S ENTITY AUTORIZACAO */  
	
	@Test
	void  findByUsuariosNomeTest_autorizacao(){
		Autorizacao autorizacao = new Autorizacao();
		autorizacao.setNome("Teste");
		autorizacaoRepo.save(autorizacao);

		Usuario usuario = new Usuario();
		usuario.setNome("João");
		usuario.setSenha("123");
		usuario.setEmail("joao@email.com");
		usuario.setAutorizacoes(new HashSet<Autorizacao>());
		usuario.getAutorizacoes().add(autorizacao);
		usuarioRepo.save(usuario);

		assertFalse(autorizacaoRepo.findByUsuariosNome("João").isEmpty());
	}

	

	/* TEST'S ENTITY HABILIDADE */ 

	@Test
	void findByNomeTest_habilidade() {
		Habilidade habilidade = new Habilidade();
		habilidade.setNome("Desenvolvimento");
		habilidade.setDescricao("Habilidade para pessoas que desenvolvem");
		habilidade.setOrigem("SQUAD DEV");
		habilidadeRepo.save(habilidade);

		assertNotNull(habilidadeRepo.findByNome("Desenvolvimento"));
	}

	@Test
	void findByNomeContainsOrDescricaoContainsTest_habilidade() {
		Habilidade habilidade = new Habilidade();
		habilidade.setNome("Desenvolvimento");
		habilidade.setDescricao("Habilidade para pessoas que desenvolvem");
		habilidade.setOrigem("SQUAD DEV");
		habilidadeRepo.save(habilidade);

		assertFalse(habilidadeRepo.findByNomeContainsOrDescricaoContains("env", "3242344").isEmpty());
	}

	@Test
	void  findByPersonagemNomeTest_habilidade(){
		Habilidade habilidade = new Habilidade();
		habilidade.setNome("Teste");
		habilidade.setDescricao("Teste");
		habilidade.setOrigem("Teste");
		habilidadeRepo.save(habilidade);

		

		Personagem personagem = new Personagem();
		personagem.setNome("Teste");
		personagem.setTitulo("Teste");
		personagem.setDataNascimento(LocalDateTime.now());
		personagem.setHabilidades(new HashSet<Habilidade>());
		personagem.getHabilidades().add(habilidade);
		personagemRepo.save(personagem);


		assertFalse(habilidadeRepo.findByPersonagensNome("Teste").isEmpty());
	}


	/* TEST'S ENTITY BIOGRAFIA */ 

	@Test
	void findByPersonagemNomeTest_biografia() {
		Personagem personagem = new Personagem();
		personagem.setNome("Homem Aranha");
		personagem.setDataNascimento(LocalDateTime.now());
		personagem.setTitulo("As aventuras do homem aranha");
		personagemRepo.save(personagem);

		Biografia biografia = new Biografia();
		biografia.setEntrada("Teste");
		biografia.setData(LocalDateTime.now());
		biografia.setPersonagem(personagem);

		biografiaRepo.save(biografia);

		assertFalse(biografiaRepo.findByPersonagemNome("Homem Aranha").isEmpty());
	}


	/* TEST'S SERVICE PERSONAGEM SERVICE */

	@Test
	void novoPersonagem_Test(){
		personagemService.novoPersonagem("Teste", LocalDateTime.now(), "Teste", "Teste", "Teste", "Teste", "Teste");

		assertNotNull(personagemRepo.findByNome("Teste"));
	}
	
}

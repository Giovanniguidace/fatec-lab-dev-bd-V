package br.fatec.sp.gov.atividade1;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
@Rollback
class Atividade1ApplicationTests {

	@Test
	void contextLoads() {
	}

}

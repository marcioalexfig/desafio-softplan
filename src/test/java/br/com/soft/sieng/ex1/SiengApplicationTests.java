package br.com.soft.sieng.ex1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.soft.sieng.ex1.modelo.NotaFiscal;
import br.com.soft.sieng.ex1.relatorio.gerador.Gerador;
import br.com.soft.sieng.ex1.relatorio.gerador.GeradorObservacao;
import br.com.soft.sieng.ex1.relatorio.gerador.GeradorObservacaoV2;
import br.com.soft.sieng.ex1.repositorio.NotaFiscalRepository;

@SpringBootTest
class SiengApplicationTests {

	final String FRASE_SINGULAR = "Fatura da nota fiscal de simples remessa:";
	final String FRASE_PLURAL = "Fatura das notas fiscais de simples remessa:";
	
	@Test
	@DisplayName("Verifica Criação de Objetos")
	void verificaMetodoCriacaoObjeto() {

			GeradorObservacao gerador =  new GeradorObservacao();
			assertNotNull(gerador);
			
			Gerador geradorV1 = new GeradorObservacao();
			assertNotNull(geradorV1);
			
			Gerador geradorV2 = new GeradorObservacaoV2();
			assertNotNull(geradorV2);

	}
	
	/**
	 * Testes classe legada
	 */
	@Test
	@DisplayName("Verifica retorno da classe legada.")
	void verificaRetornoGeradorLegado() {
		Gerador gerador =  new GeradorObservacao();
		String retorno = gerador.geraObservacao( Arrays.asList(1, 2, 3, 4, 5));
		assertEquals(FRASE_PLURAL +" 1, 2, 3, 4 e 5.", retorno);
	}
	
	@Test
	@DisplayName("Verifica retorno da classe legada via interface Gerador.")
	void verificaRetornoGeradorLegadoViaInterface() {
		Gerador geradorV1 = new GeradorObservacao();
		String retorno = geradorV1.geraObservacao( Arrays.asList(1, 2, 3, 4, 5));
		assertEquals(FRASE_PLURAL + " 1, 2, 3, 4 e 5.", retorno);
	}
	
	@Test
	@DisplayName("Verifica plurais da classe legada.")
	void verificaPluraisLegado() {
		Gerador gerador =  new GeradorObservacao();
		
		String retornoPlural = gerador.geraObservacao( Arrays.asList(1, 2, 3, 4, 5));
		assertTrue( retornoPlural.indexOf("das") > -1);
		assertTrue( retornoPlural.indexOf("notas") > -1);
		assertTrue( retornoPlural.indexOf("fiscais") > -1);
		
		
		String retornoSingular = gerador.geraObservacao( Arrays.asList(1));
		assertTrue( retornoSingular.indexOf("da") > -1);
		assertTrue( retornoSingular.indexOf("nota") > -1);
		assertTrue( retornoSingular.indexOf("fiscal") > -1);
	}
	
	/**
	 * Testes classe V2
	 */
	@Test
	@DisplayName("Verifica retorno da classe V2.")
	void verificaRetornoGeradorV2() {
		Gerador geradorV2 =  new GeradorObservacaoV2();
		String retorno = geradorV2.geraObservacao( Arrays.asList(1, 2, 3, 4, 5));
		assertEquals(FRASE_PLURAL + " 1 cujo valor é R$ 10,00, 2 cujo valor é R$ 35,00, 3 cujo valor é R$ 5,00, 4 cujo valor é R$ 1.500,00 e 5 cujo valor é R$ 0,30. R$ 1.550,30.", retorno);		
	}
	
	@Test
	@DisplayName("Verifica entrada de notas inexistentes V2.")
	void verificaNotasInexistentes() {
		Gerador geradorV2 =  new GeradorObservacaoV2();
		String retorno = geradorV2.geraObservacao( Arrays.asList(1, 2, 3, 4, 5, 40, 700));
		assertEquals(FRASE_PLURAL + " 1 cujo valor é R$ 10,00, 2 cujo valor é R$ 35,00, 3 cujo valor é R$ 5,00, 4 cujo valor é R$ 1.500,00 e 5 cujo valor é R$ 0,30. R$ 1.550,30.", retorno);	
	}
	
	@Test
	@DisplayName("Verifica se lista de parametros está vazia.")
	void verificaListaParametroV2() {
		List<NotaFiscal> notas = NotaFiscalRepository.findAll();
		assertNotNull(notas);
	}
	
	@Test
	@DisplayName("Verifica plurais da classe V2.")
	void verificaPluraisV2() {
		Gerador geradorV2 =  new GeradorObservacaoV2();
		
		String retornoPlural = geradorV2.geraObservacao( Arrays.asList(1, 2, 3, 4, 5));
		assertTrue( retornoPlural.indexOf("das") > -1);
		assertTrue( retornoPlural.indexOf("notas") > -1);
		assertTrue( retornoPlural.indexOf("fiscais") > -1);
		
		
		String retornoSingular = geradorV2.geraObservacao( Arrays.asList(1));
		assertTrue( retornoSingular.indexOf("da") > -1);
		assertTrue( retornoSingular.indexOf("nota") > -1);
		assertTrue( retornoSingular.indexOf("fiscal") > -1);
	}

}

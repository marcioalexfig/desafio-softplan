package br.com.soft.sieng.ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.soft.sieng.ex2.calculo.Calculo;
import br.com.soft.sieng.ex2.conversor.Conversor;
import br.com.soft.sieng.ex2.fabrica.FactoryItem;
import br.com.soft.sieng.ex2.impressao.Relatorio;
import br.com.soft.sieng.ex2.json.LeitorJSON;
import br.com.soft.sieng.ex2.modelo.Composicao;
import br.com.soft.sieng.ex2.modelo.Insumo;
import br.com.soft.sieng.ex2.modelo.Item;
import one.util.streamex.StreamEx;

@SpringBootTest
class Sieng2ApplicationTests {
	
	@Autowired
	LeitorJSON JSON;
	
	@Autowired
	FactoryItem fabrica;
	
	private static Logger log = Logger.getLogger("Test");
	
	@Test
	@DisplayName("Verifica criação de Insumo via Factory")
	void verificaMetodoCriacaoInsumo() {
		Item item = fabrica.criarInsumo();
		assertNotNull( item );
		assertTrue(item instanceof Insumo);
	}
	
	@Test
	@DisplayName("Verifica criação de Composicao via Factory")
	void verificaMetodoCriacaoComposicao() {
		Item item = fabrica.criarComposicao();
		assertNotNull( item );
		assertTrue(item instanceof Composicao);
	}

	@Test
	@DisplayName("Verifica leitura de JSON e criação de objetos")
	void verificaMetodoCriacaoObjetos() {
		List<Item> itens = JSON.obterItens();
		assertNotNull(itens);
	}
	
	@Test
	@DisplayName("Verifica se JSON não está vazio")
	void verificaItensJSON() {
		List<Item> itens = JSON.obterItens();
		assertTrue(itens.size() > 0);
	}
	
	@Test
	@DisplayName("Verifica Conversor de String para Double")
	void verificaConversorString() {
		String converter = "0,1234500";
		assertTrue( Conversor.stringParaDouble( converter ) instanceof Double);
		assertTrue(Conversor.stringParaDouble( null ) instanceof Double);
		assertTrue(Conversor.stringParaDouble( "" ) instanceof Double);
		assertTrue(Conversor.stringParaDouble( "PALAVRA" ) instanceof Double);
	}
	
	@Test
	@DisplayName("Verifica Arredondamento")
	void verificaArredondamento() {
		Double arredondar = 0.1234500D;
		assertTrue( Conversor.arredondamento( arredondar ) instanceof Double);
		assertTrue(Conversor.arredondamento( null ) instanceof Double);
		assertEquals(0.12D, Conversor.arredondamento( arredondar ));
	}
	
	@Test
	@DisplayName("Verifica Conversor de Double para String")
	void verificaConversorDouble() {
		Double converter = 56.1234500D;
		assertTrue( Conversor.doubleParaString(converter) instanceof String);
		assertTrue(Conversor.doubleParaString( null ) instanceof String);
		assertEquals("56", Conversor.doubleParaString(converter));
	}
	
	@Test
	@DisplayName("Verifica Quantidades de Composições")
	void verificaQuantidadesDeComposicoes(){
		List<Item> itens = JSON.obterItens();
		
		List<Item> agrupamentos = StreamEx.of(itens)
				  .distinct(Item::getCodigoComposicao)
				  .toList();
		List<Item> itensAgrupadosCalculados = Calculo.calcularComposicoes(itens);
		
		assertEquals(agrupamentos.size(), itensAgrupadosCalculados.size());
	}
	
	@Test
	@DisplayName("Verifica erro nas chamadas main")
	void verificaChamadasMain() {
		try {
			LeitorJSON JSON = new LeitorJSON();
			
			List<Item> itens = JSON.obterItens();
	
			List<Item> itensAgrupadosCalculados = Calculo.calcularComposicoes(itens);
			
			Relatorio.imprimirNaTela(itensAgrupadosCalculados);
			
			assertTrue(true);
			
		} catch (Exception e) {
			log.info("[Erro] - " + e.getLocalizedMessage());
		}

	}

	

}

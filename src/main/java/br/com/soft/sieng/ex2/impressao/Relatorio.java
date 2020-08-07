package br.com.soft.sieng.ex2.impressao;

import java.util.List;

import br.com.soft.sieng.ex2.modelo.Item;

public class Relatorio {
	
	public static void imprimirNaTela(List<Item> lista) {		
		
		for ( Item item : lista ) {
			System.out.println(String.format("%20s %60s %5s %20s", item.getCodigoComposicao(), item.getDescricaoComposicao(), item.getUnidadeComposicao(), item.getValorUnitario().toString().replace(".", ",")));
		}

	} 

}

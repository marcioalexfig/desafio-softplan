package br.com.soft.sieng.ex2.calculo;

import java.util.List;
import java.util.stream.Collectors;

import br.com.soft.sieng.ex2.conversor.Conversor;
import br.com.soft.sieng.ex2.modelo.Item;
import one.util.streamex.StreamEx;

public class Calculo {
	
	public static List<Item> calcularComposicoes(List<Item> lista){	
		List<Item> composicoes = StreamEx.of(lista)
				  .distinct(Item::getCodigoComposicao)
				  .toList();

		if( !composicoes.isEmpty() ) {
			
			composicoes.forEach( composicao -> {
				Double total = 0D;
				List<Item> itensComposicao = lista.stream().filter(item -> item.getCodigoComposicao().equals(composicao.getCodigoComposicao())).collect(Collectors.toList());
				
				for (Item it : itensComposicao) {
					total += Conversor.arredondamento( it.getValorUnitario() * it.getQuantidadeComposicao() )  ;
				}
				
				composicao.setValorUnitario( Conversor.arredondamento(total));
				
			});
			
		}
		return composicoes;
	}
}
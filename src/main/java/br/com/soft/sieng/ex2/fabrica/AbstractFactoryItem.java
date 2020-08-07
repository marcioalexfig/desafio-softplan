
package br.com.soft.sieng.ex2.fabrica;

import br.com.soft.sieng.ex2.modelo.Item;

public interface AbstractFactoryItem {
	
	Item criarInsumo();
	Item criarComposicao();
	Item criarItem(String item);
	

}
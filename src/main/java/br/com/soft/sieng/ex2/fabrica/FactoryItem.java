package br.com.soft.sieng.ex2.fabrica;

import org.springframework.stereotype.Component;

import br.com.soft.sieng.ex2.enumerador.Tipo;
import br.com.soft.sieng.ex2.modelo.Composicao;
import br.com.soft.sieng.ex2.modelo.Insumo;
import br.com.soft.sieng.ex2.modelo.Item;

@Component
public class FactoryItem implements AbstractFactoryItem{

	@Override
	public Item criarInsumo() {
		return new Insumo();
	}

	@Override
	public Item criarComposicao() {
		return new Composicao();
	}

	@Override
	public Item criarItem(String tipo) {
		return tipo.equals(Tipo.INSUMO.toString()) ? criarInsumo() : criarComposicao();
	}

}

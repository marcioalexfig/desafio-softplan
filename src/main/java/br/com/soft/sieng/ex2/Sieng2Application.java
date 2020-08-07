package br.com.soft.sieng.ex2;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.soft.sieng.ex2.calculo.Calculo;
import br.com.soft.sieng.ex2.impressao.Relatorio;
import br.com.soft.sieng.ex2.json.LeitorJSON;
import br.com.soft.sieng.ex2.modelo.Item;

@SpringBootApplication
public class Sieng2Application {


	public static void main(String[] args) {
		SpringApplication.run(Sieng2Application.class, args);
		
		LeitorJSON JSON = new LeitorJSON();
		
		List<Item> itens = JSON.obterItens();

		List<Item> itensAgrupadosCalculados = Calculo.calcularComposicoes(itens);
		
		Relatorio.imprimirNaTela(itensAgrupadosCalculados);
		


	}

}

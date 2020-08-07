package br.com.soft.sieng.ex2.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import br.com.soft.sieng.ex2.conversor.Conversor;
import br.com.soft.sieng.ex2.fabrica.FactoryItem;
import br.com.soft.sieng.ex2.modelo.Item;



@Component
public class LeitorJSON {
	private Logger log = Logger.getLogger("LeitorJSON");
	
	public List<Item> obterItens() {
		FactoryItem fabrica = new FactoryItem();
		List<Item> itens = new ArrayList<>();
		try {
			FileReader arq = new FileReader(new File("./src/main/resources/dados-entrada-servicos-composicoes.json"));
	        BufferedReader lerArq = new BufferedReader(arq);
	        StringBuilder str = new StringBuilder();
	        String linha = lerArq.readLine();
	        while (linha != null) {
	        	str.append(linha);
	        	linha = lerArq.readLine();
	        }
	        JSONArray jsonArray = new JSONArray(str.toString());
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject objJson = jsonArray.getJSONObject(i);
                String tipo = objJson.getString("tipoItem");
                Item novoItem = fabrica.criarItem(tipo);
                novoItem.setCodigoComposicao( Conversor.doubleParaString(objJson.getDouble("codigoComposicao")) );
                novoItem.setDescricaoComposicao(objJson.getString("descricaoComposicao"));
                novoItem.setUnidadeComposicao(objJson.getString("unidadeComposicao"));
                novoItem.setTipoItem(objJson.getString("tipoItem"));
                novoItem.setCodigoItem(String.valueOf(objJson.getDouble("codigoItem")));
                novoItem.setDescricaoItemComposicao(objJson.getString("descricaoItemComposicao"));
                novoItem.setUnidadeItem(objJson.getString("unidadeItem"));
                novoItem.setQuantidadeComposicao(Conversor.stringParaDouble(objJson.getString("quantidadeComposicao")));
                novoItem.setValorUnitario(Conversor.stringParaDouble(objJson.getString("valorUnitario")));
                itens.add( novoItem );
            }
        }catch(IOException e){
            log.info("[Erro] - " + e.getLocalizedMessage());
        }
		return itens;
	}

}

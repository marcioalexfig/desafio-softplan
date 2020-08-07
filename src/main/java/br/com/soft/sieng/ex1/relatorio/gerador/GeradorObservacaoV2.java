package br.com.soft.sieng.ex1.relatorio.gerador;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import br.com.soft.sieng.ex1.conversor.Conversor;
import br.com.soft.sieng.ex1.modelo.NotaFiscal;
import br.com.soft.sieng.ex1.repositorio.NotaFiscalRepository;

public class GeradorObservacaoV2 implements Gerador {

	private final String FRASE_SINGULAR = "Fatura da nota fiscal de simples remessa: ";
	private final String FRASE_PLURAL = "Fatura das notas fiscais de simples remessa: ";
	private final String FRASE_LINHA = " cujo valor é ";
	private List<NotaFiscal> listaNotas;
	private Double total = 0D;
	private String relatorio;
	private Logger log = Logger.getLogger("GeradorObservacaoV2");
	

	@Override
	public String geraObservacao(List<?> lista) {
		try {
			tratarEntradaInvalida( lista );
			obterNotas( lista );
			gerarRelatorio( listaNotas );
		} 
		catch (IllegalArgumentException arg){	log.info("[Erro] Argumento inválido!");  } 
		catch (NullPointerException np) 	{	log.info("[Erro] "+ np.getMessage() +" - "+ np.getStackTrace().toString());  }
			
		return relatorio;
	}
	
	private void obterNotas(List<?> lista){
		listaNotas = new ArrayList<>();
		for( int i=0; i<lista.size(); i++) {
			NotaFiscal nota = NotaFiscalRepository.findNotaByNumber((Integer)lista.get(i)); 
			if ( nota!=null ) listaNotas.add( nota );
		}
	}
	
	private void tratarEntradaInvalida(List<?> lista) {
		if (lista == null || lista.size() == 0) {
			throw new IllegalArgumentException( "[Erro] Argumento inválido!" );
		}
	}
	
	private Double obterTotal(List<NotaFiscal> lista) {
		lista.forEach(nota -> {
			total += nota.getValor();
		});
		return total;
	}
	
	private void gerarRelatorio(List<NotaFiscal> lista) {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append( retornarFrase( lista ) );
		for (int i = 0; i < lista.size() ; i++) {
			stringBuilder	
			.append( lista.get(i).getNumero() ) 
			.append(FRASE_LINHA)
			.append(Conversor.formatarValor(lista.get(i).getValor()))
			.append((i == lista.size() - 2) ? " e " : (i == lista.size() - 1) ? "." : ", ");
		}
		stringBuilder
			.append(" ")
			.append( Conversor.formatarValor( obterTotal ( lista ) ) )
			.append(".");
		
		relatorio = stringBuilder.toString();

	}
	
	private String retornarFrase(List<NotaFiscal> lista) {
		return ( lista.size() > 1) ? FRASE_PLURAL : FRASE_SINGULAR ;
	}


}

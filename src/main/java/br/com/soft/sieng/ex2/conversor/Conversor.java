package br.com.soft.sieng.ex2.conversor;

import java.math.BigDecimal;

public class Conversor {

	public static Double stringParaDouble(String valor) {
		if ( valor == null || valor.isBlank() ) return 0D;
		valor = valor.replace(',', '.');
		try {
			double retorno = Double.parseDouble(valor);
			return retorno;
		} catch (NumberFormatException e) {
			return 0D;
		} 
		
	}
	
	@SuppressWarnings("deprecation") public static Double arredondamento(Double valorUnitario) {
		if ( valorUnitario == null || valorUnitario.isNaN() || valorUnitario.isInfinite() ) return 0D;
		String data = String.valueOf(valorUnitario);  
		BigDecimal decimal = new  BigDecimal(data);  
		return Double.parseDouble( decimal.setScale(2, BigDecimal.ROUND_FLOOR).toPlainString() );
	}

	@SuppressWarnings("deprecation") public static String doubleParaString(Double valor) {
		if ( valor == null || valor.isNaN() || valor.isInfinite() ) return "";
		String data = String.valueOf(valor);  
		BigDecimal decimal = new  BigDecimal(data);  
		return decimal.setScale(0, BigDecimal.ROUND_FLOOR).toPlainString();
	}

}

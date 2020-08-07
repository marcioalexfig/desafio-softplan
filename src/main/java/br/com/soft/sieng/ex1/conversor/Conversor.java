package br.com.soft.sieng.ex1.conversor;

import java.text.NumberFormat;

public class Conversor {

	public static String formatarValor(Double valor) {
		return NumberFormat.getCurrencyInstance().format(valor);
	}
	
}

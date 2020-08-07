package br.com.soft.sieng.ex1.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.soft.sieng.ex1.modelo.NotaFiscal;

/**
 * Classe que simula repositorio de dados
 */
public class NotaFiscalRepository {
	public static NotaFiscal findNotaByNumber(Integer numeroNota) {
		List<NotaFiscal> notas = new ArrayList<>();
		notas.add(new NotaFiscal(1, 10.0));
		notas.add(new NotaFiscal(2, 35.0));
		notas.add(new NotaFiscal(3, 5.0));
		notas.add(new NotaFiscal(4, 1500.0));
		notas.add(new NotaFiscal(5, 0.30));
		List<NotaFiscal> lista = notas.stream().filter( nota -> nota.getNumero() == numeroNota).collect(Collectors.toList());
		if ( lista.size() > 0) {
			NotaFiscal notaFiscal = lista.get(0);
			return notaFiscal;
		}
		return null;
	}
	
	public static List<NotaFiscal> findAll() {	
		List<NotaFiscal> notas = new ArrayList<>();
		notas.add(new NotaFiscal(1, 10.0));
		notas.add(new NotaFiscal(2, 35.0));
		notas.add(new NotaFiscal(3, 5.0));
		notas.add(new NotaFiscal(4, 1500.0));
		notas.add(new NotaFiscal(5, 0.30));
		return notas;
	}

}

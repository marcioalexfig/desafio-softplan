package br.com.soft.sieng.ex1.modelo;

public class NotaFiscal {
	
	private Integer numero;
	private Double valor;
	
	public NotaFiscal() {}
	public NotaFiscal(Integer numero, Double valor) {
		super();
		this.numero = numero;
		this.valor = valor;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

}

package br.com.soft.sieng.ex2.modelo;

public abstract class Item {
	String codigoComposicao;
    String descricaoComposicao;
    String unidadeComposicao;
    String tipoItem;
    String codigoItem;
    String descricaoItemComposicao;
    String unidadeItem;
    Double quantidadeComposicao;
    Double valorUnitario;

	public String getDescricaoComposicao() {
		return descricaoComposicao;
	}
	public void setDescricaoComposicao(String descricaoComposicao) {
		this.descricaoComposicao = descricaoComposicao;
	}
	public String getUnidadeComposicao() {
		return unidadeComposicao;
	}
	public void setUnidadeComposicao(String unidadeComposicao) {
		this.unidadeComposicao = unidadeComposicao;
	}
	public String getTipoItem() {
		return tipoItem;
	}
	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public String getDescricaoItemComposicao() {
		return descricaoItemComposicao;
	}
	public void setDescricaoItemComposicao(String descricaoItemComposicao) {
		this.descricaoItemComposicao = descricaoItemComposicao;
	}
	public String getUnidadeItem() {
		return unidadeItem;
	}
	public void setUnidadeItem(String unidadeItem) {
		this.unidadeItem = unidadeItem;
	}
	public Double getQuantidadeComposicao() {
		return quantidadeComposicao;
	}
	public void setQuantidadeComposicao(Double quantidadeComposicao) {
		this.quantidadeComposicao = quantidadeComposicao;
	}
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public String getCodigoComposicao() {
		return codigoComposicao;
	}
	public void setCodigoComposicao(String codigoComposicao) {
		this.codigoComposicao = codigoComposicao;
	}
	public String getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}
	
	
    
}

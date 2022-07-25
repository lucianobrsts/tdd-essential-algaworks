package com.algaworks;

public class ResumoPedido {

	private double valorTatal;
	private double desconto;

	public ResumoPedido(double valorTatal, double desconto) {
		super();
		this.valorTatal = valorTatal;
		this.desconto = desconto;
	}

	public double getValorTatal() {
		return valorTatal;
	}

	public void setValorTatal(double valorTatal) {
		this.valorTatal = valorTatal;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

}

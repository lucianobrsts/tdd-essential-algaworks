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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(desconto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorTatal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResumoPedido other = (ResumoPedido) obj;
		if (Double.doubleToLongBits(desconto) != Double.doubleToLongBits(other.desconto))
			return false;
		if (Double.doubleToLongBits(valorTatal) != Double.doubleToLongBits(other.valorTatal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResumoPedido [valorTatal=" + valorTatal + ", desconto=" + desconto + "]";
	}

}

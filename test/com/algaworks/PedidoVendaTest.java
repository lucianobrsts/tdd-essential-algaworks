package com.algaworks;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.desconto.CalculadoraDescontoPrimeiraFaiixa;
import com.algaworks.desconto.CalculadoraDescontoSegundaFaixa;
import com.algaworks.desconto.CalculadoraDescontoTerceiraFaixa;
import com.algaworks.desconto.CalculadoraFaixaDesconto;
import com.algaworks.desconto.SemDesconto;

public class PedidoVendaTest {

	private Pedido pedido;

	@Before
	public void setup() {
		CalculadoraFaixaDesconto calculadoraFaixaDesconto = new CalculadoraDescontoTerceiraFaixa(
				new CalculadoraDescontoSegundaFaixa(new CalculadoraDescontoPrimeiraFaiixa(new SemDesconto(null))));

		pedido = new Pedido(calculadoraFaixaDesconto);
	}

	private void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = pedido.resumo();
		assertEquals(valorTotal, resumoPedido.getValorTatal(), 0.0001);
		assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
	}

	@Test
	public void devePermitirAdicionarUmItemNoPedido() throws Exception {
		pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
	}

	@Test
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}

	@Test
	public void deveCalcularResumoParaUmItemSemDesconto() throws Exception {
		pedido.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));

		ResumoPedido resumoPedido = pedido.resumo();

		assertEquals(25.0, resumoPedido.getValorTatal(), 0.0001);
		assertEquals(0.0, resumoPedido.getDesconto(), 0.0001);

	}

	@Test
	public void deveCalcularResumoParaDoisitensSemDesconto() throws Exception {
		pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 3));
		pedido.adicionarItem(new ItemPedido("Pasta dental", 7.0, 3));

		assertResumoPedido(30, 0.0);
	}

	@Test
	public void deveAplicarDescontoNa1aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Creme", 20.0, 20));

		assertResumoPedido(400, 16.0);
	}

	@Test
	public void deveAplicarDescontoNa2aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Shampo", 15.0, 30));
		pedido.adicionarItem(new ItemPedido("�leo", 15.0, 30));

		assertResumoPedido(900.0, 54.0);
	}

	@Test
	public void deveAplicarDescontoNa3aFaixa() throws Exception {
		pedido.adicionarItem(new ItemPedido("Creme", 15.0, 30));
		pedido.adicionarItem(new ItemPedido("�leo", 15.0, 30));
		pedido.adicionarItem(new ItemPedido("Shampoo", 10.0, 30));

		assertResumoPedido(1200, 96.0);
	}
}

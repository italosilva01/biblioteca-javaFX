package br.imd.modelo;

import java.time.LocalDate;

public class Obrar {

	private String titulo;
	private String categoria;
	private LocalDate lancamento;
	private Escritor escritor;
	private int qtdExemplares;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public LocalDate getLancamento() {
		return lancamento;
	}
	public void setLancamento(LocalDate lancamento) {
		this.lancamento = lancamento;
	}
	public Escritor getEscritor() {
		return escritor;
	}
	public void setEscritor(Escritor escritor) {
		this.escritor = escritor;
	}
	public int getQtdExemplares() {
		return qtdExemplares;
	}
	public void setQtdExemplares(int qtdExemplares) {
		this.qtdExemplares = qtdExemplares;
	}
	
	
	
}

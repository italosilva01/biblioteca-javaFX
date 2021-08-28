package br.ufrn.imd.modelo;

import java.time.LocalDate;

public class Livro {

  private int id;
  private String titulo;
  private Categoria categoria;
  private LocalDate lancamento;
  private Autor autor;

  //

  public Livro() {
  }

  public Livro(int id, String titulo, Categoria categoria, LocalDate lancamento, Autor autor) {
    this.id = id;
    this.titulo = titulo;
    this.categoria = categoria;
    this.lancamento = lancamento;
    this.autor = autor;
  }

  @Override
  public String toString() {
    return this.getTitulo();
  }

  //

  public int getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public LocalDate getLancamento() {
    return lancamento;
  }

  public Autor getAutor() {
    return autor;
  }

  //

  public void setId(int id) {
    this.id = id;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public void setLancamento(LocalDate lancamento) {
    this.lancamento = lancamento;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }

}

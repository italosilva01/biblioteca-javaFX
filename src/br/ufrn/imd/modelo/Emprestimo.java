package br.ufrn.imd.modelo;

import java.time.LocalDate;

public class Emprestimo {

  private int id;
  private Usuario usuario;
  private Livro livro;
  private LocalDate emprestimo;
  private LocalDate devolucao;

  //

  public Emprestimo() {
  }

  public Emprestimo(int id, Usuario usuario, Livro livro, LocalDate emprestimo, LocalDate devolucao) {
    this.id = id;
    this.usuario = usuario;
    this.livro = livro;
    this.emprestimo = emprestimo;
    this.devolucao = devolucao;
  }

  //

  public int getId() {
    return id;
  }

  public LocalDate getDevolucao() {
    return devolucao;
  }

  public LocalDate getEmprestimo() {
    return emprestimo;
  }

  public Livro getLivro() {
    return livro;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  //

  public void setId(int id) {
    this.id = id;
  }

  public void setDevolucao(LocalDate devolucao) {
    this.devolucao = devolucao;
  }

  public void setEmprestimo(LocalDate emprestimo) {
    this.emprestimo = emprestimo;
  }

  public void setLivro(Livro livro) {
    this.livro = livro;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}

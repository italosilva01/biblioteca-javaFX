package br.ufrn.imd.modelo;

import java.util.ArrayList;

public class Autor extends Pessoa {

  private ArrayList<Livro> livros;

  //

  public Autor() {
  }

  public Autor(int id, String nome, ArrayList<Livro> livros) {
    super(id, nome);
    this.livros = livros;
  }

  @Override
  public String toString() {
    return this.getNome();
  }

  //

  public ArrayList<Livro> getLivros() {
    return livros;
  }

  //

  public void setLivros(ArrayList<Livro> livros) {
    this.livros = livros;
  }

  //

  public void adicionarLivro(Livro livro) {
    livros.add(livro);
  }

}

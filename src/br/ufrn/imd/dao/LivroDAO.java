package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Autor;
import br.ufrn.imd.modelo.Livro;

public class LivroDAO {

  private ArrayList<Livro> livros;
  private static LivroDAO dataBase;

  public LivroDAO() {
    livros = new ArrayList<Livro>();
  }

  public static LivroDAO getInstance() {
    if (dataBase == null) {
      dataBase = new LivroDAO();
    }
    return dataBase;
  }

  public int getSize() {
    return livros.size();
  }

  public int generateId() {
    int id = livros.size();
    return id + 1;
  }

  public void inserir(Livro f) {
    livros.add(f);
    System.out.println(this.getClass().getName() + " inserido com sucesso!");
  }

  public ArrayList<Livro> listar() {
    return livros;
  }

  public ArrayList<Livro> pesquisar(String termo) {
    ArrayList<Livro> listaFiltrada = new ArrayList<Livro>();

    for (Livro autor : livros) {
      if (autor.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
        listaFiltrada.add(autor);
      }
    }

    return listaFiltrada;
  }

  public ArrayList<Livro> pesquisar(Autor termo) {
    ArrayList<Livro> listaFiltrada = new ArrayList<Livro>();

    for (Livro livroI : livros) {
      if (livroI.getAutor().getId() == termo.getId()) {
        listaFiltrada.add(livroI);
      }
    }

    return listaFiltrada;
  }

  public void remover(Livro remLivro) {
    ArrayList<Livro> listaFiltrada = new ArrayList<Livro>();

    for (Livro autor : livros) {
      if (remLivro != autor) {
        listaFiltrada.add(autor);
      }
    }

    this.livros = listaFiltrada;
  }
}

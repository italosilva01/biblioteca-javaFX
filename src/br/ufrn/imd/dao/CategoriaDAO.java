package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Categoria;

public class CategoriaDAO {

  private ArrayList<Categoria> livros;
  private static CategoriaDAO dataBase;

  public CategoriaDAO() {
    livros = new ArrayList<Categoria>();
    livros.add(new Categoria(1, "Romance"));
    livros.add(new Categoria(2, "Drama"));
    livros.add(new Categoria(3, "Terror"));
    livros.add(new Categoria(4, "Comédia"));
  }

  public static CategoriaDAO getInstance() {
    if (dataBase == null) {
      dataBase = new CategoriaDAO();
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

  public void inserir(Categoria f) {
    livros.add(f);
    System.out.println(this.getClass().getName() + " inserido com sucesso!");
  }

  public ArrayList<Categoria> listar() {
    return livros;
  }

  public ArrayList<Categoria> pesquisar(String termo) {
    ArrayList<Categoria> listaFiltrada = new ArrayList<Categoria>();

    for (Categoria autor : livros) {
      if (autor.getNome().toLowerCase().contains(termo.toLowerCase())) {
        listaFiltrada.add(autor);
      }
    }

    return listaFiltrada;
  }

  public void remover(Categoria remCategoria) {
    ArrayList<Categoria> listaFiltrada = new ArrayList<Categoria>();

    for (Categoria autor : livros) {
      if (remCategoria != autor) {
        listaFiltrada.add(autor);
      }
    }

    this.livros = listaFiltrada;
  }
}

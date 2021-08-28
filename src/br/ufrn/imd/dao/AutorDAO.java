package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Autor;

public class AutorDAO {

  private ArrayList<Autor> autores;
  private static AutorDAO dataBase;

  public AutorDAO() {
    autores = new ArrayList<Autor>();
  }

  public static AutorDAO getInstance() {
    if (dataBase == null) {
      dataBase = new AutorDAO();
    }
    return dataBase;
  }

  public int getSize() {
    return autores.size();
  }

  public int generateId() {
    int id = autores.size();
    return id + 1;
  }

  public void inserir(Autor f) {
    autores.add(f);
    System.out.println(this.getClass().getName() + " inserido com sucesso!");
  }

  public ArrayList<Autor> listar() {
    return autores;
  }

  public ArrayList<Autor> pesquisar(String termo) {
    ArrayList<Autor> listaFiltrada = new ArrayList<Autor>();

    for (Autor autor : autores) {
      if (autor.getNome().toLowerCase().contains(termo.toLowerCase())) {
        listaFiltrada.add(autor);
      }
    }

    return listaFiltrada;
  }

  public void remover(Autor remAutor) {
    ArrayList<Autor> listaFiltrada = new ArrayList<Autor>();

    for (Autor autor : autores) {
      if (remAutor != autor) {
        listaFiltrada.add(autor);
      }
    }

    this.autores = listaFiltrada;
  }
}

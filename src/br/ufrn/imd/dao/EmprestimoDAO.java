package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Emprestimo;
import br.ufrn.imd.modelo.Livro;
import br.ufrn.imd.modelo.Usuario;

public class EmprestimoDAO {

  private ArrayList<Emprestimo> emprestimos;
  private static EmprestimoDAO dataBase;

  public EmprestimoDAO() {
    emprestimos = new ArrayList<Emprestimo>();
  }

  public static EmprestimoDAO getInstance() {
    if (dataBase == null) {
      dataBase = new EmprestimoDAO();
    }
    return dataBase;
  }

  public int getSize() {
    return emprestimos.size();
  }

  public int generateId() {
    int id = emprestimos.size();
    return id + 1;
  }

  public void inserir(Emprestimo item) {
    emprestimos.add(item);
    System.out.println(this.getClass().getName() + " inserido com sucesso!");
  }

  public ArrayList<Emprestimo> listar() {
    return emprestimos;
  }

  public ArrayList<Emprestimo> pesquisar(Usuario termo) {
    ArrayList<Emprestimo> listaFiltrada = new ArrayList<Emprestimo>();

    for (Emprestimo emprestimo : emprestimos) {
      if (emprestimo.getUsuario().getId() == termo.getId()) {
        listaFiltrada.add(emprestimo);
      }
    }

    return listaFiltrada;
  }

  public ArrayList<Emprestimo> pesquisar(String termo) {
    ArrayList<Emprestimo> listaFiltrada = new ArrayList<Emprestimo>();

    for (Emprestimo emprestimo : emprestimos) {
      if (emprestimo.getLivro().getTitulo().toLowerCase().contains(termo.toLowerCase())) {
        listaFiltrada.add(emprestimo);
      } else if (emprestimo.getUsuario().getNome().toLowerCase().contains(termo.toLowerCase())) {
        listaFiltrada.add(emprestimo);
      }
    }

    return listaFiltrada;
  }

  public ArrayList<Emprestimo> pesquisar(Livro termo) {
    ArrayList<Emprestimo> listaFiltrada = new ArrayList<Emprestimo>();

    for (Emprestimo emprestimo : emprestimos) {
      if (emprestimo.getLivro().getId() == termo.getId()) {
        listaFiltrada.add(emprestimo);
      }
    }

    return listaFiltrada;
  }

  public void remover(Emprestimo remEmprestimo) {
    ArrayList<Emprestimo> listaFiltrada = new ArrayList<Emprestimo>();

    for (Emprestimo usuario : emprestimos) {
      if (remEmprestimo != usuario) {
        listaFiltrada.add(usuario);
      }
    }

    this.emprestimos = listaFiltrada;
  }

}

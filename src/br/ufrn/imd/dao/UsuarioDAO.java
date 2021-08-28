package br.ufrn.imd.dao;

import java.util.ArrayList;

import br.ufrn.imd.modelo.Usuario;

public class UsuarioDAO {

  private ArrayList<Usuario> usuarios;
  private static UsuarioDAO dataBase;

  public UsuarioDAO() {
    usuarios = new ArrayList<Usuario>();
  }

  public static UsuarioDAO getInstance() {
    if (dataBase == null) {
      dataBase = new UsuarioDAO();
    }
    return dataBase;
  }

  public int getSize() {
    return usuarios.size();
  }

  public int generateId() {
    int id = usuarios.size();
    return id + 1;
  }

  public void inserir(Usuario item) {
    usuarios.add(item);
    System.out.println(this.getClass().getName() + " inserido com sucesso!");
  }

  public ArrayList<Usuario> listar() {
    return usuarios;
  }

  public ArrayList<Usuario> pesquisar(String termo) {
    ArrayList<Usuario> listaFiltrada = new ArrayList<Usuario>();

    for (Usuario usuario : usuarios) {
      if (usuario.getNome().toLowerCase().contains(termo.toLowerCase())) {
        listaFiltrada.add(usuario);
      }
    }

    return listaFiltrada;
  }

  public void remover(Usuario remUsuario) {
    ArrayList<Usuario> listaFiltrada = new ArrayList<Usuario>();

    for (Usuario usuario : usuarios) {
      if (remUsuario != usuario) {
        listaFiltrada.add(usuario);
      }
    }

    this.usuarios = listaFiltrada;
  }

}

package br.ufrn.imd.modelo;

public class Categoria {

  private int id;
  private String nome;

  //

  public Categoria(int id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  @Override
  public String toString() {
    return this.getNome();
  }

  //

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  //

  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}

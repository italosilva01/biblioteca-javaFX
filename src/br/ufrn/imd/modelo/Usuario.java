package br.ufrn.imd.modelo;

import java.util.ArrayList;

public class Usuario extends Pessoa {
  private String email;
  private String telefone;

  private String senha;
  private ArrayList<Emprestimo> emprestimos;
  //

  public Usuario() {
  }

  public Usuario(int id, String nome, String email, String telefone, String senha) {
    super(id, nome);
    this.email = email;
    this.telefone = telefone;
    this.senha = senha;
  }

  //

  public String getEmail() {
    return email;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getSenha() {
    return senha;
  }

  public ArrayList<Emprestimo> getEmprestimos() {
    return emprestimos;
  }

  //

  public void setEmail(String email) {
    this.email = email;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
    this.emprestimos = emprestimos;
  }

  //

  public void addEmprestimos(Emprestimo emprestimo) {
    this.emprestimos.add(emprestimo);
  }
}

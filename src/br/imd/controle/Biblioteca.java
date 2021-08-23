package br.imd.controle;

import java.util.ArrayList;

import br.imd.modelo.Cliente;
import br.imd.modelo.Funcionario;
import br.imd.modelo.Obrar;

public class Biblioteca {
 private ArrayList<Cliente> clientes;
 private ArrayList<Funcionario> funcionarios;
 private ArrayList<Obrar> acervo;
 
 
 public void adicionarCliente (Cliente novoCliente) {
	 
	 clientes.add(novoCliente);
	 
	 // adicionar lógica para salvar no DAO
 }
 
 public boolean removerCliente (String nome) {
	 
	 for (Cliente cliente:clientes) {
		 if(cliente.getNome().equals(nome)) {
			 clientes.remove(cliente);
			 
			 // adicionar logica DAO
			 
			 System.out.println("Cliente removido");
			 return true ;
		 }
	 }
	 System.out.println("Cliente não encontrado");

	 return false;
	 
 }
 
public void adicionarFuncionario (Funcionario novoFuncionario) {
	 
	 funcionarios.add(novoFuncionario);
	 
	 // adicionar lógica para salvar no DAO
 }

public boolean removerFuncionario (String nome) {
	 
	 for (Funcionario funcionario:funcionarios) {
		 if(funcionario.getNome().equals(nome)) {
			 funcionarios.remove(funcionario);
			 
			 // adicionar logica DAO
			 
			 System.out.println("Funcionario removido");
			 return true ;
		 }
	 }
	 System.out.println("Funcionario não encontrado");

	 return false;
	 
}

public void adicionarObrar (Obrar novoObrar) {
	 
	 acervo.add(novoObrar);
	 
	 // adicionar lógica para salvar no DAO
}

 
 
}

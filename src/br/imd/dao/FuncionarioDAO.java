package br.imd.dao;

import java.util.ArrayList;

import br.imd.modelo.Funcionario;

public class FuncionarioDAO {
 
	private ArrayList<Funcionario> funcionarios;
	private static FuncionarioDAO bdFuncionario;
	
	public static FuncionarioDAO getInstance() {
		
		if(bdFuncionario==null) {
			bdFuncionario = new FuncionarioDAO();
		}
		
		return bdFuncionario;
	}
	
	public void inserirFuncionario(Funcionario f) {
		funcionarios.add(f);
		System.out.println("Funcionario Inserido com sucesso !!");
	}
}

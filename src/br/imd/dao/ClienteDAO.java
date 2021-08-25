package br.imd.dao;

import java.util.ArrayList;

import br.imd.modelo.Cliente;

public class ClienteDAO {

	private ArrayList<Cliente> clientes;
	private static ClienteDAO bdCliente;
	
	public ClienteDAO() {
		// TODO Auto-generated constructor stub
		clientes = new ArrayList<Cliente>();
	}
	
	public static ClienteDAO getInstace() {
		if(bdCliente==null) {
			bdCliente = new ClienteDAO();
		}
		
		return bdCliente;
	}
	
	public void inserirCliente(Cliente f) {
		clientes.add(f);
		System.out.println("Cliente Inserido com sucesso!!");

	}
}

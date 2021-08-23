package br.imd.modelo;

import java.util.ArrayList;

public class Escritor extends Pessoa {
	
	private ArrayList<Obrar> obras;

	public ArrayList<Obrar> getObras() {
		return obras;
	}

	public void setObras(ArrayList<Obrar> obras) {
		this.obras = obras;
	}
	
	public void adicionarObrar(Obrar novaObrar) {
		obras.add(novaObrar);
		
	}
	
	
	
}

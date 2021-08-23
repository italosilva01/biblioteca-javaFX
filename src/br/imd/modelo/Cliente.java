package br.imd.modelo;

import java.util.ArrayList;

public class Cliente extends Pessoa{

	private ArrayList<Obrar> obrasAlugadas;

	public ArrayList<Obrar> getObrasAlugadas() {
		return obrasAlugadas;
	}

	public void setObrasAlugadas(ArrayList<Obrar> obrasAlugadas) {
		this.obrasAlugadas = obrasAlugadas;
	}
	
	public void alugarObrar (Obrar obrar) {
		obrasAlugadas.add(obrar);
	}
	
	public void devolverObrar (String nomeObrar) {
		// codar
	}
}

package br.imd.dao;

import java.util.ArrayList;

import br.imd.modelo.Escritor;

public class EscritorDAO {

	private ArrayList<Escritor> escritores;
	private static EscritorDAO bdEscritores;
	
	public EscritorDAO() {
		escritores = new ArrayList<Escritor>();
	}
	
	public static EscritorDAO getInstance() {
		if(bdEscritores==null) {
			bdEscritores = new EscritorDAO();
		}
		
		return bdEscritores;
	}
	
	public void inserirEscritor(Escritor f) {
		escritores.add(f);
		System.out.println("Escritor inserido com sucesso!!");
	}
}

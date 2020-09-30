package com.Entity;





public class CaC {
	public String Nome;
	public String Arma;
	public int CR;
	public float valor;
	
	

	public CaC() {
		super();
	}


	public CaC(String nome, String arma, int cR, float valor) {
		super();
		this.Nome = nome;
		this.Arma = arma;
		this.CR = cR;
		this.valor = valor;
	}




	// METODOS

	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}


	public String getArma() {
		return Arma;
	}


	public void setArma(String arma) {
		Arma = arma;
	}


	public int getCR() {
		return CR;
	}


	public void setCR(int cR) {
		CR = cR;
	}


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "CaC [NOME=" + Nome + ", Arma=" + Arma + ", CR=" + CR + ", valor=" + valor
				+ "]";
	}

}


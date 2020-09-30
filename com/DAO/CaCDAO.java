package com.DAO;


import java.util.List;

import com.Entity.CaC;



public class CaCDAO {

	  public CaC inserirCac(CaC cac) {
	        CaC cacInserir  = new CaC();
	        cacInserir.setNome(cac.getNome());
	        cacInserir.setArma(cac.getArma());
	        cacInserir.setCR(cac.getCR());
	        return cacInserir;
	    }


	    public CaC findByModelo(String Nome, List<CaC> listaCac) {
	        for (int i = 0; i < listaCac.size(); i++) {
	            if(listaCac.get(i).getNome().equals(Nome)) {
	                return listaCac.get(i);
	            }
	        }
	        return null;
	    }
	    public void Alterar(CaC Arma, String Nome, List<CaC> listaCac) {
	        for (int i = 0; i < listaCac.size(); i++) {
	            if(listaCac.get(i).getNome().equals(Nome)) {
	                listaCac.set(i, Arma);
	            }
	        }
	    }
	    public void Deletar(String Nome, List<CaC> listaCac) {
	        for (int i = 0; i < listaCac.size(); i++) {
	            if(listaCac.get(i).getNome().equals(Nome)) {
	                listaCac.remove(i);
	            }
	        }
	    }
	

}


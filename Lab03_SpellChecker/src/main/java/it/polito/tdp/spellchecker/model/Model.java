package it.polito.tdp.spellchecker.model;


import java.util.LinkedList;
import java.util.List;

public class Model {
	
	
	private List <String> listaP = new LinkedList<String>();
	private List <String> listaPSbagliate = new LinkedList<String>();
	int cont=0;
	
    public void paroleErrate (String test, String linguaD) {
    	
    	
    	Dictionary listaD = new Dictionary();
    	listaD.dizionario(linguaD);
		
		test = test.replaceAll("[.,\\/#!?$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		String parole = test.toLowerCase();
		
		for(String s : parole.split(" "))
		listaP.add(s);
		
		for(String s1 : listaP) 
			if(!listaD.contains(s1) && !listaPSbagliate.contains(s1)) {
				cont++;
				listaPSbagliate.add(s1);
			}

	}
    


	public List<String> getListaP() {
		return listaP;
	}







	public int getCont() {
		return cont;
	}







	public void setCont(int cont) {
		this.cont = cont;
	}



	public String ListaParoleSbagliate() {
		
		String s= "" ;
			
			for(String ss : listaPSbagliate)
				s+=ss+" \n";
		
		return s;
	}



	public List<String> getListaPSbagliate() {
		return listaPSbagliate;
	}
	
	
	
	

	

}

package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Model {
	
	private List <String> listaD = new LinkedList<String>();
	private List <String> listaP = new LinkedList<String>();
	int cont=0;
	
	
	public void dizionario (String lingua) {
		
		String s;
		
		if(lingua.compareTo("English")==0)
			s="src/main/resources/English.txt";
		else
			s="src/main/resources/Italian.txt";
		
		try {
			FileReader fr = new FileReader(s);
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
			listaD.add(word);
			}
			br.close();
			fr.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}

		
	}
	
	
	public int paroleErrate (String test) {
		
	
		
		test.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		String parole = test.toLowerCase();
		
		for(String s : parole.split(" "))
		listaP.add(s);
		
		for(String s1 : listaP) 
			if(!listaD.contains(s1))
				cont++;

		
		return cont;
		
		
	}


	public List<String> getListaD() {
		return listaD;
	}


	public List<String> getListaP() {
		return listaP;
	}

	

}

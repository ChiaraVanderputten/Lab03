package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	   private List <String> listaD ;
	
	   
	
       public Dictionary() {
    	   
		this.listaD = new LinkedList<String>();
	}

	public void dizionario (String lingua) {   //creo un metodo che mi aggiorna il dizionario in base alla lingua che gli viene passata
		
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
       
       public List<String> getListaD() {
   		return listaD;
   	}

	public boolean contains(String s1) {
		
		if(listaD.contains(s1))
		return true;
		else 
			return false;
	}

}

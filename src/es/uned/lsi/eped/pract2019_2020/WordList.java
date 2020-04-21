package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class WordList {
	private ListIF<WordListN> wordList;
	
	public WordList() {
		this.wordList = new List<WordListN>();
	}
	
	public void add(String word) {

		if(wordList.isEmpty()){ // Si lita vacia, crear nuevo e insertar nuevo wn y palabra al wn.
			WordListN wln = new WordListN(word.length());
			wln.add(word);
			wordList.insert(1,wln);
		}else{ // Si no vacio mirar si existe wn de tamano x, si existe añadir palabra, sino crear y añadir.

			int counter= 1;
			WordListN wln;

			while(counter <= wordList.size()){ // Recorremos lista hasta encontrar wln correspondiente, sino existe crearlo.
				wln = wordList.get(counter);

				if(wln.getWordSize() == word.length()){ // Si mismo tamaño, añadir palabra.
					wln.add(word);
					counter = wordList.size()+1; // Salimos
				}else if(wln.getWordSize() < word.length() && counter==wordList.size()){ // Si mas grande y no quedan mas, crear nuevo y añadir.
					wln = new WordListN(word.length());
					wln.add(word);
					wordList.insert(counter+1, wln); // Añadimos al final
					counter = wordList.size()+1; // Salimos
				}else if(wln.getWordSize() > word.length()){ // Si mas pequeño, crear e insertar en ese pos y añadir palabra.
					wln = new WordListN(word.length());
					wln.add(word);
					wordList.insert(counter, wln); // Añadimos en la posicion donde hemos econtrado el siguiente mas grande al nuestro.
					counter = wordList.size()+1; // Salimos
				}
				counter++;
			}

		}

	}
	
	public String toString() {
		StringBuilder salida = new StringBuilder();
		for ( int pos = 1 ; pos <= this.wordList.size() ; pos++ ) {
			salida.append(this.wordList.get(pos).toString());
		}
		return salida.toString();
	}
}

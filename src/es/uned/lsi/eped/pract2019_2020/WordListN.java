package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.Sequence;

public class WordListN {
	/* Atributos de la clase con la estructura adecuada */
	private int size;

	private List<String> li;
	/* Atributos de la clase con la estructura adecuada */

	public WordListN(int size) {
		this.size = size;

	}
	
	public void add(String word) { //Añade palabra nueva ordenada alfabeticamente.
		int counter = 1;
		if(li==null){
			li = new List<String>();
			li.set(1,word);
		}else{
			while( counter <= li.size() ){ // Recorrer toda la lista e insertar O(N^2). QUITAR SI VIENEN ORDENADAS. ASIER
				if(word.compareTo(li.get(counter)) < 0){
					// Insertar antes de primer elemento mas grande.
					li.insert(counter,word);
					// Finalizar bucle.
					counter = li.size();
				}else if( (word.compareTo(li.get(counter)) > 0) && (counter==li.size())){
					//Si estamos en el ultimo y este es mas pequeño que word, insertar al final.
					li.insert(li.size()+1,word);
				}
				counter++;
			}
		}
	}
	
	public int getWordSize() {
		return size;
	}
	
	public String toString() {
		StringBuilder salida = new StringBuilder();
		int numPalabras = li.size();/* Longitud de la secuencia de palabras */
		salida.append("-Palabras de ");
		salida.append(this.getWordSize());
		salida.append(" letra");
		if ( this.getWordSize() > 1 ) { salida.append('s'); }
		salida.append(": ");
		for (int pos = 1 ; pos <= numPalabras ; pos++) {
			/* Estas líneas dependen de la estructura escogida */
			String word = li.get(pos);/* Obtener la siguiente palabra */
			/* Avanzar a la siguiente sin destruir la estructura */
			//...recorremos la lista entera con get(pos) O(N^2)
			/* Estas líneas dependen de la estructura escogida */
			salida.append(word);
			if ( pos < numPalabras ) {
				salida.append(", ");
			}
		}
		salida.append('\n');
		return salida.toString();
	}
}

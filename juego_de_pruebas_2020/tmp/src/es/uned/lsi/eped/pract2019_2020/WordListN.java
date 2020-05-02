package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.Queue;

public class WordListN {
	/* Atributos de la clase con la estructura adecuada */
	private int size;

	private Queue<String> cola;
	/* Atributos de la clase con la estructura adecuada */

	public WordListN(int size) {
		this.size = size;
		cola = new Queue<>();
	}
	
	public void add(String word) { //Añade palabra nueva ordenada alfabeticamente.
		cola.enqueue(word);
	}
	
	public int getWordSize() {
		return size;
	}
	
	public String toString() {
		StringBuilder salida = new StringBuilder();
		int numPalabras = cola.size();/* Longitud de la secuencia de palabras */
		salida.append("-Palabras de ");
		salida.append(this.getWordSize());
		salida.append(" letra");
		if ( this.getWordSize() > 1 ) { salida.append('s'); }
		salida.append(": ");
		for (int pos = 1 ; pos <= numPalabras ; pos++) {
			/* Estas líneas dependen de la estructura escogida */
			String word = cola.getFirst();/* Obtener la siguiente palabra */
			/* Avanzar a la siguiente sin destruir la estructura */
			cola.dequeue();
			cola.enqueue(word);
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

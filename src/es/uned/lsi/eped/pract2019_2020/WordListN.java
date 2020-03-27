package es.uned.lsi.eped.pract2019_2020;

public class WordListN {
	/* Atributos de la clase con la estructura adecuada */
	private int size;

	private InnerList li;
	/* Atributos de la clase con la estructura adecuada */

	public WordListN(int size) {
		this.size = size;
	}
	
	public void add(String word) {
		boolean goForth = true;
		InnerList current;
		if(li==null){
			li = new InnerList(word);
			current = li;
		}else{
			while(goForth){
				switch (li.getMyWord().compareToIgnoreCase(word)){
					case -1:
						break;

					case 0:
						break;

					case 1:
						break;
				}

			}
		}
	}
	
	public int getWordSize() {
		return size;
	}
	
	public String toString() {
		StringBuilder salida = new StringBuilder();
		int numPalabras = /* Longitud de la secuencia de palabras */
		salida.append("-Palabras de ");
		salida.append(this.getWordSize());
		salida.append(" letra");
		if ( this.getWordSize() > 1 ) { salida.append('s'); }
		salida.append(": ");
		for (int pos = 1 ; pos <= numPalabras ; pos++) {
			/* Estas líneas dependen de la estructura escogida */
			String word = /* Obtener la siguiente palabra */
			/* Avanzar a la siguiente sin destruir la estructura */
			...
			/* Estas líneas dependen de la estructura escogida */
			salida.append(word);
			if ( pos < numPalabras ) {
				salida.append(", ");
			}
		}
		salida.append('\n');
		return salida.toString();
	}

	private class InnerList {

		String myWord;

		InnerList first;
		InnerList prev;
		InnerList next;

		InnerList(String myWord){
			this.prev = null;
			this.next = null;
			this.first = this;
			this.myWord = myWord;
		}

		InnerList(InnerList prev, InnerList next, String myWord){
			this.prev = prev;
			this.next = next;
			this.myWord = myWord;
		}

		void setPrev(InnerList prev){
			this.prev = prev;
		}

		void setNext(InnerList next){
			this.next = next;
		}

		void setFirst(InnerList first){
			this.first = first;
		}

		InnerList getFirst(){
			return this.first;
		}

		InnerList getPrev(){
			return this.prev;
		}

		InnerList getNext(){
			return this.next;
		}

		String getMyWord(){
			return myWord;
		}
	}
}

package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.GTree;
import es.uned.lsi.eped.DataStructures.GTreeIF;
import es.uned.lsi.eped.DataStructures.Queue;

public class Dictionary {

	// Restaurar //private GTree<Node> dict; /* El diccionario es un árbol general de nodos */
	public GTree<Node> dict; /* El diccionario es un árbol general de nodos */

	/* Constructor de la clase */
	public Dictionary() {
		dict = new GTree<Node>();
		dict.setRoot(new RootNode());
	}
	
	/* Método de inserción de una nueva palabra en el diccionario */
	public void insert(String word) {
		/* Insertamos la palabra a partir del nodo raíz del árbol */
		insertInTree(word,this.dict);
	}
	
	/* Método privado llamado por el anterior */
	private void insertInTree(String word, GTreeIF<Node> node) {

		String palabra = word.trim().toLowerCase();

		if(!palabra.matches("^[a-z]*")) return;

		Queue<Character> cola = new Queue();

		for(int i=0; i<word.length(); i++){ // O(N)
			cola.enqueue(word.charAt(i)); // charAt(i)-->O(1)
		}

		recursiveInsert(cola,node);

	}

	/* Método público de búsqueda de todas las palabras a partir de una secuencia */
	public WordList search(String sequence) {
		WordList salida = new WordList();           /* Variable donde construiremos la salida */
		searchInTree(sequence,"",this.dict,salida); /* Construimos la salida recursivamente */
		return salida;
	}
	
	/* Método privado llamado por el anterior */
	private void searchInTree(String sequence, String word,
							  GTreeIF<Node> node, WordList salida) {

		LetterNode ln;
		GTreeIF<Node> gt;
		boolean encontrado = false;
		String auxSeq = sequence;
		String auxWord = word;

		for (int i = 1; i <= node.getNumChildren(); i++) { // O(N^2)
			gt = node.getChild(i);
			sequence = auxSeq;
			word = auxWord;

			if (gt.getRoot().getNodeType() == Node.NodeType.LETTERNODE) {
				ln = (LetterNode) node.getChild(i).getRoot();

				for (int j = 0; j < sequence.length(); j++) { // O(N) --> O(N) + O(N)

					if (sequence.charAt(j) == ln.getCaracter()) { // O(1)
						word += sequence.charAt(j);
						sequence = eliminarLetra(sequence, sequence.charAt(j));// O(N) se ejecuta cuando se termina el bucle.
						encontrado = true;
						j = sequence.length();
					}
				}
				if(encontrado) {
					searchInTree(sequence, word, gt, salida);
				}

			} else if (gt.getRoot().getNodeType() == Node.NodeType.WORDNODE) {
				salida.add(word);
			}
		}
	}
	
	/* Método público de búsqueda de todas las palabras de tamaño size a partir de una secuencia */
	public WordListN search(String sequence, int size) {
		WordListN salida = new WordListN(size);           /* Variable donde construiremos la salida */
		searchInTreeN(sequence,"",this.dict,salida,size); /* Construimos la salida recursivamente */
		return salida;
	}
	
	/* Método privado llamado por el anterior */
	private void searchInTreeN(String sequence, String word,
							   GTreeIF<Node> node, WordListN salida,
							   int size) {

		LetterNode ln;
		GTreeIF<Node> gt;
		boolean encontrado = false;
		String auxSeq = sequence;
		String auxWord = word;

		for (int i = 1; i <= node.getNumChildren(); i++) { // O(N^2)
			gt = node.getChild(i);
			sequence = auxSeq;
			word = auxWord;

			if (gt.getRoot().getNodeType() == Node.NodeType.LETTERNODE  && size > 0) {

				ln = (LetterNode) node.getChild(i).getRoot();

				for (int j = 0; j < sequence.length(); j++) { // O(N) --> O(N) + O(N)
					if (sequence.charAt(j) == ln.getCaracter()) { // O(1)
						word += sequence.charAt(j);
						sequence = eliminarLetra(sequence, sequence.charAt(j));// O(N) se ejecuta cuando se termina el bucle.
						encontrado = true;
						j = sequence.length(); // Salimos.
					}
				}
				if(encontrado) {
					searchInTreeN(sequence, word, gt, salida,size-1);
				}

			} else if (gt.getRoot().getNodeType() == Node.NodeType.WORDNODE && size == 0) {
				salida.add(word);
				i = node.getNumChildren(); // Salimos.
			}
		}
	}

	private String eliminarLetra(String sequence, char letra){
		boolean quitado = false;
		String retorno = "";
		for(int i=0; i<sequence.length(); i++){
			if(sequence.charAt(i) == letra && !quitado){
				quitado=true;
			}
			else {
				retorno += sequence.charAt(i);
			}
		}
		return retorno;
	}

	private void recursiveInsert(Queue<Character> cola, GTreeIF<Node> node){
		GTreeIF<Node> gt = new GTree<Node>();
		LetterNode nd;
		int pos=0;

		if(node.getRoot().getNodeType() != Node.NodeType.WORDNODE){

			for(int i=1; cola.size()>0 && i<=node.getNumChildren(); i++){
				gt = node.getChild(i);

				if(gt.getRoot().getNodeType() != Node.NodeType.WORDNODE) {

					nd = (LetterNode) node.getChild(i).getRoot();

					if (nd.getCaracter() < cola.getFirst()) {
						pos = i + 1;

					} else if (nd.getCaracter() > cola.getFirst()) {
						pos = i;
						i = node.getNumChildren(); //salir

					} else if (nd.getCaracter() == cola.getFirst()) {
						pos = 0;
						i = node.getNumChildren(); //salir

					}

				}

			}

			if(pos != 0) {
				gt = new GTree<Node>();
				gt.setRoot(new LetterNode(cola.getFirst()));
				node.addChild(pos, gt);

				if(cola.size()>0)cola.dequeue();

				if(cola.size() == 0){
					WordNode wn = new WordNode();
					GTreeIF<Node> aux = new GTree<Node>();
					aux.setRoot(wn);
					gt.addChild(1,aux);
				}

			}else if(node.getRoot().getNodeType() != Node.NodeType.WORDNODE && node.getNumChildren()==0){

				gt = new GTree<Node>();
				gt.setRoot(new LetterNode(cola.getFirst()));
				node.addChild(1, gt);

				if(cola.size()>0)cola.dequeue();

				if(cola.size() == 0){
					WordNode wn = new WordNode();
					GTreeIF<Node> aux = new GTree<Node>();
					aux.setRoot(wn);
					gt.addChild(1,aux);
				}

			}else{

				if(cola.size()>0)cola.dequeue();

				if(cola.size() == 0 &&
						node.getNumChildren()!=0 &&
						node.getChild(1).getRoot().getNodeType() != Node.NodeType.WORDNODE){

					WordNode wn = new WordNode();
					GTreeIF<Node> aux = new GTree<Node>();
					aux.setRoot(wn);
					gt.addChild(1,aux);

				}

			}

			if(cola.size() > 0 )recursiveInsert(cola,gt);

		}

	}
	
}

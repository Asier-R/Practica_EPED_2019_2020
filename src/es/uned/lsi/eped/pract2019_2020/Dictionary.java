package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.GTree;
import es.uned.lsi.eped.DataStructures.GTreeIF;
import es.uned.lsi.eped.DataStructures.Queue;

import java.util.regex.Pattern;

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

		for(int i=0; i<word.length(); i++){
			cola.enqueue(word.charAt(i));
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




	}

	private void recursiveInsert(Queue<Character> laCola, GTreeIF<Node> node){
		Queue<Character> cola = laCola;

		if(cola.size() == 1){
			// Añadir fin de palabra (WordNode).
			// Añadir letra y terminar recursion cuando se le pase una palabra de logitud 1.
			GTree<Node> gt = new GTree<Node>();
			Node wn = new WordNode();
			gt.setRoot(wn); // Crear arbol fin de palabra.
			node.addChild(node.getNumChildren()+1, gt); // Añadir arbol fin de palabra a lista hijos.

		}else if(dict.getRoot().getNodeType() == Node.NodeType.ROOTNODE ||
				dict.getRoot().getNodeType() == Node.NodeType.LETTERNODE) {

			GTree<Node> gt = new GTree<Node>();
			LetterNode lt = new LetterNode(cola.getFirst()); // Meter primera letra de la cola.
			cola.dequeue(); // Sacar primera letra de la cola.
			gt.setRoot(lt); // Crear arbol con nodo letra.
			node.addChild(node.getNumChildren() + 1, gt); // Añadir arbol con nodo letra a lista hijos.

			recursiveInsert(cola, gt); // Repetir recursion.

		}
	}
	
}

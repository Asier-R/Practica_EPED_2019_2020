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
		char letraHijo;
		char letraActual = cola.getFirst();
		int posicion = 1;
		Node hijo;
		boolean presente = false;
		boolean insertar = false;
		GTreeIF<Node> gt = new GTree<Node>();
		System.out.println("Inicio con letra: "+letraActual);

		for(int i=1; i<=node.getChildren().size(); i++){ // Recorrer todos los hijos y mirar si esta la letra.
			hijo = node.getChild(i).getRoot();
			System.out.println("Bucle...tipo nodo hijo: "+hijo.getNodeType().toString());
			if(hijo.getNodeType() == Node.NodeType.LETTERNODE && ((LetterNode) hijo).getCaracter() == letraActual){
				letraHijo = (((LetterNode) hijo).getCaracter());
				System.out.println("LetraHijo: "+letraHijo+"  LetraActual: "+letraActual);
				if(letraHijo == letraActual){
					presente = true;
					posicion = i; // guardamos posicion del hijo que nos interesa.
					i = node.getChildren().size(); // salimos del bucle.

				}else if(letraHijo > letraActual){
					insertar = true;
					posicion = i-1; // guardamos posicion del hijo que nos interesa.
					i = node.getChildren().size();

				}

			}
		}

		if(presente){
			System.out.println("Letra SI presente!");
			gt = node.getChild(posicion); // si letra ya esta en diccionario se pasa ese nodo a funcion recursiva.
		}else if(insertar || (node.getRoot().getNodeType() != Node.NodeType.WORDNODE)){
			System.out.println("Letra NO presente!");
			gt.setRoot(new LetterNode(letraActual)); // si letra no esta en diccionario se crea nodo nuevo y se pasa a funcion recursiva.
			node.getChildren().insert(posicion,gt); // se inserta el nuevo nodo en la lista de hijos del nodo actual.
		}else if((node.getRoot().getNodeType() == Node.NodeType.ROOTNODE)) {
			System.out.println("PRIMERA LETRA INTRODUCIDA EN EL DICCIONARIO");
			gt.setRoot(new LetterNode(letraActual));
			node.getChildren().insert(1, gt);
			presente = true;

		}

		cola.dequeue(); // se elimina una letra de la cola (no da error en size 0 porque esta controlado internamente).

		if(!cola.isEmpty() && (node.getRoot().getNodeType() != Node.NodeType.WORDNODE)){//(presente || insertar)) {
			System.out.println("LLamamos a recursiva...para letra: "+cola.getFirst());
			recursiveInsert(cola, gt); // se repite funcion recursiva si cola no es vacia
		}else if(cola.isEmpty() && node.getChildren().size() == 0){ // si fin palabra y no hijos aun, insertar hijo WN.
			System.out.println("FIN de palabra WN");
			gt.setRoot(new WordNode());
			node.getChildren().insert(node.getChildren().size()+1,gt);
		}

	}
	
}

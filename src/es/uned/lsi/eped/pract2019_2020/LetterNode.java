package es.uned.lsi.eped.pract2019_2020;

public class LetterNode extends Node {

    private char caracter;

    private Node nodoHermano;
    private Node nodoHijo;

    public LetterNode(char caracter, Node nodoHermano, Node nodoHijo){
        this.caracter = caracter;
        this.nodoHermano = nodoHermano;
        this.nodoHijo = nodoHijo;
    }

    public char getCaracter(){
        return caracter;
    }

    public Node getNodoHermano(){
        return nodoHermano;
    }

    public Node getNodoHijo(){
        return nodoHijo;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.LETTERNODE;
    }
}

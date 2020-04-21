package es.uned.lsi.eped.pract2019_2020;

public class LetterNode extends Node {

    private char caracter;

    public LetterNode(char caracter){
        this.caracter = caracter;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.LETTERNODE;
    }
}

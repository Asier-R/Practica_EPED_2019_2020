package es.uned.lsi.eped.pract2019_2020;

public class RootNode extends Node {

    private Node nodoHijo;

    public RootNode(Node nodoHijo){
        this.nodoHijo = nodoHijo;
    }

    public Node getNodoHijo(){
        return nodoHijo;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.ROOTNODE;
    }
}

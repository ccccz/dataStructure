package main.java.graph;

import java.util.ArrayList;

public class GNode {

    int label=0;
    ArrayList<GNode> nextNode=new ArrayList<>();
    int visit=0;

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public ArrayList<GNode> getNextNode() {
        return nextNode;
    }

    public GNode(int label){
        this.label=label;
    }
}

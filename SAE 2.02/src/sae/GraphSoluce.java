package sae;

import java.util.LinkedList;
import java.util.List;


public class GraphSoluce{
	private LinkedList<Node> soluce;
	
	public GraphSoluce() {
		soluce = new LinkedList<Node>();
	}
	
	public void add(Node node) {
		soluce.addFirst(node);
	}
	
	
	public List<Node> getSoluce(){
		return soluce;
	}
}

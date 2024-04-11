package sae;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class SolverWithBFS implements Solver {
	private Queue<Node> file = new LinkedList<>();
	private Queue<Node> soluceNode = new LinkedList<>();
	private List<Node> marquer;
	private HashMap<Node, Node> cheminNodeInverse;
	private Node nodeA;
	private Node nodeB;
	private Node sommet;
	private int steps;
	
	
	public SolverWithBFS(Node nodeA, Node nodeB) {
		this.nodeA=nodeA;
		this.nodeB=nodeB;
		marquer.add(nodeA);
		file.offer(nodeA); 
		steps=0;
	}
	
	public void resolve() {
		while (!file.isEmpty()) {
			sommet = file.peek();
			for (Node voisin : sommet.neighboors()) {
				if (!marquer.contains(voisin)) {
					cheminNodeInverse.put(voisin,sommet);
					if(voisin.equals(nodeB)) {
						return;
					}
					marquer.add(voisin);
					file.offer(voisin);
				}
				
			}
		}
	}

	@Override
	public GraphSoluce getSoluce() {
	    Node noeud=nodeB;
	    while(noeud!=nodeA) {
	    	for (HashMap.Entry<Node, Node> entry : cheminNodeInverse.entrySet()) {
	    		 if (noeud.equals(entry.getValue())) {
			        	soluceNode.offer(entry.getKey());
			        } 
	    	}
	    }
		return null;
	}

	@Override
	public int getSteps() {
		return steps;
	}
}

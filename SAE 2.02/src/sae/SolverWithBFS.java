package sae;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class SolverWithBFS implements Solver {
	private Queue<Node> file = new LinkedList<>();
	private GraphSoluce soluce;
	private List<Node> marquer;
	private Map<Node, Node> cheminNodeInverse;
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
			for (Node voisin : sommet.neighbors()) {
				steps++;
				if (!marquer.contains(voisin)) {
					cheminNodeInverse.put(voisin,sommet);
					marquer.add(voisin);
					file.offer(voisin);
				}
			}
		}
		Node noeud = nodeB;
		while(noeud!=nodeA) {
	    	for (HashMap.Entry<Node, Node> couple : cheminNodeInverse.entrySet()) {
	    		steps++;
	    		if (noeud.equals(couple.getValue())) {
			        	soluce.add(couple.getKey());
			    }
	    	}
		}
	}

	@Override
	public GraphSoluce getSoluce() {
		return soluce;
	}

	public int getSteps() {
		return steps;
	}
}

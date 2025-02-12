package sae;

import java.util.Comparator;
import java.util.Set;

import sae.dungeon.Coord;



public class Node {
	public int cout;
	public int heuristique;
	private String name;
	private Set<Node> neighbors;
	private Coord coord;
	
	public Node(String name, Coord coord) {
		this.name = name;
		this.coord = coord;
	}
	
	public void addNeigbour(Node n) {
		neighbors.add(n);
	}
	
	public Set<Node> neighbors(){
		return this.neighbors = neighbors;
	}
	
	public String toString() {
		return "Le node se nomme : " + name + " est il a les coordonnées : " + coord;
	}
	
	public String getName() {
		return name;
	}
	
	public Coord getCoord() {
		return coord;
	}
	
	public boolean equals(Object o) {
		if(neighbors.contains(o)) {
			return true;
		}else {
			return false;
		}
	}
}

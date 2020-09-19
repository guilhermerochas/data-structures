package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	List<Vertice> vertices;
	List<Edge> edges;
	
	public class Vertice{
		String name;
		List<Edge> adj;
		
		public Vertice(String name){
			this.name = name;
			this.adj = new ArrayList<Edge>();
		}
		
		public void addAdj(Edge e) {
			adj.add(e);
		}
	}
	
	public class Edge{
		Vertice from;
		Vertice to;
		
		public Edge(Vertice from, Vertice to) {
			this.from = from;
			this.to = to;
		}
	}
	
	public Graph() {
		vertices = new ArrayList<Vertice>();
		edges = new ArrayList<Edge>();
	}
	
	public void addVertice(String name) {
		Vertice v = new Vertice(name);
		vertices.add(v);
	}
	
	public void addEdge(String from, String to) {
		
		int fromPos = vertices.indexOf(vertices.stream().filter(i -> i.name == from).findFirst().orElse(null));
		int toPos = vertices.indexOf(vertices.stream().filter(i -> i.name == to).findFirst().orElse(null));
		
		if(fromPos == -1 || toPos == -1) {
			return;
		}
		
		Edge e = new Edge(vertices.get(fromPos), vertices.get(toPos));
		vertices.get(fromPos).addAdj(e);
		edges.add(e);
	}
	
	@Override
	public String toString() {
		String rt = "";
		for(Vertice v: vertices) {
			rt += v.name + " -> ";
			for(Edge e: v.adj) {
				Vertice vv = e.to;
				rt += vv.name + ", ";
			}
			rt += "\n";
		}
		return rt;
	}
}

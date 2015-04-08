package br.edu.ufcg.splab.searchs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import br.edu.ufcg.splab.core.InterfaceEdge;
import br.edu.ufcg.splab.core.InterfaceGraph;
import br.edu.ufcg.splab.core.InterfaceVertex;
import br.edu.ufcg.splab.parser.ReadTGF;

public class BreadthFirstSearch {
	public static void main(String[] args) { // Just for testing.
		ReadTGF tgfReader = new ReadTGF();
		try {
			InterfaceGraph graph = tgfReader.getGraph("put_path_here.tgf");
			BreadthFirstSearch searchObject = new BreadthFirstSearch();
			searchObject.getPaths(graph.getRoot());
			for (List<InterfaceEdge> path: searchObject.paths) {
				for(InterfaceEdge e : path) {
					System.out.print(e + "  ");
				}
				System.out.println();
				System.out.println("=====================");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	List<List<InterfaceEdge>> paths;
	Queue<InterfaceEdge> queue;

	public List<List<InterfaceEdge>> getPaths(InterfaceVertex root) {
	    runSearch(root);
	    return paths;
	}
	
	private void runSearch(InterfaceVertex vertex) {
		// Initializing instance variables.
		paths = new ArrayList<List<InterfaceEdge>>();
		queue = new LinkedList<InterfaceEdge>();
		
		for (InterfaceEdge i : vertex.getOutTransitions()) {
	    	// Initializing the queue.
	    	queue.add(i);
	    	
	    	// Creating initial paths.
	    	List<InterfaceEdge> tempPath = new ArrayList<InterfaceEdge>();
	        tempPath.add(i);
	        paths.add(tempPath);
	    }
		
		// Running recursive method to construct paths.
		recursiveSearch(queue.peek());
	}

	private void recursiveSearch(InterfaceEdge edge) {
	    if (!getNeighbors(edge).isEmpty()) {
	    	List<InterfaceEdge> tempPath = new ArrayList<InterfaceEdge>();
	    	
	        for(InterfaceEdge e: getNeighbors(edge)) {
	        	int pathsize = paths.size();  // Store the paths size before it is modified. 
	        	
	            for(int i = 0; i < pathsize; i++) {
	            	List<InterfaceEdge> actualPath = paths.get(i);
	            	
	                if (actualPath.get(actualPath.size() - 1).equals(edge)) {
	                	tempPath = actualPath;
	                    List<InterfaceEdge> newPath = new ArrayList<InterfaceEdge>(actualPath);
	                    newPath.add(e);
	                    paths.add(newPath);
	                }
	            }
	            
	            queue.add(e);
	        }
	        
		    paths.remove(tempPath);
	    }
	    
	    queue.remove(edge);
	   
	    if (!queue.isEmpty()) recursiveSearch(queue.peek()); // Base case.
	}

	private List<InterfaceEdge> getNeighbors(InterfaceEdge edge) {
        if (edge == null) return new ArrayList<InterfaceEdge>();
        return new ArrayList<InterfaceEdge>(edge.getTo().getOutTransitions());
	}
}

package br.edu.ufcg.splab.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import br.edu.ufcg.splab.core.edges.EdgeType;
import br.edu.ufcg.splab.core.graph.Graph;
import br.edu.ufcg.splab.exceptions.GraphException;

public class GraphGeneratorMain {

	public static void main(String[] args) throws GraphException {
		Scanner sc = new Scanner(System.in);
		Graph graph  = new Graph();
		boolean repeat = true;
		
		while(repeat){
		
			System.out.println("Type a number to select one action:");
			System.out.println("1 - Generate a Graph");
			System.out.println("2 - Do a Breadth-First Search on the Graph");
			System.out.println("3 - Do a Depth-First Search on the Graph");
			System.out.println("4 - Exit");
		
			int action = sc.nextInt();
			
			switch(action){
			
			case 1:
				GenerateGraph(graph);
				break;
				
			case 2:
				DoBFS();
				break;
				
			case 3:
				DoDFS();
				break;
				
			case 4:
				repeat = false;
				break;
				
			default:
				System.out.println("Invalid Number");
				break;
			}
		
			
				
			

		
		}
	}
	
	
	//======================================================================
	private static void GenerateGraph(Graph graph) throws GraphException{
		List<UUID> uuidList = new ArrayList<UUID>();
		graph = new Graph();
		GenerateVertexes(graph, uuidList);
		GenerateEdges(graph, uuidList);
	}
	
	private static void DoBFS(){
		
	}
	private static void DoDFS(){
	
	}
	//======================================================================
	
	
	
	private static void GenerateVertexes(Graph graph, List<UUID> uuidList){
		Scanner sc = new Scanner(System.in);
		System.out.println("Type the amount of vertexes the graph will have:");
		int vQnt = sc.nextInt();
		
		
		for(int n = 1; n <= vQnt; n++){
			uuidList.add(graph.addVertex(String.valueOf(n)));
		}
		
		sc.close();
		
	}
	
	private static void GenerateEdges(Graph graph, List<UUID> uuidList) throws GraphException{
		
		Scanner sc1 = new Scanner(System.in);
		boolean repeat = true;
		int n1, n2;
		UUID fromV, toV;
		
		while(repeat){
			System.out.println("Type 0 to exit the loop");
			
			System.out.println("Type the number of the 'from' vertex:");
			n1 = sc1.nextInt();
			if(n1 == 0){
				repeat = false;
			} else if (n1 > uuidList.size()){
				System.out.println("Type a valid number!");
				continue;
			} 
			
			System.out.println("Type the number of the 'to' vertex:");
			n2 = sc1.nextInt();
			if(n2 == 0){
				repeat = false;
			} else if (n2 > uuidList.size()){
				System.out.println("Type a valid number!");
				continue;
			} 
			
			fromV = uuidList.get(n1 - 1);
			toV = uuidList.get(n2 - 1);
			
			graph.createEdge(fromV, toV, n1 + "-->" + n2, EdgeType.DEFAULT);
		}
		
		sc1.close();
		
	}

}

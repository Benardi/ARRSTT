/*
 * @(#)ReadTGF.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                  09/02/2012    
 */
package br.edu.ufcg.splab.graph.parser;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import br.edu.ufcg.splab.graph.core.InterfaceVertex;
import br.edu.ufcg.splab.graph.core.edges.EdgeType;
import br.edu.ufcg.splab.graph.core.graph.Graph;
import br.edu.ufcg.splab.graph.exceptions.LTSBTException;



/**
 * 
 * CLASS:
 *   Class to read a file tgf and converts it into graph
 *
 */

public class ReadTGF {
	
	private Map<String,UUID> aux = new HashMap<String, UUID>();
	private Graph graph ;
	

/**
 * @param tgf file name
 * @return graph specified in tgf
 * @throws Exception
 */	
	public  Graph getGraph(String fileName) throws Exception {
			int cont =0;
	
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("\\s");
			graph = new Graph();
			String line ="";
			while (scanner.hasNextLine() && ! line.equals("#")) {			
				line = scanner.nextLine().trim();
				cont++;
			  String[] labels = line.split("\\s");
				if (!line.trim().equals("#")) {
					UUID uuid = graph.addVertex(labels[0]);
					aux.put(labels[0], uuid);
				}
				
			}
				

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			Scanner scanner2 = new Scanner(line);
			scanner2.useDelimiter("\\s");
			String from = scanner2.next().trim();
			cont++;
			String to = scanner2.next().trim();
			String labelEdge = scanner2.nextLine().trim();
			try {
				graph.createEdge(getUUID(from), getUUID(to), labelEdge,EdgeType.DEFAULT);

			} catch (NullPointerException e) {
				scanner.close();
				// throw new Exception("Error at line "+cont+": "+
				// e.getMessage());
				throw new LTSBTException("Error at line " + cont + ": "+ e.getMessage());
			}
			scanner2.close();

		}
		scanner.close();
		cont = 0;
		return graph;
	}

	/**
	 * 
	 * @param the label vertex
	 * @return the UUID vertex
	 */
	public UUID getUUID(String label){
		return aux.get(label);
	}
	
	
	public static void main(String[] args) {
		ReadTGF l = new ReadTGF();
		Graph g=null;
		try {
			g = l.getGraph("entrada.tgf");

			System.out.println(g.getEdges());
			System.out.println(g.getStates());
			for(InterfaceVertex v : g.getStates().values()){
				System.out.println(v);
				System.out.println("in>>"+v.getInTransitions());
				System.out.println("out>"+v.getOutTransitions());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
	
	}
}

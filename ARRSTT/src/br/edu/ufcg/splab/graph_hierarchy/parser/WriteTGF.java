package br.edu.ufcg.splab.graph_hierarchy.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;

/**
 * Class that creates a TGF file to represent a graph.
 * @author Iaron da Costa Araujo
 *
 */
public class WriteTGF {
	public static final String LINE_END = System.getProperty("line.separator");
	public static final String BETWEEN_DIFFERENT_TYPES = "#";
	
	public WriteTGF(){
		
	}
	
	/**
	 * Receives a graph and create a TGF file to represent it.
	 * @param graph
	 * 		The graph that will have a TGF file.
	 * @param fileName
	 * 		The name of the TGF file
	 * @throws IOException BufferedWriter exception.
	 */
	public void putInTGF(InterfaceGraph graph, String fileName) throws IOException{
		StringBuffer content = new StringBuffer();
		
		// Gets the states
		List<InterfaceVertex> states = new ArrayList<>();
		for(Entry<UUID, InterfaceVertex> entry : graph.getStates().entrySet()){
			states.add(entry.getValue());
		}
		
		// This loop writes the states on the StringBuffer
		for(int i = 0; i < states.size(); i++){
			content.append(i + " " + states.get(i).getLabel() + LINE_END);
		}
		
		content.append(BETWEEN_DIFFERENT_TYPES); // This symbol separates the vertexes from the edges on the TGF
		
		List<InterfaceEdge> transitions = graph.getEdges();
		// This loop writes the transitions on the StringBuffer
		for(InterfaceEdge edge: transitions){
			content.append(LINE_END + edge.getFrom().getLabel() + " " + edge.getTo().getLabel() + " " + edge.getLabel());
		}
		
		putToFile(content, fileName);
	}

	private void putToFile(StringBuffer content, String fileName) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName + ".tgf")));
		writer.write(content.toString());
		writer.close();
		
	}
	
}

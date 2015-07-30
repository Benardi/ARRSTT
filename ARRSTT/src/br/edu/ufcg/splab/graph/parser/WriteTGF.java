package br.edu.ufcg.splab.graph.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.graph.core.InterfaceEdge;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;
import br.edu.ufcg.splab.graph.core.InterfaceVertex;

public class WriteTGF {
	public static final String LINE_END = System.getProperty("line.separator");
	
	public WriteTGF(){
		
	}
	
	public void putInTGF(InterfaceGraph graph, String fileName) throws IOException{
		StringBuffer content = new StringBuffer();
		// Will this work?
		List<InterfaceVertex> states = (ArrayList<InterfaceVertex>) graph.getStates().values();
		for(int i = 0; i < states.size(); i++){
			content.append(i + " " + states.get(i).getLabel() + LINE_END);
		}
		
		content.append("#");
		List<InterfaceEdge> transitions = graph.getEdges();
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

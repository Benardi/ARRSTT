package br.edu.ufcg.splab.experiment_hierarchy.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import br.edu.ufcg.splab.graph.core.InterfaceEdge;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;
import br.edu.ufcg.splab.graph.core.InterfaceVertex;
import br.edu.ufcg.splab.graph.core.edges.EdgeType;
import br.edu.ufcg.splab.graph.core.graph.Graph;

public class GraphFactory {
	public Graph cloneGraph(InterfaceGraph graph) throws Exception {
		Graph clonedGraph = new Graph();
		List<InterfaceVertex> states = new ArrayList<InterfaceVertex>(graph.getStates().values());
		List<InterfaceEdge> edges = graph.getEdges();
		Map<UUID, UUID> uuids = new HashMap<>();
		
		for (InterfaceVertex state : states) {
			UUID uuid = clonedGraph.addVertex(state.getLabel());
			uuids.put(state.getUUID(), uuid);
		}
		
		UUID from, to;
		for (InterfaceEdge edge : edges) {
			from = edge.getFrom().getUUID();
			to = edge.getTo().getUUID();
			clonedGraph.createEdge(uuids.get(from), uuids.get(to), edge.getLabel(), edge.getTipo());
		}
		
		return clonedGraph;
	}
}

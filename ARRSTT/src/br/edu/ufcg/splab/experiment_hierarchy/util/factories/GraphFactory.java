package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceGraph;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;
import br.edu.ufcg.splab.graph_hierarchy.core.graph.Graph;

/**
 * Objective: This class covers all necessary procedure involved in the process
 * of generating a new graph with the same particulars of an existing one.
 * 
 * Description of use: Used by the "maskarator" type classes to create copies
 * that will be manipulated.
 *
 */
public class GraphFactory {
	/**
	 * Objective: Return a new graph which is a copy of the provided one.
	 * 
	 * Description of use: The copy can be masked and used in the experiment while
	 * the original one is kept.
	 * 
	 * @param graph
	 * 		The original graph.
	 * @return
	 * 		A copy of the original graph.
	 * @throws Exception
	 */
	public Graph cloneGraph(InterfaceGraph graph) throws Exception {
		Graph clonedGraph = new Graph();
		List<InterfaceVertex> states = new ArrayList<InterfaceVertex>(graph
				.getStates().values());
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
			clonedGraph.createEdge(uuids.get(from), uuids.get(to),
					edge.getLabel(), edge.getType());
		}

		return clonedGraph;
	}
}

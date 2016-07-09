package br.edu.ufcg.splab.util.factories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import br.edu.ufcg.splab.graph.core.InterfaceEdge;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;
import br.edu.ufcg.splab.graph.core.InterfaceVertex;
import br.edu.ufcg.splab.graph.core.graph.Graph;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
/**
 * <b>Objective:</b> This class covers all necessary procedure involved in the process
 * of generating a new graph with the same particulars of an existing one.
 * <br>
 * <b>Description of use:</b> Used by the "maskarator" type classes to create copies
 * that will be manipulated.
 *
 */
public class GraphFactory {
	/**
	 * <b>Objective:</b> Return a new graph which is a copy of the provided one.
	 * <br>
	 * <b>Description of use:</b> The copy can be masked and used in the experiment while
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

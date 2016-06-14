package br.edu.ufcg.splab.gambiarra;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentFile;
import br.edu.ufcg.splab.experiment_hierarchy.util.OldXMLParser;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class XMLMain {
	
	public static final String LINE_END = System.getProperty("line.separator");
	
	public static void main(String[] args) {
		List<TestSuite> tsList = loadTSList();
		DataGatherer dg = new DataGatherer(tsList);
		putMediaMaxMinToFile(dg.getMediaMaxMins(), dg.getTotalMediaMaxMins());
		putTestCaseSuiteQuantitiesToFile(dg.getTestSuiteQuantity(), dg.getTestCaseQuantities(), dg.getTotalTestCaseQuantity());
		putTransitionOccurrenceToFile(tsList, dg);
	}
	//=============================================================================================
	// Wesley, eu n completei esse metodo pq n sabia como tu ia testar e a gente ainda n tem os xml
	private static List<TestSuite> loadTSList() {
		OldXMLParser parser = new OldXMLParser();
		// TODO 
		return null;
	}
	//=============================================================================================
	
	private static void putMediaMaxMinToFile(Map<TestSuite, MediaMaxMin> mediaMaxMins, MediaMaxMin totalMediaMaxMins) {
		StringBuffer data = new StringBuffer();
		Set<TestSuite> keys = mediaMaxMins.keySet();
		
		MediaMaxMin aux;
		for(TestSuite ts: keys){
			aux = mediaMaxMins.get(ts);
			//To usando o getID pra identificar cada TS por enquanto,
			//mas pra isso tem que inicializar cada TS com id diferente
			data.append("TEST SUITE ID - " + ts.getID() + 
					": MIN - " + aux.getMin() + 
					" MAX - " + aux.getMax() + 
					" MEDIA - " + aux.getMedia() + LINE_END);
			
		}
		data.append("TOTAL: MIN - " + totalMediaMaxMins.getMin() + 
				" MAX - " + totalMediaMaxMins.getMax() + 
				" MEDIA - " + totalMediaMaxMins.getMedia() + LINE_END);
		
		putToFile(data, "MinMaxMedia");
		
	}
	
	private static void putTestCaseSuiteQuantitiesToFile(int tsQnt, Map<TestSuite, Integer> tcQnts, int totalTcQnt) {
		StringBuffer data = new StringBuffer();
		Set<TestSuite> keys = tcQnts.keySet();
		for(TestSuite ts: keys){
			//To usando o getID pra identificar cada TS por enquanto,
			//mas pra isso tem que inicializar cada TS com id diferente
			data.append("TEST SUITE ID - " + ts.getID() + 
					": TEST CASE QUANTITY - " + tcQnts.get(ts) + LINE_END);
		}
		data.append("There is a total of " + totalTcQnt + " Test Cases in " + tsQnt + " Test Suites" + LINE_END);
		putToFile(data, "TestCaseSuiteQuantities");
	}
	
	private static void putToFile(StringBuffer data, String fileName){
		ExperimentFile file = new ExperimentFile(fileName);
		file.appendContent(data);
		try {
			file.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Esse metodo vai servir para ajudar nos testes. Ele cria um arquivo para cada
	 * TestSuite e neste arquivo tem quantas vezes cada transição apareceu.
	 */
	private static void putTransitionOccurrenceToFile(List<TestSuite> tsList, DataGatherer dg) {
		for(TestSuite ts : tsList){
			StringBuffer data = getTransitionsOccurrence(dg.getTransitionsOccurrence(ts));
			putToFile(data, ts.getID());
		}
		
	}

	private static StringBuffer getTransitionsOccurrence(Map<String, Integer> transitionsOccurrence) {
		StringBuffer data = new StringBuffer();
		Set<String> keys = transitionsOccurrence.keySet();
		for(String label : keys){
			data.append(label + ": " + transitionsOccurrence.get(label) + LINE_END);
		}
		return data;
		
	}

}

package br.edu.ufcg.splab.experiment_hierarchy.core.dvcs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ARRSTTException;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceDvc;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class FailuresByFileCollector implements InterfaceDvc {
	
	private File f;
	public FailuresByFileCollector(File f){
		this.f = f;
	}
	
	@Override
	public StringBuffer collect(TestSuite testSuite) {
		if (f != null) {
			List<String> ids = getIDs();
			int defectiveTCamount = 0;
			
			for (TestCase testCase : testSuite) {
				if (ids.contains(testCase.getID())) {
					defectiveTCamount++;
				}
			}
			
			return new StringBuffer(defectiveTCamount + ""); 
		} else {
			return new StringBuffer("NP");
		}
	}
	
	
	// Each id should be a line in the file.
	private List<String> getIDs(){
		BufferedReader reader = null;
		List<String> ids = new ArrayList<String>();
		
		try {
			reader = new BufferedReader(new FileReader(f));
			String line = reader.readLine();
			
			while (line != null) {	
				ids.add(line);
				line = reader.readLine();
			}
			
			return ids;
		} catch (IOException e) {
			throw new ARRSTTException(e.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch(IOException e) {
				throw new ARRSTTException(e.getMessage());
			}
		}
	}

}

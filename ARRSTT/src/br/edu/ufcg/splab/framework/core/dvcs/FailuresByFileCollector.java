package br.edu.ufcg.splab.framework.core.dvcs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.exceptions.ARRSTTException;
import br.edu.ufcg.splab.framework.core.api.InterfaceDvc;
import br.edu.ufcg.splab.util.testcollections.TestCase;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

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
			System.out.println(ids);
			
			for (TestCase testCase : testSuite) {
				System.out.print(testCase.getID()+" ");
				if (ids.contains(testCase.getID())) {
					defectiveTCamount++;
				}
			}
			System.out.println();
			double percentageFailure = 100*((double)defectiveTCamount/(double)ids.size());
			percentageFailure = (double)((int)percentageFailure/100.0);
			return new StringBuffer(percentageFailure + "");
			
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

package br.edu.ufcg.splab.experimentsExamples.core.formaters;

import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.DataFormater;
import br.edu.ufcg.splab.experimentsExamples.util.ArresttConstants;
import br.edu.ufcg.splab.experimentsExamples.util.ResultData;

public class DefaultFormater implements DataFormater{

	@Override
	public StringBuffer format(List<ResultData> data) {
		StringBuffer result = new StringBuffer();
		
		for(ResultData d : data){
			result.append(d.getName() + " " + d.getContent() + ArresttConstants.LINE_SEPARATOR);
		}
		
		
		return result;
	}

}

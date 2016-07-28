package br.edu.ufcg.splab.experimentsExamples.core.formaters;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.edu.ufcg.splab.arrsttFramework.DataFormater;
import br.edu.ufcg.splab.experimentsExamples.util.ArresttConstants;
import br.edu.ufcg.splab.experimentsExamples.util.ResultData;

public class TableFormater implements DataFormater{

	@Override
	public StringBuffer format(List<ResultData> data) {
		StringBuffer result = new StringBuffer();
		
		int lineSize = calculateLineSize(data);
		result.append(addHeader(data, lineSize));
		
		for(int i = 0; i < data.size(); i++){
			result.append(data.get(i).getContent() + "\t");
			if((i+1) % lineSize == 0) result.append(ArresttConstants.LINE_SEPARATOR);
		}
		
		
		return result;
	}

	private int calculateLineSize(List<ResultData> data) {
		Set<String> names = new HashSet<>();
		int size = 0;
		for(ResultData d : data){
			if(names.contains(d.getName())) break;
			size++;
			names.add(d.getName());
		}
		return size;
	}
	
	private String addHeader(List<ResultData> data, int size){
		StringBuffer header = new StringBuffer();
		for(int i = 0; i < size; i++){
			header.append(data.get(i).getName() + "\t");
		}
		header.append(ArresttConstants.LINE_SEPARATOR);
		return header.toString();
	}

}

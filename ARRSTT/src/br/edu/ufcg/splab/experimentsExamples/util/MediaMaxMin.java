package br.edu.ufcg.splab.experimentsExamples.util;

public class MediaMaxMin {
	private double media;
	private int max, min;
	
	public MediaMaxMin(double media, int max, int min){
		this.media = media;
		this.max = max;
		this.min = min;
	}

	public double getMedia() {
		return media;
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}
	
	
}

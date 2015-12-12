package br.edu.ufcg.splab.experiment_hierarchy.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.ufcg.splab.experiment_hierarchy.facade.ARRSTTFacade;

/* Change		Author		Date
 * Creation		Iaron		2015-09-29
 */
public class ExperimentMenu {
	private static Scanner scan = new Scanner(System.in);
	private static ARRSTTFacade facade = new ARRSTTFacade();
	private static int experimentNumber;
	private static List<List<String>> inputs;
	
	public static void main(String[] args) {
		inputs = new ArrayList<List<String>>();
		System.out.println("Welcome to the experiment menu!");
		experimentSelection();
		System.out.println("Now, pick the treatments.");
		
		if (experimentNumber == 1){
			selectSearch();
			selectLoopCoverage();
			selectGenerationDVC();
		} else if (experimentNumber == 2){
			selectSelection();
			selectSelectionPercentage();
			//selectMaskPercentage();
			selectSelectionDVC();
		} else if (experimentNumber == 3) {
			selectMinimization();
			selectBuilder();
			selectMinimizationDVC();
		}
		
		try {
			facade.execute(inputs);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void experimentSelection(){
		boolean haventSelected = true;
		int experimentNumber = -1;
		
		while(haventSelected){
			System.out.println("We have two experiments available at the moment.\n"
					+ "Write the number of the desired experiment (1 - Generation 2 - Selection 3 - Minimization)");
		
			experimentNumber = scan.nextInt();
			scan.nextLine();
			if(experimentNumber < 1 || experimentNumber > 3){
				System.out.println("Please, select a valid experiment");
			} else {
				haventSelected = false;
			}
		}
		ExperimentMenu.experimentNumber = experimentNumber;
		
		List<String> input = new ArrayList<String>();
		
		if (experimentNumber == 1) {
			input.add("generation");
		} else if (experimentNumber == 2){
			input.add("selection");
		} else if (experimentNumber == 3) {
			input.add("minimization");
		}
		
		inputs.add(input);
	}
	
	private static void selectSearch(){
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which treatments you want for generation:");
			System.out.println("1 - DFS 2 - BFS");
			System.out.println("Output exemple: 1 2 1");
			output = scan.nextLine();
			results = output.split(" ");
			
			if(results.length == 0){
				System.out.println("Please, input valid numbers");
			} else {
				List<String> input = new ArrayList<String>();
				
				for(int i = 0; i < results.length; i++) {
					
					if (results[i].equals("1")) {
						input.add("DFS");
					} else if (results[i].equals("2")) {
						input.add("BFS");
					}
				}
				
				inputs.add(input);
				haventSelected = false;
			}
		}
	}
	
	private static void selectSelection(){
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which treatments you want for selection:");
			System.out.println("1 - Random 2 - Biggest 3 - Similarity");
			System.out.println("Output exemple: 1 2 3 2");
			output = scan.nextLine();
			results = output.split(" ");
			
			if(results.length == 0){
				System.out.println("Please, input valid numbers");
			}else {
				List<String> input = new ArrayList<String>();
				
				for(int i = 0; i < results.length; i++){
					if (results[i].equals("1")) {
						input.add("random");
					} else if (results[i].equals("2")) {
						input.add("biggest");
					} else if (results[i].equals("3")) {
						input.add("similarity");
					}
				}
				
				inputs.add(input);
				haventSelected = false;
			}
		}
	}
	
	private static void selectLoopCoverage(){
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which loop coverages you want:");
			System.out.println("Output exemple: 0 1 2 3 4 5 6");
			output = scan.nextLine();
			results = output.split(" ");
			
			if(results.length == 0){
				System.out.println("Please, input valid numbers");
			}else {
				List<String> input = new ArrayList<String>();
				System.out.println("--- ADICIONANDO ---");
				for(int i = 0; i < results.length; i++){
					System.out.println(results[i]);
					input.add(results[i]);
				}
				System.out.println("--- ADICIONANDO ---");
				haventSelected = false;
				inputs.add(input);
			}
		}
	}
	
	private static void selectSelectionPercentage(){
		boolean haventSelected = true;
		double percentage = -1;
		while(haventSelected){
			System.out.println("Now, select the selection's percentage");
			System.out.println("Output exemple: 0.4");
			percentage = scan.nextDouble();
			scan.nextLine();
			if(percentage < 0.0 || percentage > 1.0){
				System.out.println("Please, input a valid number");
			} else {
				List<String> input = new ArrayList<String>();
				input.add(percentage + "");
				inputs.add(input);
				
				haventSelected = false;
			}
		}
	}
	
	/*private static void selectMaskPercentage(){
		boolean haventSelected = true;
		double percentage = -1;
		while(haventSelected){
			System.out.println("Now, select the mask's percentage");
			System.out.println("Output exemple: 0.7");
			percentage = scan.nextDouble();
			if(percentage < 0.0 || percentage > 1.0){
				System.out.println("Please, input a valid number");
			} else {
				facade.addMaskPercentage(percentage);
				haventSelected = false;
			}
		}
	}*/
	
	private static void selectGenerationDVC(){
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which dependent variables you want:");
			System.out.println("1 - Time 2 - Size");
			System.out.println("Output exemple: 1 2");
			output = scan.nextLine();
			results = output.split(" ");
			
			if(results.length == 0){
				System.out.println("Please, input valid numbers");
			}else {
				List<String> input = new ArrayList<String>();
				
				for(int i = 0; i < results.length; i++){
					if (results[i].equals("1")) {
						input.add("time");
					} else if (results[i].equals("2")) {
						input.add("size");
					}
				}
				
				haventSelected = false;
				inputs.add(input);
			}
		}
	}
	
	private static void selectMinimization() {
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which treatments you want for minimization:");
			System.out.println("1 - G 2 - GE 3 - GRE 4 - H");
			System.out.println("Output exemple: 1 2 4 2");
			output = scan.nextLine();
			results = output.split(" ");
			
			if(results.length == 0){
				System.out.println("Please, input valid numbers");
			}else {
				List<String> input = new ArrayList<String>();
				
				for(int i = 0; i < results.length; i++){
					if (results[i].equals("1")) {
						input.add("G");
					} else if (results[i].equals("2")) {
						input.add("GE");
					} else if (results[i].equals("3")) {
						input.add("GRE");
					} else if (results[i].equals("4")) {
						input.add("H");
					}
				}
				
				inputs.add(input);
				haventSelected = false;
			}
		}
	}
	
	private static void selectBuilder() {
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which treatments you want for minimization:");
			System.out.println("1 - AT 2 - AP");
			System.out.println("Output exemple: 1");
			output = scan.nextLine();
			results = output.split(" ");
			
			if (results.length == 0){
				System.out.println("Please, input valid numbers");
			} else {
				List<String> input = new ArrayList<String>();
				
				if (output.equals("1")) {
					input.add("AT");
				} else if (output.equals("2")) {
					input.add("AP");
				}
				
				inputs.add(input);
				haventSelected = false;
			}
		}
	}
	
	private static void selectMinimizationDVC(){
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which dependent variables you want:");
			System.out.println("1 - Time 2 - Size 3 - Defects 4 - Defective trasitions 5 - Failures 6 - Reduction");
			System.out.println("Output exemple: 1 2 3 4 5 6");
			output = scan.nextLine();
			results = output.split(" ");
			
			if(results.length == 0){
				System.out.println("Please, input valid numbers");
			}else {
				List<String> input = new ArrayList<String>();
				
				for(int i = 0; i < results.length; i++){
					if (results[i].equals("1")) {
						input.add("time");
					} else if (results[i].equals("2")) {
						input.add("size");
					} else if (results[i].equals("3")) {
						input.add("defects");
					} else if (results[i].equals("4")) {
						input.add("defective edges");
					} else if (results[i].equals("5")) {
						input.add("failures");
					} else if (results[i].equals("6")) {
						input.add("reduction");
					}
				}
				
				haventSelected = false;
				inputs.add(input);
			}
		}
	}
	
	private static void selectSelectionDVC(){
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which dependent variables you want:");
			System.out.println("1 - Time 2 - Size 3 - Defects 4 - Defective trasitions 5 - Failures");
			System.out.println("Output exemple: 1 2 3 4 5");
			output = scan.nextLine();
			results = output.split(" ");
			
			if(results.length == 0){
				System.out.println("Please, input valid numbers");
			}else {
				List<String> input = new ArrayList<String>();
				
				for(int i = 0; i < results.length; i++){
					if (results[i].equals("1")) {
						input.add("time");
					} else if (results[i].equals("2")) {
						input.add("size");
					} else if (results[i].equals("3")) {
						input.add("defects");
					} else if (results[i].equals("4")) {
						input.add("defective edges");
					} else if (results[i].equals("5")) {
						input.add("failures");
					}
				}
				
				haventSelected = false;
				inputs.add(input);
			}
		}
	}
	
	

}

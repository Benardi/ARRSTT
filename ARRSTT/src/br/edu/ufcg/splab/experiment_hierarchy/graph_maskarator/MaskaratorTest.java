package br.edu.ufcg.splab.experiment_hierarchy.graph_maskarator;

import br.edu.ufcg.splab.experiment_hierarchy.searches.DepthFirstSearch;
import br.edu.ufcg.splab.experiment_hierarchy.searches.InterfaceSearch;
import br.edu.ufcg.splab.experiment_hierarchy.util.ErrorStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;
import br.edu.ufcg.splab.graph.parser.ReadTGF;
import br.edu.ufcg.splab.graph.parser.WriteTGF;

public class MaskaratorTest {

	public static void main(String[] args) throws Exception {
		GraphMaskaratorInterface maskR, maskI;
		InterfaceGraph g1random, g1iaron, g2random, g2iaron;
		ReadTGF reader = new ReadTGF();
		WriteTGF writer = new WriteTGF();
		maskI = new IaronMaskarator();
		maskR = new RandomMaskarator();
		
		//g1random = reader.getGraph("C:\\Users\\Iaron\\git\\application-of-reproducibility-research-with-software-testing\\ARRSTT\\input_examples\\iaron_easytoy3.tgf");
		//g1iaron = reader.getGraph("C:\\Users\\Iaron\\git\\application-of-reproducibility-research-with-software-testing\\ARRSTT\\input_examples\\iaron_easytoy3.tgf");
		//g2random = reader.getGraph("C:\\Users\\Iaron\\git\\application-of-reproducibility-research-with-software-testing\\ARRSTT\\input_examples\\iaron_mediumtoy2.tgf");
		//g2iaron = reader.getGraph("C:\\Users\\Iaron\\git\\application-of-reproducibility-research-with-software-testing\\ARRSTT\\input_examples\\iaron_mediumtoy2.tgf");
		
		//maskI.maskarate(g1iaron, 0.40);
		//maskI.maskarate(g2iaron, 0.40);
		//maskR.maskarate(g1random, 0.40);
		//maskR.maskarate(g2random, 0.40);
		
		//writer.putInTGF(g1iaron, "C:\\Users\\Iaron\\git\\application-of-reproducibility-research-with-software-testing\\ARRSTT\\easytoy3_iaronmasked3");
		//writer.putInTGF(g1random, "C:\\Users\\Iaron\\git\\application-of-reproducibility-research-with-software-testing\\ARRSTT\\easytoy3_randommasked3");
		//writer.putInTGF(g2iaron, "C:\\Users\\Iaron\\git\\application-of-reproducibility-research-with-software-testing\\ARRSTT\\mediumtoy2_iaronmasked3");
		//writer.putInTGF(g2random, "C:\\Users\\Iaron\\git\\application-of-reproducibility-research-with-software-testing\\ARRSTT\\mediumtoy2_randommasked3");
		
		InterfaceGraph easyGraph3 = reader.getGraph("C:/Users/Wesley/git/application-of-reproducibility-research-with-software-testing/ARRSTT/easytoy3_iaronmasked.tgf");
		InterfaceSearch z = new DepthFirstSearch();
		TestSuite ts = z.getTestSuite(easyGraph3.getRoot(), 0);
		
		ErrorStructure x = new ErrorStructure(ts);
		System.out.println(x.countDefects());
		System.out.println(x.countFails());
		
	}

}

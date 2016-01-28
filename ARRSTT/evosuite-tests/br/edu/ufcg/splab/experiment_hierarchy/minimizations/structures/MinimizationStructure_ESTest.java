/*
 * This file was automatically generated by EvoSuite
 * Tue Jan 26 16:59:12 GFT 2016
 */

package br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures;

import static org.evosuite.runtime.EvoAssertions.assertThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.ARRSTTTestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceEdge;
import br.edu.ufcg.splab.graph_hierarchy.core.InterfaceVertex;
import br.edu.ufcg.splab.graph_hierarchy.core.edges.Transition;
import br.edu.ufcg.splab.graph_hierarchy.core.edges.TransitionType;
import br.edu.ufcg.splab.graph_hierarchy.core.vertex.Vertex;

@RunWith(EvoRunner.class) @EvoRunnerParameters(useVNET = true) 
public class MinimizationStructure_ESTest extends MinimizationStructure_ESTest_scaffolding {

  @Test
  public void test00()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      // Undeclared exception!
      try { 
        minimizationStructure0.removeAllTuples((Set<TestRequirement>) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures.MinimizationStructure", e);
      }
  }

  @Test
  public void test01()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      minimizationStructure0.insert((TestCase) null, (TestRequirement) null);
      // Undeclared exception!
      try { 
        minimizationStructure0.getTestCases((TestRequirement) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures.MinimizationStructure", e);
      }
  }

  @Test
  public void test02()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      boolean boolean0 = minimizationStructure0.isEmpty();
      assertTrue(boolean0);
  }

  @Test
  public void test03()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      assertTrue(minimizationStructure0.isEmpty());
      
      Vertex vertex0 = new Vertex("");
      TransitionType transitionType0 = TransitionType.EXPECTED_RESULTS;
      Transition transition0 = new Transition((InterfaceVertex) vertex0, "", (InterfaceVertex) vertex0, transitionType0);
      ARRSTTTestRequirement aRRSTTTestRequirement0 = new ARRSTTTestRequirement((InterfaceEdge) transition0);
      minimizationStructure0.insert((TestCase) null, aRRSTTTestRequirement0);
      boolean boolean0 = minimizationStructure0.isEmpty();
      assertFalse(boolean0);
  }

  @Test
  public void test04()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      LinkedHashSet<TestRequirement> linkedHashSet0 = new LinkedHashSet<TestRequirement>(451);
      Vertex vertex0 = new Vertex("[r~Z?x5");
      TransitionType transitionType0 = TransitionType.DEFAULT;
      Transition transition0 = new Transition((InterfaceVertex) vertex0, "[r~Z?x5", (InterfaceVertex) vertex0, transitionType0);
      ARRSTTTestRequirement aRRSTTTestRequirement0 = new ARRSTTTestRequirement((InterfaceEdge) transition0);
      linkedHashSet0.add(aRRSTTTestRequirement0);
      minimizationStructure0.removeAllTuples(linkedHashSet0);
      assertEquals(1, linkedHashSet0.size());
  }

  @Test
  public void test05()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      Vertex vertex0 = new Vertex("");
      TransitionType transitionType0 = TransitionType.DEFAULT;
      Transition transition0 = new Transition((InterfaceVertex) vertex0, "", (InterfaceVertex) vertex0, transitionType0);
      ARRSTTTestRequirement aRRSTTTestRequirement0 = new ARRSTTTestRequirement((InterfaceEdge) transition0);
      minimizationStructure0.insert((TestCase) null, aRRSTTTestRequirement0);
      minimizationStructure0.removeTuples((TestRequirement) aRRSTTTestRequirement0);
      assertTrue(minimizationStructure0.isEmpty());
  }

  @Test
  public void test06()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      Vertex vertex0 = new Vertex("");
      TransitionType transitionType0 = TransitionType.EXPECTED_RESULTS;
      Transition transition0 = new Transition((InterfaceVertex) vertex0, "", (InterfaceVertex) vertex0, transitionType0);
      ARRSTTTestRequirement aRRSTTTestRequirement0 = new ARRSTTTestRequirement((InterfaceEdge) transition0);
      minimizationStructure0.insert((TestCase) null, aRRSTTTestRequirement0);
      minimizationStructure0.removeTuples((TestRequirement) null);
      assertFalse(minimizationStructure0.isEmpty());
  }

  @Test
  public void test07()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      minimizationStructure0.insert((TestCase) null, (TestRequirement) null);
      // Undeclared exception!
      try { 
        minimizationStructure0.removeTuples((TestRequirement) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures.MinimizationStructure", e);
      }
  }

  @Test
  public void test08()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      minimizationStructure0.removeTuples((TestCase) null);
      assertTrue(minimizationStructure0.isEmpty());
  }

  @Test
  public void test09()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      Vertex vertex0 = new Vertex("");
      TransitionType transitionType0 = TransitionType.DEFAULT;
      Transition transition0 = new Transition((InterfaceVertex) vertex0, "", (InterfaceVertex) vertex0, transitionType0);
      ARRSTTTestRequirement aRRSTTTestRequirement0 = new ARRSTTTestRequirement((InterfaceEdge) transition0);
      minimizationStructure0.insert((TestCase) null, aRRSTTTestRequirement0);
      // Undeclared exception!
      try { 
        minimizationStructure0.removeTuples((TestCase) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures.MinimizationStructure", e);
      }
  }

  @Test
  public void test10()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      Vertex vertex0 = new Vertex("");
      TransitionType transitionType0 = TransitionType.DEFAULT;
      Transition transition0 = new Transition((InterfaceVertex) vertex0, "", (InterfaceVertex) vertex0, transitionType0);
      ARRSTTTestRequirement aRRSTTTestRequirement0 = new ARRSTTTestRequirement((InterfaceEdge) transition0);
      minimizationStructure0.insert((TestCase) null, aRRSTTTestRequirement0);
      Set<TestCase> set0 = minimizationStructure0.getTestCases((TestRequirement) aRRSTTTestRequirement0);
      assertEquals(1, set0.size());
  }

  @Test
  public void test11()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      ARRSTTTestRequirement aRRSTTTestRequirement0 = new ARRSTTTestRequirement((List<InterfaceEdge>) null);
      minimizationStructure0.insert((TestCase) null, aRRSTTTestRequirement0);
      Set<TestCase> set0 = minimizationStructure0.getTestCases((TestRequirement) null);
      assertTrue(set0.isEmpty());
  }

  @Test
  public void test12()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      Vertex vertex0 = new Vertex("");
      TransitionType transitionType0 = TransitionType.EXPECTED_RESULTS;
      Transition transition0 = new Transition((InterfaceVertex) vertex0, "", (InterfaceVertex) vertex0, transitionType0);
      ARRSTTTestRequirement aRRSTTTestRequirement0 = new ARRSTTTestRequirement((InterfaceEdge) transition0);
      minimizationStructure0.insert((TestCase) null, aRRSTTTestRequirement0);
      Set<TestCase> set0 = minimizationStructure0.getTestCases();
      assertEquals(1, set0.size());
  }

  @Test
  public void test13()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      Vertex vertex0 = new Vertex("[r~Z?x5");
      TransitionType transitionType0 = TransitionType.DEFAULT;
      Transition transition0 = new Transition((InterfaceVertex) vertex0, "[r~Z?x5", (InterfaceVertex) vertex0, transitionType0);
      ARRSTTTestRequirement aRRSTTTestRequirement0 = new ARRSTTTestRequirement((InterfaceEdge) transition0);
      minimizationStructure0.insert((TestCase) null, aRRSTTTestRequirement0);
      Set<TestRequirement> set0 = minimizationStructure0.getTestRequirements();
      assertFalse(set0.isEmpty());
  }

  @Test
  public void test14()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      Set<TestRequirement> set0 = minimizationStructure0.getTestRequirements((TestCase) null);
      assertTrue(set0.isEmpty());
  }

  @Test
  public void test15()  throws Throwable  {
      MinimizationStructure minimizationStructure0 = new MinimizationStructure();
      ARRSTTTestRequirement aRRSTTTestRequirement0 = new ARRSTTTestRequirement((List<InterfaceEdge>) null);
      minimizationStructure0.insert((TestCase) null, aRRSTTTestRequirement0);
      // Undeclared exception!
      try { 
        minimizationStructure0.getTestRequirements((TestCase) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures.MinimizationStructure", e);
      }
  }
}
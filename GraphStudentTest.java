/*
 * Works for both Graph and TownGraphManager
 */


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GraphStudentTest {
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@Before
	public void setUp() throws Exception {
		 graph = new Graph();
		 town = new Town[5];
		 town[0] = new Town("Town A");
		 town[1] = new Town("Town B");
		 town[2] = new Town("Town C");
		 town[3] = new Town("Town D");
		 town[4] = new Town("Town E");
		  
		  for (int i = 0; i < 5; i++)
		  {
			  graph.addVertex(town[i]);
		  }
		  
		  graph.addEdge(town[1], town[2], 1, "Road A");
		  graph.addEdge(town[2], town[3], 2, "Road B");
		  graph.addEdge(town[3], town[4], 3, "Road C");
		  graph.addEdge(town[1], town[4], 4, "Road D");
		  graph.addEdge(town[2], town[4], 5, "Road E");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testEdge() {
		assertEquals(new Road(town[1], town[2], "Road A"), graph.getEdge(town[1], town[2]));
		assertEquals(true, graph.containsEdge(town[1], town[2]));
		graph.addEdge(town[3], town[4], 1, "Road F");
		assertEquals(true, graph.containsEdge(town[3], town[4]));
	}

	@Test
	public void testVertex() {
		Town newTown = new Town("Town F");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
		assertEquals(true, graph.containsVertex(new Town("Town C")));
		assertEquals(false, graph.containsVertex(new Town("Town G")));
	}
}

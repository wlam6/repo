import java.util.*;

public class TownGraphManager implements TownGraphManagerInterface
{
	Graph townGraph = new Graph();
	
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	public boolean addRoad(String town1, String town2, int weight, String roadName)
	{
		Town newtown1 = new Town(town1);
		Town newtown2 = new Town(town2);
		Road result = townGraph.addEdge(newtown1, newtown2, weight, roadName);
		if (result == null)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	public String getRoad(String town1, String town2)
	{
		Town newtown1 = new Town(town1);
		Town newtown2 = new Town(town2);
		Road result = townGraph.getEdge(newtown1, newtown2);
		if (result == null)
		{
			return null;
		}
		return result.getName();
	}
	
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	public boolean addTown(String v)
	{
		Town newTown = new Town(v);
		return townGraph.addVertex(newTown);
	}
	
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town is in the graph, false if not
	 */
	public boolean containsTown(String v)
	{
		Town newTown = new Town(v);
		return townGraph.containsVertex(newTown);
	}
	
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	public boolean containsRoadConnection(String town1, String town2)
	{
		Town newtown1 = new Town(town1);
		Town newtown2 = new Town(town2);
		return townGraph.containsEdge(newtown1, newtown2);
	}
	
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	public ArrayList<String> allRoads()
	{
		ArrayList<String> roads = new ArrayList<>();
		for (Road road : townGraph.edgeSet())
		{
			roads.add(road.getName());
		}
		return roads;
	}
	
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	public boolean deleteRoadConnection(String town1, String town2, String road)
	{
		Town newtown1 = new Town(town1);
		Town newtown2 = new Town(town2);
		Road newRoad = townGraph.getEdge(newtown1, newtown2);
		Road result = townGraph.removeEdge(newtown1, newtown2, newRoad.getWt(), newRoad.getName());
		if (result == null)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	public boolean deleteTown(String v)
	{
		Town newTown = new Town(v);
		return townGraph.removeVertex(newTown);
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	public ArrayList<String> allTowns()
	{
		ArrayList<String> towns = new ArrayList<>();
		for (Town town : townGraph.vertexSet())
		{
			towns.add(town.getName());
		}
		return towns;
	}
	
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	public ArrayList<String> getPath(String town1, String town2)
	{
		Town newtown1 = new Town(town1);
		Town newtown2 = new Town(town2);
		return townGraph.shortestPath(newtown1, newtown2);
	}
	
}

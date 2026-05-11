import java.util.*;
/**
 * Implemented Graph
 */
public class Graph implements GraphInterface<Town, Road>
{
	private Set<Town> towns = new TreeSet<>();
	private Set<Road> roads = new TreeSet<>();
	
    /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
    public Road getEdge(Town sourceVertex, Town destinationVertex)
    {
    	// If any of the specified vertices is null returns null
    	if (sourceVertex == null || destinationVertex == null)
    	{
    		return null;
    	}
    	// Returns an edge connecting source vertex to target vertex if such vertices and such edge exist in this graph.
    	for (Road road : roads)
    	{
    		if (road.contains(sourceVertex) && road.contains(destinationVertex))
    		{
    			// In undirected graphs, the returned edge may have its source and target vertices in the opposite order.
    			return road;
    		}
    	}
    	// Otherwise returns null.
    	return null;
    }

    /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws NullPointerException if any of the specified vertices is null.
     * @throws If they are not found in graph IllegalArgumentException is
     * thrown.
     */
    public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
    {
    	if (sourceVertex == null || destinationVertex == null)
    	{
    		throw new NullPointerException();
    	}
    	if (this.containsVertex(sourceVertex) == false || this.containsVertex(destinationVertex) == false)
    	{
    		throw new IllegalArgumentException();
    	}
    	Road road = new Road(sourceVertex, destinationVertex, weight, description);
    	roads.add(road);
    	return road;
    }

    /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
    public boolean addVertex(Town v)
    {
    	if (v == null)
    	{
    		throw new NullPointerException();
    	}
    	Town town = new Town(v);
    	for (Town existingTown : towns)
    	{
    		if (town.equals(existingTown))
    		{
    			return false;
    		}
    	}
    	towns.add(town);
    	return true;
    }

    /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
    public boolean containsEdge(Town sourceVertex, Town destinationVertex)
    {
    	if (sourceVertex == null || destinationVertex == null)
    	{
    		return false;
    	}
    	for (Road road : roads)
    	{
    		if (road.contains(sourceVertex) && road.contains(destinationVertex))
    		{
    			return true;
    		}
    	}
    	return false;
    }

    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
    public boolean containsVertex(Town v)
    {
    	for (Town town : towns)
    	{
    		if (town.equals(v))
    		{
    			return true;
    		}
    	}
    	return false;
    }

    /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
    public Set<Road> edgeSet()
    {
    	return roads;
    }

    /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
    public Set<Road> edgesOf(Town vertex)
    {
    	if (this.containsVertex(vertex) == false)
    	{
    		throw new IllegalArgumentException();
    	}
    	if (vertex == null)
    	{
    		throw new NullPointerException();
    	}
    	Set<Road> roads2 = new TreeSet<>();
    	// If no edges are touching the specified vertex returns an empty set.
    	// Returns a set of all edges touching the specified vertex (also referred to as adjacent vertices).
    	for (Road road : roads)
    	{
    		if (road.contains(vertex))
    		{
    			roads2.add(road);
    		}
    	}
    	return roads2;
    }

    /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
    public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
    {
    	Iterator<Road> iter = roads.iterator();
    	Road tempRoad = null;
    	// Removes an edge going from source vertex to target vertex, if such vertices and such edge exist in this graph. 
    	while (iter.hasNext())
    	{
    		Road next = iter.next();
    		// If weight >- 1 it must be checked If description != null, it must be checked 
    		if (next.contains(sourceVertex) && next.contains(destinationVertex) && weight > -1 && description != null)
    		{
    			tempRoad = next;
    			iter.remove();
    		}
    	}
    	// or null otherwise.
    	return tempRoad;
    }

    /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
    public boolean removeVertex(Town v)
    {
    	Iterator<Town> iter = towns.iterator();
    	// If the specified vertex is null returns false.
    	if (v == null || this.containsVertex(v) == false)
    	{
    		return false;
    	}
    	// if the graph contains a vertex u such that u.equals(v), the call removes all edges that touch u and then removes u itself.
    	while (iter.hasNext())
    	{
    		if (iter.next().equals(v))
    		{
    			iter.remove();
    		}
    	}
    	// Returns true if the graph contained the specified vertex. (The graph will not contain the specified vertex once the call returns).
    	// If no such u is found, the call leaves the graph unchanged.
    	return true;
    }

    /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
    public Set<Town> vertexSet()
    {
    	return towns;
    }
    
    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     */
    
    public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex)
    {
    	ArrayList<String> path = new ArrayList<>();
    	dijkstraShortestPath(sourceVertex);
    	for (Road r : roads)
    	{
    		path.add(sourceVertex.getName() + " via " + r.getName() + " to " + destinationVertex.getName() + " " + r.getWt() + " mi");
    	}
    	return path;
    }
    
    /**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */
    public void dijkstraShortestPath(Town sourceVertex)
    {
    	// Code taken from class slides, method 2, as stated in class
    	Set<Town> open = new TreeSet<>();
    	Set<Town> closed = new TreeSet<>();
    	closed.add(sourceVertex);
    	while (open.isEmpty() == false)
    	{
    		int minWeight = Integer.MAX_VALUE;
    		Town minAdjTown = null;
    		for (Town t : closed)
    		{
    			for (Town adjTown : t.getAdjTowns())
    			{
    				int weight = adjTown.getMinWtToSource(sourceVertex);
    				if (weight < minWeight)
    				{
    					minWeight = weight;
    					minAdjTown = adjTown;
    					adjTown.setBackPath(t);
    				}
    			}
    		}
    		if (minAdjTown != null)
    		{
    			minAdjTown.setWt(minWeight);
    			open.remove(minAdjTown);
    			closed.add(minAdjTown);
    		}
    	}
    }
}
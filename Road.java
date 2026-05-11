public class Road implements Comparable<Road>
{
	private String name;
	private Town source;
	private Town destination;
	private int weight;
	
	public Road(Town source, Town destination, int degrees, String name)
	{
		this.source = source;
		this.destination = destination;
		this.weight = degrees;
		this.name = name;
	}
	
	public Road(Town source, Town destination, String name)
	{
		this.source = source;
		this.destination = destination;
		this.name = name;
	}
	
	/*
	 * Returns true only if the edge contains the given town
	 * @param town - a vertex of the graph
	 * @return true only if the edge is connected to the given vertex
	 */
	public boolean contains(Town town)
	{
		return source.equals(town) || destination.equals(town);
	}
	
	/*
	 * To string method.
	 */
	public String toString()
	{
		return name;
	}
	
	/*
	 * Returns the road weight
	 * @return The weight of the road
	 */
	public int getWt()
	{
		return weight;
	}
	
	/*
	 * Returns the road name
	 * @return The name of the road
	 */
	public Town getDestination()
	{
		return destination;
	}
	
	
	/*
	 * Returns the road name
	 * @return The name of the road
	 */
	public String getName()
	{
		return name;
	}
	
	/*
	 * Returns the first town on the road
	 * @return A town on the road
	 */
	public Town getSource()
	{
		return source;
	}
	
	/*
	 * Returns the name alphabetical difference
	 * @return the name alphabetical difference
	 */
	public int compareTo(Road o)
	{
		return name.compareTo(o.getName());
	}
	
	@Override
	public boolean equals(Object r)
	{
		return name.equals(((Road) r).getName());
	}
}

import java.util.Set;
/*
 * Represents an actor as a node of a graph
 */
public class Town implements Comparable<Town>
{
	private String name;
	private int wt;
	private Set<Town> adjTowns;
	private Town backPath;
	
	public Town(String name)
	{
		this.name = name;
	}
	
	public Town(Town templateTown)
	{
		name = templateTown.getName();
	}
	
	/*
	 * Returns the town's name
	 * @return town's name
	 */
	public String getName()
	{
		return name;
	}
	
	/*
	 * Compare to method
	 */
	public int compareTo(Town o)
	{
		return name.compareTo(o.getName());
	}
	
	/*
	 * To string method
	 */
	@Override
	public String toString()
	{
		return name;
	}
	
	public void addAdjTown(Town adjTown)
	{
		adjTowns.add(adjTown);
	}
	
	public Set<Town> getAdjTowns()
	{
		return adjTowns;
	}
	
	public int getWt()
	{
		return wt;
	}
	
	public void setWt(int wt)
	{
		this.wt = wt;
	}
	
	public Town getBackPath()
	{
		return backPath;
	}
	
	public void setBackPath(Town backPath)
	{
		this.backPath = backPath;
	}
	
	public int hashCode()
	{
		return this.hashCode();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return name.equals(((Town) obj).getName());
	}
	
	public int getMinWtToSource(Town sourceVertex)
	{
		return wt;
	}
}

/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: Represents plot object Project 4
 * Due: 10/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: William Lam
*/

public class Plot 
{
	private int x, y, depth, width;
	
	// Creates a default Plot with width and depth of 1.
	public Plot()
	{
		depth = 1;
		width = 1;
	}
	
	/**
	 * Creates a Plot using the given values.
	 * @param x - the x coordinate of the plot
	 * @param y - the y coordinate of the plot
	 * @param width - the width coordinate of the plot
	 * @param depth - the depth coordinate of the plot
	 */
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Creates a new plot given another plot. This constructor must call an appropriate existing constructor.
	 * @param otherPlot - the plot to make a copy of
	 */
	public Plot(Plot otherPlot)
	{
		this.x = otherPlot.getX();
		this.y = otherPlot.getY();
		this.width = otherPlot.getWidth();
		this.depth = otherPlot.getDepth();
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Determines if the given plot instance is overlapped by the current plot.
	 * @param plot - the plot to test against and check if overlaps
	 * @return true if the two plots overlap, false otherwise
	 */
	public boolean overlaps(Plot plot)
	{
		int left = this.x;
		int right = this.x + this.width;
		int top = this.y;
		int bottom = this.y + this.depth;
		
		int left2 = plot.x;
		int right2 = plot.x + plot.width;
		int top2 = plot.y;
		int bottom2 = plot.y + plot.depth;
		
		if (right <= left2 || right2 <= left || bottom <= top2 || bottom2 <= top)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Determines if the given plot is encompassed by (is contained by) this plot. Note that the determination should be inclusive, in other words, if an edge lies on the edge of the current plot, this is acceptable.
	 * @param plot - the plot to test against and check if encompasses
	 * @return true if the given plot is encompassed by this plot, false otherwise
	 */
	public boolean encompasses(Plot plot)
	{
		int left = this.x;
		int right = this.x + this.width;
		int top = this.y;
		int bottom = this.y + this.depth;
		
		int left2 = plot.x;
		int right2 = plot.x + plot.width;
		int top2 = plot.y;
		int bottom2 = plot.y + plot.depth;
		
		if (left <= left2 && right >= right2 && top <= top2 && bottom >= bottom2)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Represents a Plot object in the following String format. x,y,width,depth
	 * @return the string representation of a plot.
	 */
	public String toString()
	{
		return this.x + "," + this.y + "," + this.width + "," + this.depth;
	}
}

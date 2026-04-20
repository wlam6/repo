/*
 * The external Tree Node for Linked Trees.
 * @param T - data type of TreeNode
 */
public class TreeNode<T>
{
	private T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	/*
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode)
	{
		left = null;
		right = null;
		data = dataNode;
	}
	
	/*
	 * used for making deep copies
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node)
	{
		this(node.data);
	}
	
	/*
	 * Return the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public T getData()
	{
		return data;
	}
}

/*
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english

It relies on a root (reference to root of the tree)

The root is set to null when the tree is empty.

The class uses an external generic TreeNode class which consists of a reference to the data and a reference to the left and right child. The TreeNode is parameterized as a String, TreeNode This class uses a private member root (reference to a TreeNode)

The constructor will call the buildTree
 */
import java.util.ArrayList;
public class MorseCodeTree extends java.lang.Object implements LinkedConverterTreeInterface<java.lang.String>
{
	private TreeNode<java.lang.String> root = new TreeNode<>("");
	
	/*
	 * Constructor - calls the buildTree method
	 */
	public MorseCodeTree()
	{
		buildTree();
	}
	
	/*
	 * Returns a reference to the root
	 * @return reference to root
	 */
	public TreeNode<java.lang.String> getRoot()
	{
		return root;
	}
	
	/*
	 * sets the root of the MorseCodeTree
	 * @param newNode - a newNode that will be the root of MorseCodeTree
	 */
	@Override
	public void setRoot(TreeNode<java.lang.String> newNode)
	{
		root = newNode;
	}
	
	/*
	 * Adds element to the correct position in the tree based on the code This method will call the recursive method addNode
	 * @param code - the code for the new node to be added, example ".-."
	 */
	@Override
	public void insert(java.lang.String code, java.lang.String letter)
	{
		addNode(root, code, letter);
	}
	
	/*
	 * This is a recursive method that adds element to the correct position in the tree based on the code.
	 * A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right.
	 * The code ".-" would be stored as the right child of the left child of the root Algorithm for the recursive method:
	 * 1.if there is only one character a. if the character is '.' (dot) store to the left of the current root b. if the character is "-" (dash) store to the right of the current root c. return
	 * 2. if there is more than one character a. if the first character is "." (dot) new root becomes the left child b. if the first character is "-" (dash) new root becomes the right child
	 * c. new code becomes all the remaining charcters in the code (beyond the first character) d. call addNode(new root, new code, letter)
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @param letter - the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<java.lang.String> root, java.lang.String code, java.lang.String letter)
	{
		// 1.if there is only one character
		if (code.length() == 1)
		{
			// a. if the character is '.' (dot) store to the left of the current root
			if (code.charAt(0) == '.')
			{
				root.left = new TreeNode<>(letter);
			}
			// b. if the character is "-" (dash) store to the right of the current root
			else if (code.charAt(0) == '-')
			{
				root.right = new TreeNode<>(letter);
			}
			// c. return
		}
		// 2. if there is more than one character
		else
		{
			// c. new code becomes all the remaining charcters in the code (beyond the first character)
			String newCode = code.substring(1);
			// a. if the character is '.' (dot) store to the left of the current root
			if (code.charAt(0) == '.')
			{
				// d. call addNode(new root, new code, letter)
				addNode(root.left, newCode, letter);
			}
			// b. if the first character is "-" (dash) new root becomes the right child
			if (code.charAt(0) == '-')
			{
				// d. call addNode(new root, new code, letter)
				addNode(root.right, newCode, letter);
			}
		}
	}
	
	/*
	 * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
	 * @param code - the code that describes the traversals to retrieve the string (letter)
	 * @return the string (letter) that corresponds to the code
	 */
	@Override
	public java.lang.String fetch(java.lang.String code)
	{
		return fetchNode(root, code);
	}
	
	/*
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code A '.' (dot) means traverse to the left.
	 * A "-" (dash) means traverse to the right. The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @return the string (letter) corresponding to the code
	 */
	@Override
	public java.lang.String fetchNode(TreeNode<java.lang.String> root, java.lang.String code)
	{
		if (code.length() == 0)
		{
			return root.getData();
		}
		else if (code.charAt(0) == '.')
		{
			return fetchNode(root.left, code.substring(1));
		}
		return fetchNode(root.right, code.substring(1));
	}
	
	/*
	 * This operation is not supported in the MorseCodeTree
	 */
	@Override
	public MorseCodeTree delete(java.lang.String data) throws java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	/*
	 * This operation is not supported in the MorseCodeTree
	 */
	@Override
	public MorseCodeTree update() throws java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	/*
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code.
	 * The root will have a value of "" (empty string) level one: insert(".", "e"); insert("-", "t");
	 * level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m"); etc. Look at the tree and the table of codes to letters in the assignment description.
	 */
	@Override
	public void buildTree()
	{
		// level one:
		insert(".", "e");
		insert("-", "t");
		// level two:
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		// level three:
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		// level four:
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}
	
	/*
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public java.util.ArrayList<java.lang.String> toArrayList()
	{
		java.util.ArrayList<java.lang.String> list = new ArrayList<>();
		LNRoutputTraversal(root, list);
		return list;
	}
	
	/*
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<java.lang.String> root, java.util.ArrayList<java.lang.String> list)
	{
		// Inorder Traversal: Left, Root, Right
		if (root != null)
		{
			LNRoutputTraversal(root.left, list);
			list.add(root.getData());
			LNRoutputTraversal(root.right, list);
		}
	}
}

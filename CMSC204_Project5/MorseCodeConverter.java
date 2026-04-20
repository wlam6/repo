/*
 * The MorseCodeConverter contains a static MorseCodeTree object and constructs (calls the constructor for) the MorseCodeTree.
 */
import java.util.ArrayList;
import java.util.Scanner;
public class MorseCodeConverter extends java.lang.Object
{
	static MorseCodeTree tree = new MorseCodeTree();
	
	public MorseCodeConverter()
	{
		 tree.buildTree();
	}
	
	/*
	 * returns a string with all the data in the tree in LNR order with an space in between them. Uses the toArrayList method in MorseCodeTree It should return the data in this order:
	 * "h s v i f u e l r a p w j b d x n c k y t z g q m o"
     * Note the extra space between j and b - that is because there is an empty string that is the root, and in the LNR traversal, the root would come between the right most child of the left tree (j)
     * and the left most child of the right tree (b). This is used for testing purposes to make sure the MorseCodeTree has been built properly
     * @returns the data in the tree in LNR order separated by a space.
	 */
	public static java.lang.String printTree()
	{
		ArrayList<String> list = tree.toArrayList();
		String data = "";
		for (String code : list)
		{
			data += code + " ";
		}
		return data.trim();
	}
	
	/*
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * Example: code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." string returned = "Hello World"
	 * @param code - the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish​(String code)
	{
		String english = "";
		String newCode = "";
		for (int i = 0; i < code.length(); i++)
		{
			if (code.charAt(i) == ' ')
			{
				english += tree.fetch(newCode);
				newCode = "";
			}
			else if (code.charAt(i) == '/')
			{
				english += " ";
			}
			else
			{
				newCode += code.charAt(i);
			}
		}
		// gets last letter
		english += tree.fetch(newCode);
		return english;
	}
	
	/*
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
	 * Example: code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." string returned = "Hello World"
	 * @param codeFile - name of the File that contains Morse Code
	 * @return the English translation of the file
	 */
	public static java.lang.String convertToEnglish​(java.io.File codeFile) throws java.io.FileNotFoundException
	{
		/*Make sure howDoILoveThee.txt is in the src directory for this 
		  test to pass
		*/
		Scanner input = new Scanner(codeFile);
		String output = convertToEnglish​(input.nextLine());
		input.close();
		return output;
	}
}

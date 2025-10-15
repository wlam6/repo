/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi 
 * Description: Encrypts and decrypts in vigenere, playfair, and caesar cipher. 
 * Due: 10/14/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: William Lam
*/


public class CryptoManager { 

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher  
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Vigenere Cipher is a method of encrypting alphabetic text 
	 * based on the letters of a keyword. It works as below:
	 * 		Choose a keyword (e.g., KEY).
	 * 		Repeat the keyword to match the length of the plaintext.
	 * 		Each letter in the plaintext is shifted by the position of the 
	 * 		corresponding letter in the keyword (A = 0, B = 1, ..., Z = 25).
	 */   

    public static String vigenereEncryption(String plainText, String key) {
        String newString = "";
        String keyString = "";
        
    	if (!isStringInBounds(plainText))
    	{
    		return "The selected string is not in bounds, Try again.";
    	}
    	else
    	{
    		// Repeat the keyword to match the length of the plaintext.
            for (int i = 0; i < plainText.length(); i++)
            {
            	keyString += key.charAt(i % key.length());
            }
            
            // Add plainText character to keyString character to get Vigenere Cipher for each character
    		for (int i = 0; i < plainText.length(); i++)
        	{
    			int plainTextChar = ALPHABET64.indexOf(plainText.charAt(i));
    			int keyChar = ALPHABET64.indexOf(keyString.charAt(i));
        		newString += ALPHABET64.charAt((plainTextChar + keyChar) % ALPHABET64.length());
        	}
    	}
    	return newString;
    }

    // Vigenere Decryption
    public static String vigenereDecryption(String encryptedText, String key) {
    	// Repeat the keyword to match the length of the plaintext.
    	String newString = "";
        String keyString = "";
        for (int i = 0; i < encryptedText.length(); i++)
        {
        	keyString += key.charAt(i % key.length());
        }
        
        // Subtract plainText character to keyString character to decode Vigenere Cipher for each character
		for (int i = 0; i < encryptedText.length(); i++)
    	{
			int encryptedTextChar = ALPHABET64.indexOf(encryptedText.charAt(i));
			int keyChar = ALPHABET64.indexOf(keyString.charAt(i));
			// + ALPHABET64.length() prevents negative index
    		newString += ALPHABET64.charAt(((encryptedTextChar - keyChar) % ALPHABET64.length()));
    	}
		return newString;
    }


	/**
	 * Playfair Cipher encrypts two letters at a time instead of just one.
	 * It works as follows:
	 * A matrix (8X8 in our case) is built using a keyword
	 * Plaintext is split into letter pairs (e.g., ME ET YO UR).
	 * Encryption rules depend on the positions of the letters in the matrix:
	 *     Same row: replace each letter with the one to its right.
	 *     Same column: replace each with the one below.
	 *     Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
	 */    

    public static String playfairEncryption(String plainText, String key) 
    {
    	char[][] matrix = new char[8][8];
    	int index = 0;
    	int alphabetIndex = 0;
    	String encryptedText = "";
    	
    	// Implement key into plain text
    	for (int r = 0; r < 8; r++)
    	{
    		for (int c = 0; c < 8; c++)
    		{
    			// Get all characters from key, then go to alphabet
    			if (index < key.length())
    			{
	    			matrix[r][c] = key.charAt(index);
	    			index++;
    			}
    			else
    			{
    				matrix[r][c] = ALPHABET64.charAt(alphabetIndex % ALPHABET64.length());
    			}
    		}
    	}
    	
    	// Split the plain text into letter pairs
    	for (int i = 0; i < plainText.length(); i++)
    	{
    		// Same row: replace each letter with the one to its right.
        	if (matrix[plainText.charAt(i)% 8] == matrix[plainText.charAt(i+1)% 8])
        	{
        		encryptedText += matrix[plainText.charAt(i)][(plainText.charAt(i+1) + 1) % 8] + matrix[plainText.charAt(i)][(plainText.charAt(i+1) + 1) % 8];
        	}
        	// Same column: replace each with the one below
        	else if (matrix[plainText.charAt(i)% 8] == matrix[plainText.charAt(i+1)% 8])
        	{
        		encryptedText += matrix[(plainText.charAt(i) + 1)% 8][plainText.charAt(i+1)] + matrix[plainText.charAt(i+1) + 1 % 8][plainText.charAt(i + 1)];
        	}
        	// Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
        	else
        	{
        		encryptedText += matrix[plainText.charAt(i)][plainText.charAt(i+1)] + matrix[plainText.charAt(i+1)][plainText.charAt(i)];
        	}
    	}
    	return encryptedText;
    }

    // Playfair Decryption
    public static String playfairDecryption(String encryptedText, String key) {
         //to be implemented by students
    	char[][] matrix = new char[8][8];
    	int index = 0;
    	int alphabetIndex = 0;
    	String plainText = "";
    	
    	// Implement key into plain text
    	for (int r = 0; r < 8; r++)
    	{
    		for (int c = 0; c < 8; c++)
    		{
    			// Get all characters from key, then go to alphabet
    			if (index < key.length())
    			{
	    			matrix[r][c] = key.charAt(index);
	    			index++;
    			}
    			else
    			{
    				matrix[r][c] = ALPHABET64.charAt(alphabetIndex % ALPHABET64.length());
    			}
    		}
    	}
    	
    	// Split the plain text into letter pairs
    	for (int i = 0; i < encryptedText.length(); i++)
    	{
    		// Same row: replace each letter with the one to its right. To decrypt shift left
        	if (matrix[encryptedText.charAt(i)% 8] == matrix[encryptedText.charAt(i+1)% 8])
        	{
        		encryptedText += matrix[encryptedText.charAt(i)][(encryptedText.charAt(i+1) - 1) % 8] + matrix[encryptedText.charAt(i)][(encryptedText.charAt(i+1) - 1) % 8];
        	}
        	// Same column: replace each with the one below. To decrypt shift up
        	else if (matrix[encryptedText.charAt(i)% 8] == matrix[encryptedText.charAt(i+1)% 8])
        	{
        		encryptedText += matrix[(encryptedText.charAt(i) - 1)% 8][encryptedText.charAt(i+1)] + matrix[encryptedText.charAt(i+1) - 1 % 8][encryptedText.charAt(i + 1)];
        	}
        	// Rectangle: replace each letter with the one in its own row but in the column of the other letter in the pair.
        	else
        	{
        		encryptedText += matrix[encryptedText.charAt(i)][encryptedText.charAt(i+1)] + matrix[encryptedText.charAt(i+1)][encryptedText.charAt(i)];
        	}
    	}
    	return plainText;
    }

    /**
     * Caesar Cipher is a simple substitution cipher that replaces each letter in a message 
     * with a letter some fixed number of positions down the alphabet. 
     * For example, with a shift of 3, 'A' would become 'D', 'B' would become 'E', and so on.
     */    
 
    public static String caesarEncryption(String plainText, int key) {
    	String newString = "";
    	for (int i = 0; i < plainText.length(); i++)
    	{
    		// Add key to the ALPHABET64 character index then add to final string
    		int oldIndex = ALPHABET64.indexOf(plainText.charAt(i));
    		newString += ALPHABET64.charAt((oldIndex + key)% ALPHABET64.length());
    	}
    	return newString;
    }

    // Caesar Decryption
    public static String caesarDecryption(String encryptedText, int key) {
    	String newString = "";
    	for (int i = 0; i < encryptedText.length(); i++)
    	{
    		// Subtract key from the ALPHABET64 character index then add to final string
    		int oldIndex = ALPHABET64.indexOf(encryptedText.charAt(i));
    		newString += ALPHABET64.charAt((oldIndex - key)% ALPHABET64.length());
    	}
    	return newString;
    }    

}

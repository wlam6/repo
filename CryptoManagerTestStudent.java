/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi 
 * Description: Test cases of CryptoManager
 * Due: 10/14/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: William Lam
*/

import junit.framework.TestCase;

public class CryptoManagerTestStudent extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
    public void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("TEST STRING"));
        assertFalse(CryptoManager.isStringInBounds("test String"));
        assertFalse(CryptoManager.isStringInBounds("1tes string"));
    }

	public void testVigenereEncryptDecrypt() {
        String plain = "String";
        String key = "key1";
        String encrypted = CryptoManager.vigenereEncryption(plain, key);
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        assertEquals(plain, decrypted);
    }
    
    public void testPlayfairEncryptDecrypt() {
        String plain = "Keyword";
        String key = "test";
        String encrypted = CryptoManager.playfairEncryption(plain, key);
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);
        assertEquals(plain, decrypted);
    }
    
    public void testCaesarEncryptDecrypt() {
        String plain = "montgomery college";
        int key = 3;
        String encrypted = CryptoManager.caesarEncryption(plain, key);
        String decrypted = CryptoManager.caesarDecryption(encrypted, key);
        assertEquals(plain, decrypted);
    }

}

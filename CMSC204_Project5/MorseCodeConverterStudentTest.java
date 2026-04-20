 
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterStudentTest {
	
	@Test
	public void testAlphabet() {	
		String morseCode = MorseCodeConverter.convertToEnglish​(".- -... -.-. -.. . ..-. --. .... .. .--- -.- / .-.. -- -. --- .--. --.- / .-. ... - ..- ...- .-- -..- -.-- --..");
		assertEquals("abcdefghijk lmnopq rstuvwxyz", morseCode);
	}
	
	@Test
	public void testEmpty() {	
		String morseCode = MorseCodeConverter.convertToEnglish​("");
		assertEquals("", morseCode);
	}
	
	@Test
	public void testWhiteSpace() {	
		String morseCode = MorseCodeConverter.convertToEnglish​("          .-     ");
		assertEquals("a", morseCode);
	}
	
	@Test
	public void testWhiteSpace2() {	
		String morseCode = MorseCodeConverter.convertToEnglish​("                ");
		assertEquals("", morseCode);
	}
}

package pj5;


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeConverterTest {
   

    @Before
    public void setUp() {
        
    }

    @After
    public void tearDown() {
        
    }

    

    @Test
    public void testConvertToText() {
        String morseCode = ".... . .-.. .-.. ---";
        String expectedText = "hello";
        String actualText = MorseCodeConverter.convertToEnglish(morseCode);
        assertEquals(expectedText, actualText);
    }

    @Test
    public void testConvertToText_one() {
        String morseCode = ".-- --- .-. .-.. -..";
        String expectedText = "world";
        String actualText = MorseCodeConverter.convertToEnglish(morseCode);
        assertEquals(expectedText, actualText);
    }

    @Test
    public void testConverToText_Two(){

        String word2 = MorseCodeConverter.convertToEnglish(".-- .... .- - / -.. .- -.-- / .. ... / - --- -.. .- -.--");
		assertEquals("what day is today", word2);
    }
    
    @Test
    public void testConvertFile(){
        File codeFile = new File("src/LoveLooksNot.txt");
        try {
            String file2=MorseCodeConverter.convertToEnglish(codeFile);
            assertEquals("love looks not with the eyes but with the mind", file2);
        } catch (FileNotFoundException e) {
            assertTrue("This should not have caused an FileNotFoundException", false);
        }
		
    }

    @Test
	public void testConvertToEnglishString() {
		String getMorsed = MorseCodeConverter.convertToEnglish("-- -.-- / -. .- -- . / .. ... / -- .- .--- -..");
		assertEquals(getMorsed,"my name is majd");
		
	}


}
    


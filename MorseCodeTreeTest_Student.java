package pj5;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class MorseCodeTreeTest_Student {
 
    MorseCodeTree tree;
	TreeNode<String> newNode = new TreeNode<>("RANDOM");

	@Before
	public void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}
	
	

	@Test
	public void fetchTest() {
		assertTrue(tree.fetch(".-..").equals("l"));
		assertTrue(tree.fetch("...-").equals("v"));
		assertTrue(tree.fetch(".--.").equals("p"));
		assertTrue(tree.fetch("..-.").equals("f"));
		assertTrue(tree.fetch(".---").equals("j"));
		
		assertTrue(tree.fetch("-.-.").equals("c"));
		assertTrue(tree.fetch("--..").equals("z"));
		assertTrue(tree.fetch("---").equals("o"));
		assertTrue(tree.fetch("--.").equals("g"));
		assertTrue(tree.fetch("-..").equals("d"));
	}
	
	@Test
	public void insertTest() {
		tree.insert("----", "NotValidCode, But In Tree!");
		assertTrue(tree.fetch("----").equals("NotValidCode, But In Tree!"));
		tree.insert("----.", "Random");
		assertTrue(tree.fetch("----.").equals("Random"));
	}
	
	@Test
    public void deleteTest() {
        tree.insert("----", "NotValidCode, But In Tree!");
        assertTrue(tree.fetch("----").equals("NotValidCode, But In Tree!"));
        try {
            tree.delete("----");
        } catch (UnsupportedOperationException e) {
            assertTrue("This should not have caused an UnsupportedOperationException", true);
        }
        
    }

    @Test
    public void updateTest() {
        try {
            tree.update();
        } catch (UnsupportedOperationException e) {
            assertTrue("This should not have caused an UnsupportedOperationException", true);
        }
    }

    @Test
    public void buildTreeTest() {
        try {
            tree.buildTree();
        } catch (UnsupportedOperationException e) {
            assertTrue("This should not have caused an UnsupportedOperationException", true);
        }
    }

  
    

}

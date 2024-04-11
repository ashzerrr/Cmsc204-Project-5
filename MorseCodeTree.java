
package pj5;


import java.util.ArrayList;

/**
 * MorseCodeTree class implements LinkedConverterTreeInterface<String>
 * Represents a binary tree for Morse code conversion.
 * Each node stores a letter of the alphabet or a null character.
 * 
 * Author: Ashton Kabou
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	private TreeNode<String> root;
	
	/**
	 * Default constructor initializes the root and builds the Morse code tree.
	 */
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	
	/**
	 * Returns the reference to the root node of the Morse code tree.
	 * @return the root node of the tree
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}
	
	/**
	 * Sets the root of the Morse code tree.
	 * @param newNode the node to be set as the root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<String>(newNode);
	}

	/**
	 * Inserts a letter at the correct position in the Morse code tree based on its code.
	 * Calls the addNode() method for insertion.
	 * @param code the Morse code of the letter
	 * @param letter the letter to be added
	 */
	@Override
	public void insert(String code, String letter) {
		addNode(root, code, letter);
	}

	/**
	 * Recursively adds a node at the correct position based on the Morse code.
	 * Traverses left if the code is ".", right if the code is "-".
	 * @param root the current root of the tree
	 * @param code the Morse code of the letter
	 * @param letter the letter to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.length() > 1) {
			if (code.charAt(0) == '-') {
				addNode(root.rightChild, code.substring(1), letter);
			} else {
				addNode(root.leftChild, code.substring(1), letter);
			}
		} else {
			if (code.equals(".")) {
				root.leftChild = new TreeNode<String>(letter);
			} else {
				root.rightChild = new TreeNode<String>(letter);
			}
		}
	}

	/**
	 * Returns the letter corresponding to the given Morse code.
	 * Calls the fetchNode() method for retrieval.
	 * @param code the Morse code to be converted
	 * @return the letter corresponding to the code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
	 * Recursively fetches the data from the tree that corresponds to the Morse code.
	 * @param rootNode the current root of the tree
	 * @param morseCode the Morse code to be converted
	 * @return the letter corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> rootNode, String morseCode) {
		String morseLetter = "";
		if (morseCode.length() > 1) {
			if (morseCode.charAt(0) == '.') {
				morseLetter += fetchNode(rootNode.leftChild, morseCode.substring(1));
			} else {
				morseLetter += fetchNode(rootNode.rightChild, morseCode.substring(1));
			}
		} else {
			if (morseCode.equals(".")) {
				morseLetter += rootNode.leftChild.getData();
			} else { 
				morseLetter += rootNode.rightChild.getData();
			}
		}
		return morseLetter;
	}

	/**
	 * This operation is unsupported by MorseCodeTree.
	 * Throws an UnsupportedOperationException when called.
	 * @throws UnsupportedOperationException when called
	 * @param data the data of the node to delete
	 * @return reference to the current tree
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is unsupported by MorseCodeTree.
	 * Throws an UnsupportedOperationException when called.
	 * @throws UnsupportedOperationException when called
	 * @return reference to the current tree
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Inserts nodes into the Morse code tree level by level from left to right.
	 */
	@Override
	public void buildTree() {
		insert("", "");
		insert(".", "e"); insert("-", "t");
		insert("..", "i"); insert(".-", "a");
		insert("-.", "n"); insert("--", "m");
		insert("...", "s"); insert("..-", "u");
		insert(".-.", "r"); insert(".--", "w");
		insert("-..", "d"); insert("-.-", "k");
		insert("--.", "g"); insert("---", "o");
		insert("....", "h"); insert("...-", "v");
		insert("..-.", "f"); insert(".-..", "l");
		insert(".--.", "p"); insert(".---", "j");
		insert("-...", "b"); insert("-..-", "x");
		insert("-.-.", "c"); insert("-.--", "y");
		insert("--..", "z"); insert("--.-", "q");
	}

	/**
	 * Returns items of the Morse code tree in LNR order.
	 * @return an ArrayList of items in the tree 
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(getRoot(), list);
		return list;
	}

	/**
	 * Recursively orders items in the Morse code tree in in-order traversal.
	 * @param root the current root of the tree
	 * @param list an ArrayList to store ordered items of the tree
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root.leftChild != null) {
			LNRoutputTraversal(root.leftChild, list);
		}
		if (root.leftChild == null && root.rightChild == null) {
			list.add(root.getData());
		}
		if (root.rightChild != null) {
			LNRoutputTraversal(root.rightChild, list);
		}
	}
}
	
	
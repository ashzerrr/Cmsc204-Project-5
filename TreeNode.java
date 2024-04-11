package pj5;

/**
 * TreeNode class represents a node in a binary tree.
 * This class is parameterized by type <T>.
 * @param <T> the type of data stored in the node
 * 
 * @author Ashton Kabou
 */
public class TreeNode<T> {
    private T data;
    protected TreeNode<T> leftChild;
    protected TreeNode<T> rightChild;
    
    /**
     * Constructs a new tree node with the given data.
     * The left and right children are initialized to null.
     * 
     * @param dataNode the data to be stored in the tree node
     */
    public TreeNode(T dataNode) {
        data = dataNode;
        leftChild = null;
        rightChild = null;
    }
    
    /**
     * Constructs a new tree node by making a deep copy of another node.
     * 
     * @param node the node to be copied
     */
    public TreeNode(TreeNode<T> node) {
        this(node.leftChild, node.rightChild, node.getData());
    }
    
    /**
     * Constructs a new tree node with the given data, left child, and right child.
     * 
     * @param left the left child of the node
     * @param right the right child of the node
     * @param info the data stored in the node
     */
    public TreeNode(TreeNode<T> left, TreeNode<T> right, T info) {        
        data = info;
        leftChild = new TreeNode<T>(left);
        rightChild = new TreeNode<T>(right);
    }
    
    /**
     * Returns the data stored in the tree node.
     * 
     * @return the data stored in the node
     */
    public T getData() {
        return data;
    }

}


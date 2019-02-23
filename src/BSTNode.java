/**
 * Class for BSTNode used by BST Tree
 * @author tsingh
 * @version 2019
 * @param <T> Generic class
 */
public class BSTNode<T> {
    
    /**
     * Fields for BSTNode
     */
    private T element;
    private BSTNode<T> leftNode;
    private BSTNode<T> rightNode;
    
    /**
     * BSTNode constructor
     * @param elem element for node
     */
    public BSTNode(T elem)
    {
        element = elem;
        leftNode = null;
        rightNode = null;
    }
    
    /**
     * Method to get Element
     * @return T element
     */
    public T getElement()
    {
        return element;
    }
    
    /**
     * Method to get left node
     * @return left node
     */
    public BSTNode<T> getLeftNode()
    {
        return leftNode;
    }
    
    /**
     * Method to get right node
     * @return right node
     */
    public BSTNode<T> getRightNode()
    {
        return rightNode;
    }
    
    /**
     * set Element method
     * @param elem the element to be set
     */
    public void setElement(T elem)
    {
        element = elem;
    }
    
    /**
     * Method to set left node
     * @param left left node
     */
    public void setLeftNode(BSTNode<T> left)
    {
        leftNode = left;
    }
    
    /**
     * Method to set Right node
     * @param right node
     */
    public void setRightNode(BSTNode<T> right)
    {
        rightNode = right;
    }
    
    /**
     * Method to turn node into string
     * @return return a String
     */
    public String toString()
    {
        return element.toString();
    }
    
}

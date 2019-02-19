
public class BSTNode<T> {
    
    private T element;
    private BSTNode<T> leftNode;
    private BSTNode<T> rightNode;
    
    public BSTNode(T elem)
    {
        element = elem;
        leftNode = null;
        rightNode = null;
    }
    
    public T getElement()
    {
        return element;
    }
    
    public BSTNode<T> getLeftNode()
    {
        return leftNode;
    }
    
    public BSTNode<T> getRightNode()
    {
        return rightNode;
    }
    
    public void setElement(T elem)
    {
        element = elem;
    }
    
    public void setLeftNode(BSTNode<T> left)
    {
        leftNode = left;
    }
    
    public void setRightNode(BSTNode<T> right)
    {
        rightNode = right;
    }
    
    public String toString()
    {
        return element.toString();
    }
    
}


public class BST<T extends Comparable<? super T>> {
    
    private BSTNode<T> rootNode;
    
    public BST()
    {
        rootNode = null;
    }
    
    public void insert(T newElem)
    {
        rootNode = insertHelper(newElem, rootNode);
    }
    
    public void remove(T targetElem)
    {
        rootNode = removeHelper(targetElem, rootNode);
    }
    
    private BSTNode<T> insertHelper(T newElem, BSTNode<T> node)
    {
        if (node == null)
        {
            return new BSTNode<T>(newElem);
        }
        
        else if (newElem.compareTo(node.getElement()) < 0)
        {
            node.setLeftNode(insertHelper(newElem, node.getLeftNode()));
        }
        
        // nodes with greater than or equal to toString() values are inserted to the right 
        else
        {
            node.setRightNode(insertHelper(newElem, node.getRightNode()));
        }
        
        return node;
    }
    
    private BSTNode<T> removeHelper(T targetElem, BSTNode<T> node)
    {
        // This local variable will contain the new root of the subtree,
        // if the root needs to change.
        BSTNode<T> result = node;

        // If there's no more subtree to examine
        //if (node == null)
        //{
         //   throw new ItemNotFoundException(x.toString());
        //}

        // if value should be to the left of the root
        if (targetElem.compareTo(node.getElement()) < 0)
        {
            node.setLeftNode(removeHelper(targetElem, node.getLeftNode()));
        }
        // if value should be to the right of the root
        else if (targetElem.compareTo(node.getElement()) > 0)
        {
            node.setRightNode(removeHelper(targetElem, node.getRightNode()));
        }
        // If value is on the current node
        else
        {
            // If there are two children
            if (node.getLeftNode() != null && node.getRightNode() != null)
            {
                BSTNode<T> leftNode = node.getLeftNode();
                BSTNode<T> leftMin = this.getMin(leftNode);
                node.setElement(leftMin.getElement());
                BSTNode<T> removed = removeHelper(leftMin.getElement(), leftMin);
                node.setLeftNode(removed);

            }
            // If there is only one child on the left
            else if (node.getLeftNode() != null)
            {
                result = node.getLeftNode();
            }
            // If there is only one child on the right
            else
            {
                result = node.getRightNode();
            }
        }
        return result;
    }
    
    /**
     * 
     * @param node the node that roots the tree
     * @return the leftmost node
     */
    private BSTNode<T> getMin(BSTNode<T> node)
    {
        if (node == null)
        {
            return node;
        }
        else if (node.getLeftNode() == null)
        {
            return node;
        }
        else
        {
            return getMin(node.getLeftNode());
        }
    }
}

/**
 * BST Class
 * @author tsingh
 * @version 2019
 * @param <T> Generic
 */
public class BST<T extends Comparable<? super T>> {
    
    /**
     * Fields for tree
     */
    private BSTNode<T> rootNode;
    private Iterator<T> iterator;
    
    /**
     * BST Constructor
     */
    public BST()
    {
        rootNode = null;
        iterator = new Iterator<T>(rootNode);
    }
    
    /**
     * BSTNode root return
     * @return BSTNode<T> the bst node
     */
    public BSTNode<T> getRootNode()
    {
        return rootNode;
    }
    
    /**
     * Iterator return 
     * @return Iterator<T> the iterator
     */
    public Iterator<T> getIterator()
    {
        return iterator;
    }
    
    /**
     * Method to insert element
     * @param newElem element to be inserted
     */
    public void insert(T newElem)
    {
        rootNode = insert(newElem, rootNode);
    }
    
    /**
     * Method to remove element
     * @param targetElem target element to remove
     */
    public void remove(T targetElem)
    {
        rootNode = remove(targetElem, rootNode);
    }
    
    /**
     * Dump method
     * @return String with tree dump
     */
    public String dump()
    {
        StringBuilder dump = new StringBuilder();
        dump.append("BST dump:\n");
        dump.append(treeDump(rootNode));
        dump.append("BST size is: ");
        dump.append(size());
        return dump.toString();
    }
    
    // precondition: node exists in BST (not null)
    /**
     * Method to dump tree
     * @param node starting node
     * @return String with tree dump
     */
    private String treeDump(BSTNode<T> node)
    {
        StringBuilder dump = new StringBuilder();
        int nodeDepth = findDepth(node);
        dump.append("Node has depth " + nodeDepth + ", Value ");
        
        if (node == null)
        {
            dump.append("(null)\n");
        }
        
        else
        {
            dump.append(node.toString());
            dump.append("\n");
            if (node.getLeftNode() != null)
            {
                dump.append(treeDump(node.getLeftNode()));
            }
        
            if (node.getRightNode() != null)
            {
                dump.append(treeDump(node.getRightNode()));
            }
        }
        return dump.toString();
    }
    
    /**
     * Method to get depth
     * @param targetNode target Node
     * @return int Depth
     */
    private int findDepth(BSTNode<T> targetNode)
    {
        if (targetNode == null)
        {
            return 0;
        }
        return findDepth(rootNode, targetNode);
    }
    
    // helper method for findDepth
    /**
     * Helpter method for findDepth
     * @param currNode current Node
     * @param targetNode target Node
     * @return int depth
     */
    private int findDepth(BSTNode<T> currNode, BSTNode<T> targetNode)
    {
        if (currNode.equals(targetNode))
        {
            return 0;
        }
        
        if (targetNode.getElement().compareTo(currNode.getElement()) < 0)
        {
            return 1 + findDepth(currNode.getLeftNode(), targetNode);
        }
        
        else
        {
            return 1 + findDepth(currNode.getRightNode(), targetNode); 
        }
    }
    
    /**
     * method to get size
     * @return int size
     */
    private int size()
    {
        if (rootNode == null)
        {
            return 0;
        }
        
        return size(rootNode);
    }
    
    // helper method for insert
    /**
     * Method to insert
     * @param newElem the new element
     * @param node the node
     * @return BSTNode<T> the bst node
     */
    private BSTNode<T> insert(T newElem, BSTNode<T> node)
    {
        if (node == null)
        {
            return new BSTNode<T>(newElem);
        }
        
        else if (newElem.compareTo(node.getElement()) < 0)
        {
            node.setLeftNode(insert(newElem, node.getLeftNode()));
        }
        
        // nodes with greater than or 
        //equal to toString() values are inserted to the right 
        else
        {
            node.setRightNode(insert(newElem, node.getRightNode()));
        }
        
        return node;
    }
    
    // helper method for remove
    /**
     * Helper method
     * @param targetElem the target element
     * @param node targt node
     * @return BSTNode<T> to remove
     */
    private BSTNode<T> remove(T targetElem, BSTNode<T> node)
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
            node.setLeftNode(remove(targetElem, node.getLeftNode()));
        }
        // if value should be to the right of the root
        else if (targetElem.compareTo(node.getElement()) > 0)
        {
            node.setRightNode(remove(targetElem, node.getRightNode()));
        }
        // If value is on the current node
        else
        {
            if (targetElem == node.getElement()) {
                if (node.getLeftNode() != null && node.getRightNode() != null)
                {
                    BSTNode<T> leftNode = node.getLeftNode();
                    BSTNode<T> leftMin = this.getMin(leftNode);
                    node.setElement(leftMin.getElement());
                    BSTNode<T> removed = remove(leftMin.getElement(), leftMin);
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
            else
            {
                node.setRightNode(remove(targetElem, node.getRightNode()));
            }
            // If there are two children
            
        }
        return result;
    }
    
    /**
     * Method to get minimum of subtree
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
    
    /**
     * Calculate the size of this binary tree.
     * @return The size of this tree.
     */
    // helper method for size
    private int size(BSTNode<T> node)
    {
        int leftNum = 0;
        int rightNum = 0;
        
        if (node.getLeftNode() != null)
        {
            leftNum = size(node.getLeftNode());
        }
        
        if (node.getRightNode() != null)
        {
            rightNum = size(node.getRightNode());
        }
        
        return 1 + leftNum + rightNum;
        
        
        //Base case: current node has 0 children
        
        //Recursive Case 1: current node has 1 child on the left
        //Recursive Case 2: current node has 1 child on the right
        //Recursive Case 3: current node has 2 children
    }
    
}

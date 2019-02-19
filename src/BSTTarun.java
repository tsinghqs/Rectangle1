import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTTarun<T extends Comparable<? super T>> {
    
    private BSTNode<T> rootNode;
    
    public BSTTarun()
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
    
    public int size()
    {
        if (rootNode == null)
        {
            return 0;
        }
        
        return sizeHelper(rootNode);
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
    
    /**
     * Calculate the size of this binary tree.
     * @return The size of this tree.
     */
    private int sizeHelper(BSTNode<T> node)
    {
        int leftNum = 0;
        int rightNum = 0;
        
        if (node.getLeftNode() != null)
        {
            leftNum = sizeHelper(node.getLeftNode());
        }
        
        if (node.getRightNode() != null)
        {
            rightNum = sizeHelper(node.getRightNode());
        }
        
        return 1 + leftNum + rightNum;
        
        
        //Base case: current node has 0 children
        
        //Recursive Case 1: current node has 1 child on the left
        //Recursive Case 2: current node has 1 child on the right
        //Recursive Case 3: current node has 2 children
    }
    
    public ArrayList<Rectangle> Search(String name)
    {
        Iterator iter = new Iterator(rootNode);
        ArrayList<Rectangle> ans = new ArrayList<Rectangle>();
        while (iter.hasNext())
        {
            BSTNode<Rectangle> compare = (BSTNode<Rectangle>)iter.next();
            if (compare.getElement().getName().equals(name))
            {
                ans.add(compare.getElement());
            }
        }
        
        
        return ans;
       
        
    }
    
    private class Iterator{
        
        private BSTNode<T> next;
        private Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();

        
        public Iterator(BSTNode<T> root) {
            if (root == null)
            {
                return;
            }
            next = root;
            if (next == null)
            {
                return;
            }
            while (next.getLeftNode() != null)
            {
                stack.push(next.getLeftNode());
                next = next.getLeftNode();
            }
        }
        
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        public BSTNode<T> next() {
            BSTNode<T> rst = stack.pop();
            
            if (rst.getRightNode() != null) {
                BSTNode<T> node = rst.getRightNode();
                stack.push(node);
                while (node.getLeftNode() != null) {
                    stack.push(node.getLeftNode());
                    node = node.getLeftNode();
                }            
            }
            return rst;
            
            
        }
    }
}

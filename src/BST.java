import java.util.ArrayList;
import java.util.Stack;

public class BST<T extends Comparable<? super T>> {
    
    BSTNode<T> rootNode;
    
    public BST()
    {
        rootNode = null;
    }
    
    public BSTNode<T> getRootNode()
    {
        return rootNode;
    }
    
    public void insert(T newElem)
    {
        rootNode = insert(newElem, rootNode);
    }
    
    public void remove(T targetElem)
    {
        rootNode = remove(targetElem, rootNode);
    }
    
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
    
    private int findDepth(BSTNode<T> targetNode)
    {
        if (targetNode == null)
        {
            return 0;
        }
        return findDepth(rootNode, targetNode);
    }
    
    // helper method for findDepth
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
    
    private int size()
    {
        if (rootNode == null)
        {
            return 0;
        }
        
        return size(rootNode);
    }
    
    // helper method for insert
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
        
        // nodes with greater than or equal to toString() values are inserted to the right 
        else
        {
            node.setRightNode(insert(newElem, node.getRightNode()));
        }
        
        return node;
    }
    
    // helper method for remove
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
            // If there are two children
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
    
    @SuppressWarnings("unchecked")
    public ArrayList<Rectangle> search(BSTNode<T> rootNode, String name)
    {
        Iterator iter = new Iterator(rootNode);
        ArrayList<Rectangle> ans = new ArrayList<Rectangle>();
        BSTNode<Rectangle> compare = (BSTNode<Rectangle>)iter.next();
        
        if (compare == null)
        {
            return ans;
        }
        
        if (compare.getElement().getName().equals(name))
        {
            ans.add(compare.getElement());
            while (compare.getRightNode() != null && compare.getRightNode().getElement().getName().equals(name))
            {
                compare = compare.getRightNode();
                ans.add(compare.getElement());
            }
            return ans;
        }
        
        if (compare.getElement().getName().compareTo(name) < 0)
        {
            if (compare.getRightNode() == null)
            {
                return ans;
            }
            return search((BSTNode<T>)compare.getRightNode(), name);
        }
        
        if (compare.getLeftNode() == null)
        {
            return ans;
        }
        
        return search((BSTNode<T>)compare.getLeftNode(), name);
        
    }
    
    public boolean remove(String name)
    {
        ArrayList<Rectangle> sameNames = search(rootNode, name);
        if (sameNames.size() == 0)
        {
            return false;
        }
        remove((T)sameNames.get(0));
        return true;
    }
    
    public boolean remove(int x, int y, int w, int h)
    {
        Iterator iter = new Iterator(rootNode);
        while (iter.hasNext())
        {
            BSTNode<Rectangle> currNode = (BSTNode<Rectangle>) iter.next();
            Rectangle currRectangle = currNode.getElement();
            boolean sameX = (currRectangle.getX() == x);
            boolean sameY = (currRectangle.getY() == y);
            boolean sameW = (currRectangle.getWidth() == w);
            boolean sameH = (currRectangle.getHeight() == h);
            if (sameX && sameY && sameW && sameH)
            {
                remove((T)currRectangle);
                return true;
            }
        }
        return false;
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
            stack.push(next);
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

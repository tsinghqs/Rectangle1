import java.util.Stack;

/**
 * Iterator class implemented in BST
 * @author tsingh
 *
 * @param <T> Generic class parameter
 */
public class Iterator<T> {
        
    /**
     * Fields for Iterator
     */
        private BSTNode<T> next;
        private Stack<BSTNode<T>> stack = new Stack<BSTNode<T>>();

        /**
         * Iterator constructor
         * @param root root node
         */
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
        
        /**
         * Method to check if there are more nodes
         * @return whether or not it's empty
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        
        /**
         * move to next node
         * @return next node
         */
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

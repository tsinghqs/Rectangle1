import java.util.Stack;

public class Iterator<T> {
        
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
